package de.usu.test.web.suite.testcase.interfaces;

import java.util.Date;
import org.openqa.selenium.Keys;
import de.usu.test.web.api.module.component.Toolbar.Perspective;
import de.usu.test.web.core.WebTestCase;
import de.usu.test.web.suite.testcase.interfaces.utils.GIHandler;
import io.restassured.response.Response;

public class CreateTicketFromExternalTestCase extends WebTestCase {	

	public static final String ENDPOINT = "http://localhost:8080/vmweb/services/api/execwf";
	private Response response;
	GIHandler genericHandler;
	private static final String NAME = "dummy";
	private static final String SURENAME = "dummy;

	public void testRun() {
		
		genericHandler = new GIHandler();
		genericHandler.onCreatePerson().onWrapper().setService("InterfaceTransactionStart");
		genericHandler.onCreatePerson().onPersonBody().setInterfaceActionName("VMEx_VM_CreatePerson_Basic");		
		genericHandler.onCreatePerson().onPersonBody().setJlastname(SURENAME);
		genericHandler.onCreatePerson().onPersonBody().setJfirstname(NAME);
		
		response = genericHandler.sendRequestAndGetResponse(
			genericHandler.onCreatePerson().getCreatePersonJsoned(),
			ENDPOINT
		);
		
		System.out.println(response.getContentType());
		
		//TODO 
		if(response.getStatusCode() != 200)
			WebTestCase.fail("Bad response code: " + response.getStatusCode());
		
		onToolbar().switchPerspectiveTo(Perspective.WORK);
		onToolbar().switchToBusinessView("End User");
		onTileList().findAndClickTile("Persons (All)");

		onCatalog().onCatalogPanel().findQuickSearchInput().sendKeys(SURENAME + Keys.ENTER);
		assertTrue(onCatalog().onCatalogPanel().isRecordPresent("lastname", SURENAME));
	}
}
