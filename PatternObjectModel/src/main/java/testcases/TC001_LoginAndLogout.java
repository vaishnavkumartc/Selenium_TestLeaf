package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LoginPage;
import wdMethods.ProjectMethods;

public class TC001_LoginAndLogout extends ProjectMethods{
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
	@Test(dataProvider="fetchData")
	public void loginAndLogout(String uName,String pwd,String vName,String companyName,String firstName,String lastName,String expectedText) {
		
		new LoginPage()
		.enterUserName(uName)
		.enterPassword(pwd)
		.clickLogIn()
		.verifyLoggedName(vName)
		.clickCRMSFA()
		.clickLeads()
		.clickCreateLead()
		.typeCompany(companyName)
		.typeFirstName(firstName)
		.typeLastName(lastName)
		.clickCreateLeadBtn()
		.verifyFirstName(expectedText);
	}

}
