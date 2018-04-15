package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LoginPage;
import wdMethods.ProjectMethods;

public class RadioButton extends ProjectMethods{
	@BeforeTest
	public void setData() {
		testCaseName="TC001_createLead";
		testDescription="login to LeafTaps And createlead";
		testNodes="Leads";
		category="Smoke";
		authors="vaishnav";
		browserName="chrome";
		dataSheetName="TC001";
	}
	@Test
	public void loginAndLogout() {
		
		new pages.RadioButton()
		.swithcToFrame()
		.clickMale();
		
	}

}
