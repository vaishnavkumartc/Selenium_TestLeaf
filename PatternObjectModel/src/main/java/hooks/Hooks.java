package hooks;

import cucumber.api.java.*;
import wdMethods.SeMethods;

public class Hooks extends SeMethods {
	
	@Before
	public void before() {
		startResult();
		startTestModule("Lead", "Login leaftaps and work on leads");	
		test = startTestCase("Leads");
		test.assignCategory("Smoke");
		test.assignAuthor("Vaishnav");
		startApp("chrome");
	}
	
	
	@After
	public void after() {
		endResult();
		closeAllBrowsers();
	}

}
