package de.usu.test.web.suite.testcase.xss;

import java.io.IOException;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.List;
import java.util.LongSummaryStatistics;

import org.openqa.selenium.Keys;
import org.openqa.selenium.UnhandledAlertException;
import de.usu.test.web.api.module.component.Toolbar.Perspective;
import de.usu.test.web.core.WebTestCase;

public class TilesXssTestCase extends WebTestCase {
	
	private static final String SCRIPT_SUFFIX = XssUtils.SCRIPT_SUFFIX;
	private XssUtils utils = new XssUtils();
	private List<String> scripts = new ArrayList<String>();
	
	public void testRun() throws IOException {
		
		//Loading random count of scripts from file (<script> alert(1);</script> is always included)
		//scripts = utils.getAllScripts();
		scripts = utils.getRandomScripts(10);
		
		//Find first tile for script injection
		String tileName = "My Assets";
		onToolbar().switchToBusinessView("End User");
		onToolbar().switchPerspectiveTo(Perspective.START);

		String userLoggedIn = onToolbar().getCurrentUserName().toLowerCase();		
		assertTrue("There is no scripts loaded from xss_scripts file! ", scripts.size()>0);
		
		Iterator<String> scriptIterator = scripts.iterator();
		//Looping through all scripts
			
		while(scriptIterator.hasNext()) {
			
			//Assigning a script to Tile as its name
			onStartPage().findConfigurePageAction().click();
			onStartPage().findTileEditButton(tileName).click();
			onStartPage().findTileLabel(tileName).clear();
			onStartPage().findTileLabel(tileName).sendKeys(scriptIterator.next() + SCRIPT_SUFFIX, Keys.ENTER);
			
			try {
				
				//Try to script being interpreted by clicking on tile, switching workspaces and logging out/in
				onStartPage().onTileList().findAndClickTile(SCRIPT_SUFFIX);
				
				waitFor(2); //There is thread sleep more "suitable" than expected conditions WD wait
				onCatalog().onCatalogPanel().findQuickSearchInput().sendKeys("hello"+Keys.ENTER);
				onWorkspace().closeAllWindows();
				onToolbar().switchPerspectiveTo(Perspective.WORK);
				onToolbar().switchPerspectiveTo(Perspective.START);
				onToolbar().logout();
				onLoginPage().loginAs(userLoggedIn, "vm");
				onToolbar().switchPerspectiveTo(Perspective.START);	
				
			} catch (UnhandledAlertException e) {
				
				//Logging script which causes alert to be displayed
				System.out.println("There was: "+e.getAlertText()+" message alerted - probability of successful script injection");
				System.out.println("Script: "+scriptIterator.next()+SCRIPT_SUFFIX);
			}
			//Find tile for another iteration by constant suffix
			tileName = SCRIPT_SUFFIX;
		}
	}		
}
