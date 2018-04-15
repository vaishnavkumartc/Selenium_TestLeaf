package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.AccountDetailsPage;
import pages.LoginPage;
import wdMethods.ProjectMethods;

public class MergeAccountPOM extends ProjectMethods{
	@BeforeTest
	public void setData() {
		testCaseName="MergeAccountPOM";
		testDescription="login to LeafTaps And MergeAccount";
		testNodes="Accounts";
		category="Smoke";
		authors="vaishnav";
		browserName="chrome";
		dataSheetName="TC001";
	}
	@Test
	public void mergeAccount() throws InterruptedException {

		new LoginPage()
		.enterUserName("DemoSalesManager")
		.enterPassword("crmsfa")
		.clickLogIn()
		.clickCRMSFA()
		.clickAccounts()
		.clickMergeAccount()
		.verifyMergeAccountHeader()
		.clickLookUpAccountForFromAccnt()
		.enterAccntId("10")
		.clickFindAcntBtn()
		.clickFirstAccntdisplayed();

	}
}
