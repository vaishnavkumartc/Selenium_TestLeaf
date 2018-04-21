package testcases;

import org.testng.annotations.Test;

import net.bytebuddy.utility.RandomString;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.AccountDetailsPage;
import pages.LoginPage;
import wdMethods.ProjectMethods;

public class CreateAccountPOM extends ProjectMethods{
	@BeforeTest
	public void setData() {
		testCaseName="CreateAccountPOM";
		testDescription="login to LeafTaps And CreateAccount";
		testNodes="Leads";
		category="Smoke";
		authors="vaishnav";
		browserName="chrome";
		dataSheetName="TC001";
	}
	@Test
	public void createAccount() throws InterruptedException {
		String randomString = generateRandomString();
		AccountDetailsPage accountPage = new LoginPage()
		.enterUserName("DemoSalesManager")
		.enterPassword("crmsfa")
		.clickLogIn()
		.clickCRMSFA()
		.clickAccounts()
		.clickCreateAccount()
		.typeAccountName(randomString)
		.selectIndustry("Computer Hardware")
		.selectCurrency("INR - Indian Rupee")
		.selectDataSource("Direct Mail")
		.selectMarket("Automobile")
		.typePrimaryContact("9894431418")
		.typeCity("Chennai")
		.typeEmail("xyz@gmail.com")
		.selectCountryGeoId("India")
		.selectState("TAMILNADU")
		.clickCreateAccountbtn()
		.verifyAccountDetailsSection();
		String accountName = accountPage.getAccountName();
		accountPage.clickFindAccounts()
		.typeAccountName(accountName)
		.clickFindAccounts()
		.clickFirstAccount();
		
	}

}
