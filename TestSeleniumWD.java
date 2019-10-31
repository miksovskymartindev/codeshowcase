package de.usu.test.web.suite.testcase.service;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import com.google.inject.Inject;
import de.usu.test.web.api.module.component.Package.ProgressBarTask.TaskState;
import de.usu.test.web.api.module.component.Toolbar.Perspective;
import de.usu.test.web.core.ClientManager;
import de.usu.test.web.core.WebTestCase;
	
public class TCD_2011 extends WebTestCase {
	
	@Inject	ServiceUtils srmUtils;
	Map<String, String> instServiceProps = new HashMap<String, String>();
	
	private String SERVICENAME;
	private String SERVICENAME_COPY;
	private String[] SERVICE_OPTIONS = ServiceUtils.SERVICE_OPTIONS;
	WebDriver driver = ClientManager.getInstance().getDriver();

	public void testRun() {
	
		ServiceUtils.stepStarted(5, "Log in web client");
		
		setServiceNames();
		setInstProps();
		onToolbar().switchPerspectiveTo(Perspective.WORK);
		onToolbar().switchToBusinessView(ServiceUtils.BV_SLM);
		
		ServiceUtils.stepStarted(10, "Copy Service template (if doesn't exists)");
		srmUtils.copyService(SERVICENAME);
		
		ServiceUtils.stepStarted(20, "Check Service Parameters");		
		srmUtils.checkServiceParams(SERVICE_OPTIONS);	
		
		ServiceUtils.stepStarted(30, "Check Pricing Models");
		srmUtils.checkPricingModels();
		
		ServiceUtils.stepStarted(40, "Change Service Name");
		srmUtils.changeServiceName(SERVICENAME_COPY);
		
		ServiceUtils.stepStarted(50, "Approve Service");
		srmUtils.approveService(SERVICENAME_COPY, "Service Templates (Top Only)");
		
		ServiceUtils.stepStarted(60, "Instantiate Service(s) Action");
		srmUtils.instantiateService(SERVICENAME_COPY);
		
		ServiceUtils.stepStarted(70, "Wizard: select Business Partner (Support Groups skipped)");
		assertEquals(TaskState.ACTIVE, onEditor().findProgressBarTask("Choose Business Partners").getTaskState());
		srmUtils.wizardClickNext();
		srmUtils.modalDialogYes();
		assertEquals(TaskState.ACTIVE, onEditor().findProgressBarTask("Choose Support Groups").getTaskState());
		assertEquals(onEditor().onTMV("Support Groups").getRecordsCountTotal(), 0);
		//Let customers empty, next
		srmUtils.wizardClickNext();	
		
		ServiceUtils.stepStarted(90, "Wizard: configurator tree");
		assertEquals(TaskState.DONE, onEditor().findProgressBarTask("Define default Pricing Model").getTaskState());
		assertEquals(TaskState.ACTIVE, onEditor().findProgressBarTask("Configure Service").getTaskState());
		srmUtils.wizardCheckConfTree(SERVICE_OPTIONS);
		srmUtils.wizardClickNext();

		ServiceUtils.stepStarted(100, "Wizard: select dates");
		assertEquals(TaskState.DONE, onEditor().findProgressBarTask("Select Service Offers").getTaskState());
		assertEquals(TaskState.ACTIVE, onEditor().findProgressBarTask("Select SLA").getTaskState());
		assertEquals(getDateStamp("MM/dd/YYYY"), onEditor().findField("instValidFrom").getValue());
		assertEquals(ServiceUtils.INFINITE_DATE, onEditor().findField("instValidTo").getValue());
		srmUtils.wizardClickNext();

		ServiceUtils.stepStarted(110, "Check Instantiated Services catalog");
		assertTrue(onWorkspace().getCurrentWindowTitle(false).contains("Catalog: Instantiated Services (Top Only)"));
		
		ServiceUtils.stepStarted(120, "Check the instantiated Service");
		onCatalog().onCatalogPanel().findRow(1).rightClick();
		onVMClient().findContextMenuAction("Edit").moveMouseOver();
		onVMClient().findContextMenuAction("Edit").click();
		srmUtils.checkInstProps(instServiceProps);
		srmUtils.checkInstPropsTMV("Service Parameters", "serviceParameterOption$optionname", "Platinum", true);
		srmUtils.checkInstPropsTMV("Delegated Parameters", "serviceParameterOption$optionname", "Platinum", true);
		srmUtils.checkInstPropsTMV("Subordinated Services", 1);
				
		ServiceUtils.stepStarted(130, "Change name of the instance - not possible on 5.2");
		onEditor().findActionButton(ServiceUtils.ActionButtons.EDITOR_OK_APPLY).click();
			
		ServiceUtils.stepStarted(140, "Check Services Instances catalog");
		srmUtils.openSidebarCatalog("Administration", "Catalogs", "Service Instances (Top Only)");
		assertTrue(onCatalog().onCatalogPanel().isRecordPresent("servicename", SERVICENAME_COPY));
		
		ServiceUtils.stepStarted(145, "Deleting created Service Instance");
		srmUtils.openSidebarCatalog("Administration", "Catalogs", "Service Instances (Top Only)");
		onCatalog().onCatalogPanel().findQuickSearchInput().sendKeys(SERVICENAME_COPY+Keys.ENTER);
		onCatalog().onCatalogPanel().findRow("servicename", SERVICENAME_COPY).rightClick();
	
		onVMClient().performContextMenuAction("Delete All Hierarchy");
		srmUtils.modalDialogYes();
	}
	
	private void setInstProps() {
		
		instServiceProps.put("servicename", SERVICENAME_COPY);
		instServiceProps.put("versionNo","2");
		instServiceProps.put("status", "Draft"); 
		instServiceProps.put("validfrom", getDateStamp("MM/dd/YYYY"));
		instServiceProps.put("validto", ServiceUtils.INFINITE_DATE);
		instServiceProps.put("serviceTemplate", SERVICENAME_COPY);
	}
	
	private void setServiceNames() {
		
		srmUtils.setServiceNamesAll("Standard Workplace");
		SERVICENAME = srmUtils.getServiceName();
		SERVICENAME_COPY = srmUtils.getServiceNameCopy();
	}
}
