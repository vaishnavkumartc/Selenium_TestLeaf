package com.perficient.test;

import org.testng.annotations.Test;

import com.perficient.core.TestDriver;
import com.perficient.pageObjects.HomepageFactory;
import com.perficient.pageObjects.ProfilepageFactory;

public class CProfilepageScenarios extends TestDriver {

	@Test
	public void TC_Profile_001() throws Exception {

		ProfilepageFactory profilePage = new ProfilepageFactory(driver);
		HomepageFactory homepage = new HomepageFactory(driver);		
		homepage.profileLink.click();
		
		profilePage.verifyProgilepageELements(profilePage.employeeIdLabel);
		profilePage.verifyProgilepageELements(profilePage.firstNameLabel);
		profilePage.verifyProgilepageELements(profilePage.designationLabel);
		profilePage.verifyProgilepageELements(profilePage.currentAddressLabel);
		profilePage.verifyProgilepageELements(profilePage.currentCityLabel);
		profilePage.verifyProgilepageELements(profilePage.currentPincodeLabel);
		profilePage.verifyProgilepageELements(profilePage.dobLabel);
		profilePage.verifyProgilepageELements(profilePage.bloodGroupLabel);
		profilePage.verifyProgilepageELements(profilePage.dateOfJoinLabel);
		profilePage.verifyProgilepageELements(profilePage.designationEffectiveDateLabel);
		profilePage.verifyProgilepageELements(profilePage.emailIdLabel);
		profilePage.verifyProgilepageELements(profilePage.lastNameLabel);
		profilePage.verifyProgilepageELements(profilePage.sbuLabel);
		profilePage.verifyProgilepageELements(profilePage.permanentAddressLabel);
		profilePage.verifyProgilepageELements(profilePage.contactNoLabel);
		profilePage.verifyProgilepageELements(profilePage.emergencyContactLabel);
		profilePage.verifyProgilepageELements(profilePage.genderLabel);
		profilePage.verifyProgilepageELements(profilePage.pancardNoLabel);
		profilePage.verifyProgilepageELements(profilePage.supervisorLabel);
		profilePage.verifyProgilepageELements(profilePage.lastWorkingDateLabel);
	}

	@Test
	public void TC_Profile_002_EmployeeID() throws Exception {
		ProfilepageFactory profilePage = new ProfilepageFactory(driver);

		profilePage.isFieldDisabled(profilePage.employeeIdInput);
		profilePage.verifyOnlyNumChar(profilePage.employeeIdInput);

	}

	@Test
	public void TC_Profile_003_EmailID() throws Exception {
		ProfilepageFactory profilePage = new ProfilepageFactory(driver);

		profilePage.isFieldDisabled(profilePage.emailIdInput);
		profilePage.emailIdFormatChk(profilePage.emailIdInput);

	}
	@Test
	public void TC_Profile_004_FirstName() throws Exception {
		ProfilepageFactory profilePage = new ProfilepageFactory(driver);

		profilePage.isFieldDisabled(profilePage.firstNameInput);
		profilePage.verifyOnlyAlphaChar(profilePage.firstNameInput);

	}
	@Test
	public void TC_Profile_005() throws Exception {
		ProfilepageFactory profilePage = new ProfilepageFactory(driver);

		profilePage.isFieldDisabled(profilePage.lastNameInput);
		profilePage.verifyOnlyAlphaChar(profilePage.lastNameInput);

	}

	@Test
	public void TC_Profile_009_DOB() throws Exception {
		ProfilepageFactory profilePage = new ProfilepageFactory(driver);
		profilePage.isFieldDisabled(profilePage.dobInput);

	}

	@Test
	public void TC_Profile_010_Supervisor() throws Exception {
		ProfilepageFactory profilePage = new ProfilepageFactory(driver);
		profilePage.isFieldDisabled(profilePage.supervisorDropDownBtn);
		profilePage.verifyOnlyAlphaCharforDrpdwn(profilePage.supervisorDropDownBtn);
	}

	@Test
	public void TC_Profile_011_Designation() throws Exception {
		ProfilepageFactory profilePage = new ProfilepageFactory(driver);
		profilePage.isFieldDisabled(profilePage.designationDropDownBtn);
		profilePage.verifyOnlyAlphaCharforDrpdwn(profilePage.designationDropDownBtn);
	}

	@Test
	public void TC_Profile_012_SBU() throws Exception {
		ProfilepageFactory profilePage = new ProfilepageFactory(driver);
		profilePage.isFieldDisabled(profilePage.sbuInput);
		profilePage.verifyOnlyAlphaChar(profilePage.sbuInput);
	}

	@Test
	public void TC_Profile_013_Bloodgroup() throws Exception {
		ProfilepageFactory profilePage = new ProfilepageFactory(driver);
		profilePage.isFieldDisabled(profilePage.bloodGroupInput);
	}
	@Test
	public void TC_Profile_014_Pancard() throws Exception {
		ProfilepageFactory profilePage = new ProfilepageFactory(driver);
		profilePage.isFieldDisabled(profilePage.pancardNoInput);
	}
	@Test
	public void TC_Profile_015_DateofJoin() throws Exception {
		ProfilepageFactory profilePage = new ProfilepageFactory(driver);
		profilePage.isFieldDisabled(profilePage.dateOfJoinInput);
	}
	@Test
	public void TC_Profile_016_lastWorkingDate() throws Exception {
		ProfilepageFactory profilePage = new ProfilepageFactory(driver);
		profilePage.isFieldDisabled(profilePage.lastWorkingDateInput);
	}

	@Test
	public void TC_Profile_007_Pincodefield() throws Exception {

		ProfilepageFactory profilePage = new ProfilepageFactory(driver);

		String expNullValErrMsg = "Current Pincode is required.";
		String expShortValErrMsg ="Current Pincode is too short.";
		String expLongValErrMsg ="Current Pincode is too long.";
		String expInvalidErrMsg = "Current Pincode is invalid.";

		String orgFieldValue = profilePage.currentPincodeInput.getAttribute("value");
		profilePage.isFieldEnabled(profilePage.currentPincodeInput);
		profilePage.nullValErrMsgChk(profilePage.currentPincodeInput,profilePage.currentPincodeErrMsgs,expNullValErrMsg);
		profilePage.noOfNumErrMsgChk(profilePage.currentPincodeInput,profilePage.currentPincodeErrMsgs,expShortValErrMsg, 2);
		profilePage.noOfNumErrMsgChk(profilePage.currentPincodeInput,profilePage.currentPincodeErrMsgs,expLongValErrMsg, 7);
		profilePage.noOfAlphaCharErrMsgChk(profilePage.currentPincodeInput,profilePage.currentPincodeErrMsgs,expInvalidErrMsg, 6);
		profilePage.noOfSplCharErrMsgChk(profilePage.currentPincodeInput,profilePage.currentPincodeErrMsgs,expInvalidErrMsg, 6);
		profilePage.noOfNumNoErrMsgChk(profilePage.currentPincodeInput,profilePage.currentPincodeErrMsgs, 6);
		profilePage.reset(orgFieldValue,profilePage.currentPincodeInput);

	}






	@Test
	public void TC_Profile_017_UpdValidRecord() throws Exception {

		ProfilepageFactory profilePage = new ProfilepageFactory(driver);
		profilePage.currentAddressInput.clear();
		profilePage.currentAddressInput.sendKeys("5TH FLOOR OLYMPIA PLATINA GUINDY");
		profilePage.currentPincodeInput.clear();
		profilePage.currentPincodeInput.sendKeys("600001");
		profilePage.currentCityInput.clear();
		profilePage.currentCityInput.sendKeys("chennai");
		profilePage.permanentAddressInput.clear();
		profilePage.permanentAddressInput.sendKeys("");
		profilePage.contactNoInput.clear();
		profilePage.contactNoInput.sendKeys("09600043266");
		profilePage.emergencyContactInput.clear();
		profilePage.emergencyContactInput.sendKeys("9600043266");
		profilePage.clickupdateBtnVerifySavedMsg();

	}

}




