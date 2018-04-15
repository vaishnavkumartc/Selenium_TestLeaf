package com.perficient.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.perficient.pageObjects.Commonmethods;
import com.perficient.util.CommonUtilities;

public class ProfilepageFactory extends CommonUtilities {

	String orgPincodeValue;
	String orgcontactNo;
	String orgcurrentAddressValue;

	WebDriver driver;
	WebDriverWait wait;
	
	Commonmethods testobj = new Commonmethods();
	

	@FindBy(xpath = "//label[contains(text(),'Employee Id')]")
	public WebElement employeeIdLabel;

	@FindBy(xpath = "//label[contains(text(),'First Name')]")
	public WebElement firstNameLabel;

	@FindBy(xpath ="//div[@class = 'form-group']//label[contains(text(),'Designation')]")
	public WebElement designationLabel;

	@FindBy(xpath ="//label[contains(text(),'Current Address')]")
	public WebElement currentAddressLabel;

	@FindBy(xpath = "//label[contains(text(),'Current City')]")
	public WebElement currentCityLabel;

	@FindBy(xpath = "//label[contains(text(),'Current Pincode')]")
	public WebElement currentPincodeLabel;

	@FindBy(xpath ="//label[contains(text(),'D.O.B')]")
	public WebElement dobLabel;

	@FindBy(xpath="//label[contains(text(),'Blood Group')]")
	public WebElement bloodGroupLabel;

	@FindBy(xpath="//label[contains(text(),'Date of Join')]")
	public WebElement dateOfJoinLabel;

	@FindBy(xpath="//label[contains(text(),'Designation Effective Date')]")
	public WebElement designationEffectiveDateLabel;

	@FindBy(xpath="//label[contains(text(),'Email Id')]")
	public WebElement emailIdLabel;

	@FindBy(xpath="//label[contains(text(),'Last Name')]")
	public WebElement lastNameLabel;

	@FindBy(xpath="//label[contains(text(),'SBU')]")
	public WebElement sbuLabel;

	@FindBy(xpath="//label[contains(text(),'Permanent Address')]")
	public WebElement permanentAddressLabel;

	@FindBy(xpath="//label[contains(text(),'Contact No')]")
	public WebElement contactNoLabel;

	@FindBy(xpath="//label[contains(text(),'Emergency Contact')]")
	public WebElement emergencyContactLabel;

	@FindBy(xpath="//label[contains(text(),'Gender')]")
	public WebElement genderLabel;

	@FindBy(xpath="//label[contains(text(),'Pancard No')]")
	public WebElement pancardNoLabel;

	@FindBy(xpath="//label[contains(text(),'Supervisor')]")
	public WebElement supervisorLabel;

	@FindBy(xpath="//label[contains(text(),'Last Working Date')]")
	public WebElement lastWorkingDateLabel;

	@FindBy(xpath=".//*[@id='employee_id']")
	public WebElement employeeIdInput;

	@FindBy(name="First Name")
	public WebElement firstNameInput;

	@FindBy(name="Current Address")
	public WebElement currentAddressInput;

	@FindBy(name="Current City")
	public WebElement currentCityInput;

	@FindBy(name="Current Pincode")
	public WebElement currentPincodeInput;

	@FindBy(name="D.O.B")
	public WebElement dobInput;

	@FindBy(name="Blood Group")
	public WebElement bloodGroupInput;

	@FindBy(name="Date of Join")
	public WebElement dateOfJoinInput;

	@FindBy(name="Designation Effective Date")
	public WebElement designationEffectiveDateInput;

	@FindBy(name="Email Id")
	public WebElement emailIdInput;

	@FindBy(name="Last Name")
	public WebElement lastNameInput;

	@FindBy(name="SBU")
	public WebElement sbuInput;

	@FindBy(name="Permanent Address")
	public WebElement permanentAddressInput;

	@FindBy(name="Contact No")
	public WebElement contactNoInput;

	@FindBy(name="Emergency Contact")
	public WebElement emergencyContactInput;

	@FindBy(name="Pancard No")
	public WebElement pancardNoInput;

	@FindBy(name="Last Working Date")
	public WebElement lastWorkingDateInput;

	@FindBy(name="Gender")
	public WebElement genderDropDownBtn;

	@FindBy(name="Supervisor")
	public WebElement supervisorDropDownBtn;

	@FindBy(xpath = ".//*[@name='Supervisor']/button/span/span[@class = 'ng-scope']")
	public WebElement supervisorDropDownBtnText;

	@FindBy(name="Designation")
	public WebElement designationDropDownBtn;

	@FindBy(xpath = ".//*[@name='Designation']/button/span/span[@class = 'ng-scope']")
	public WebElement designationDropDownBtnText;

	@FindBy(xpath="//button[@ng-click = 'dobDate()']")
	public WebElement dobBtn;

	@FindBy(xpath="//button[@ng-click=	'joinDate()']")
	public WebElement dateOfJoinBtn;

	@FindBy(xpath="//button[@ng-click= 'jobEffDate()']")
	public WebElement designationEffectiveDateBtn;

	@FindBy(xpath="//button[@ng-click='lastWorkDate()']")
	public WebElement lastWorkingDateBtn;

	@FindBy(xpath="//button[@ng-show='data.pk']")
	public WebElement updateBtn;

	@FindBy(xpath="//div[2]/div/div/div/div/div[3]/div")
	public WebElement savedSuccessMsg;

	@FindBy(xpath= ".//*[@name = 'Current Address']/following-sibling::p")
	public WebElement currentAddressErrMsgs;

	@FindBy(xpath= ".//*[@name = 'Current Pincode']/following-sibling::p")
	public WebElement currentPincodeErrMsgs;

	@FindBy(xpath= ".//*[@name = 'Current City']/following-sibling::p")
	public WebElement currentCityErrMsgs;

	@FindBy(xpath= ".//*[@name = 'Contact No']/following-sibling::p")
	public WebElement contactNoErrMsgs;

	@FindBy(xpath= ".//*[@name = 'Emergency Contact']/following-sibling::p")
	public WebElement emergencyContactErrMsgs;

	@FindBy(xpath= "//button[@class='btn btn-success']")
	public WebElement okayBtn;

	public ProfilepageFactory(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}



	public void isFieldDisabled (WebElement element) throws Exception {

		try{
			boolean isElementEnabled =  element.isEnabled();
			if (isElementEnabled)
				report("FAIL", "isFieldDisabled", null  , null, null, null, false);
			else
				report("PASS", "isFieldDisabled", null  , null, null, null, true);
		}
		catch (Exception e) {
			recover(e.toString());
		}
	}

	public void isFieldEnabled (WebElement element) throws Exception {

		try{
			boolean isElementEnabled =  element.isEnabled();
			if (isElementEnabled)
				report("PASS", "isElementEnabled", null  , null, null, null, false);
			else
				report("FAIL", "isElementEnabled", null  , null, null, null, true);
		}
		catch (Exception e) {
			recover(e.toString());
		}
	}	

	public void verifyProgilepageELements(WebElement element) throws Exception{

		try {
			boolean isElementPresent = element.isDisplayed();
			if (isElementPresent)
				report("PASS", "verifyProgilepageELements", null , null, null, null, true);
			else
				report("FAIL", "verifyProgilepageELements", null  , null, null, null, false);
		} catch (Exception e) {
			recover(e.toString());
		}
	}

	public void verifyOnlyNumChar(WebElement element) throws Exception {
		try{
			String fieldValue = element.getAttribute("value");
			int no_of_letters = 0;
			for (int i = 0;i < fieldValue.length(); i++){
				char c = fieldValue.charAt(i);
				if (Character.isLetter(c))
					no_of_letters = no_of_letters + 1 ;
			}
			if (no_of_letters > 0)
				report("FAIL", "Only numeric char ", null  , null, null, null, true);
			else
				report("PASS", "Only numeric char ", null  , null, null, null, false);
		}
		catch (Exception e) {
			recover(e.toString());
		}
	}

	public void verifyOnlyAlphaChar(WebElement element) throws Exception {
		try{
			String InputValue = element.getAttribute("value");
			int no_of_digits = 0;
			for (int i = 0;i< InputValue.length(); i++){
				char c = InputValue.charAt(i);
				if (Character.isDigit(c))
					no_of_digits = no_of_digits + 1 ;
			}
			if (no_of_digits > 0)
				report("FAIL", "verifyOnlyAlphaCharacters", null  , null, null, null, true);
			else
				report("PASS", "verifyOnlyAlphaCharacters", null  , null, null, null, false);
		}
		catch (Exception e) {
			recover(e.toString());
		}
	}

	public void verifyOnlyAlphaCharforDrpdwn (WebElement element) throws Exception {
		try{

			String InputValue = element.getText();
			int no_of_digits = 0;
			for (int i = 0;i< InputValue.length(); i++){
				char c = InputValue.charAt(i);
				if (Character.isDigit(c))
					no_of_digits = no_of_digits + 1 ;
			}
			if (no_of_digits > 0)
				report("FAIL", "verifyOnlyAlphaCharactersforDropdown", null  , null, null, null, true);
			else
				report("PASS", "verifyOnlyAlphaCharactersforDropdown", null  , null, null, null, false);
		}
		catch (Exception e) {
			recover(e.toString());
		}
	}

	public void emailIdFormatChk(WebElement element) throws Exception {
		try{
			String emailIdValue = element.getAttribute("value");

			String pattern = "[a-zA-Z0-9]{1,}[.][a-zA-Z0-9]{1,}[@][a-zA-Z0-9]{1,}[.][a-zA-Z0-9]{3}";

			if (emailIdValue.matches(pattern))
				report("PASS", "emailIdFieldCheck", null  , null, null, null, false);
			else
				report("FAIL", "emailIdFieldCheck", null  , null, null, null, true);
		}catch (Exception e) {
			recover(e.toString());
		}
	}

	public void noOfSplCharErrMsgChk(WebElement element ,WebElement displayedErrorMsg , String expErrorMsgText , int no_of_Char) throws Exception {
		try{
			String lastout = "";

			for(int i=0;i<no_of_Char;i++)
			{
				String toadd="%";
				lastout=lastout+toadd;
			}
			element.clear();
			element.sendKeys(lastout);
			updateBtn.click();
		
			if (testobj.errorMsgExists(displayedErrorMsg))
			{
				if(displayedErrorMsg.getText().equalsIgnoreCase(expErrorMsgText))

					report("PASS",no_of_Char +"spl Characters field check" , null  , null, null, null, false);
				else
					report("FAIL",no_of_Char +"spl Characters field check", null  , null, null, null, true);
			}
			else{
				report("FAIL", "Error msg not displayed for spl characters " + no_of_Char, null  , null, null, null, true);
				clickOK();
			}
		}
		catch(Exception e){
			recover(e.toString());	
		}
	}

	public void noOfSplCharNoErrMsgChk(WebElement element ,WebElement displayedErrorMsg , int no_of_Char) throws Exception {
		try{
			String lastout = null;
			for(int i=0;i<no_of_Char;i++)
			{
				String toadd="%";
				lastout=lastout+toadd;
			}
			element.clear();
			element.sendKeys(lastout);
			updateBtn.click();

			if (errorMsgExists(displayedErrorMsg))
				report("FAIL",no_of_Char +"spl Characters field check" , null  , null, null, null, true);
			else{
				report("PASS", "Error msg not displayed for spl characters - " + no_of_Char, null  , null, null, null, false);
				clickOK();
			}
		}
		catch(Exception e){
			recover(e.toString());	
		}
	}

	public void nullValErrMsgChk(WebElement element,WebElement displayedErrorMsg , String expErrorMsgText) throws Exception {

		element.clear();
		updateBtn.click();

		if (errorMsgExists(displayedErrorMsg))
		{
			if (displayedErrorMsg.getText().equalsIgnoreCase(expErrorMsgText))
			{
				report("PASS", "Null value error msg Check", null  , null, null, null, false);
			}
			else{
				report("FAIL", "Null value error msg  Check", null  , null, null, null, true);
			}
		}
		else{
			report("FAIL", "Error msg not present", null  , null, null, null, true);
			clickOK();
		}

	}

	public void nullValNoErrMsgChk(WebElement element,	WebElement displayedErrorMsg) throws Exception {

		element.clear();
		updateBtn.click();

		if (errorMsgExists(displayedErrorMsg))
			report("FAIL", "Null value error msg  Check", null  , null, null, null, true);
		else{
			report("PASS", "Error msg not present", null  , null, null, null, false);
			clickOK();
		}
	}

	public void noOfAlphaCharErrMsgChk(WebElement element,WebElement displayedErrorMsg , String expErrorMsgText,int no_of_Char) throws Exception{

		try{
			String lastout = "";

			for(int i=0;i<no_of_Char;i++)
			{
				String toadd="b";
				lastout=lastout+toadd;
			}
			element.clear();
			element.sendKeys(lastout);
			updateBtn.click();

			if (errorMsgExists(displayedErrorMsg))
			{
				if(displayedErrorMsg.getText().equalsIgnoreCase(expErrorMsgText))

					report("PASS",no_of_Char +"Alpha Characters field check" , null  , null, null, null, false);
				else
					report("FAIL",no_of_Char +"Alpha Characters field check", null  , null, null, null, true);
			}
			else{
				report("FAIL", "Error msg not displayed for no_of_Char", null  , null, null, null, true);
				clickOK();
			}
		}
		catch(Exception e){
			recover(e.toString());	
		}
	}

	public void noOfAlphaCharNoErrMsgChk(WebElement element,WebElement displayedErrorMsg , int no_of_Char) throws Exception{

		try{
			String lastout = "";

			for(int i=0;i<no_of_Char;i++)
			{
				String toadd="b";
				lastout=lastout+toadd;
			}
			element.clear();
			element.sendKeys(lastout);
			updateBtn.click();

			if (errorMsgExists(displayedErrorMsg))
				report("FAIL",no_of_Char +"Characters field check", null  , null, null, null, true);
			else{
				report("PASS", "Error msg not displayed for no_of_Char", null  , null, null, null, false);
				clickOK();
			}
		}
		catch(Exception e){
			recover(e.toString());	
		}
	}

	public void noOfNumErrMsgChk(WebElement element,WebElement displayedErrorMsg , String expErrorMsgText,int no_of_int) throws Exception{

		try{
			String lastout = "";

			for(int i=0;i<no_of_int;i++)
			{
				String toadd="1";
				lastout=lastout+toadd;
			}
			element.clear();
			element.sendKeys(lastout);
			updateBtn.click();

			if (errorMsgExists(displayedErrorMsg))
			{
				if(displayedErrorMsg.getText().equalsIgnoreCase(expErrorMsgText))

					report("PASS",no_of_int +"integers field check" , null  , null, null, null, false);
				else
					report("FAIL",no_of_int +"integers field check", null  , null, null, null, true);
			}
			else{
				report("FAIL", "Error msg not displayed", null  , null, null, null, true);
				okayBtn.click();
			}
		}
		catch(Exception e){
			recover(e.toString());	
		}
	}

	public void noOfNumNoErrMsgChk(WebElement element,WebElement displayedErrorMsg ,int no_of_Char) throws Exception{

		try{
			String lastout = "";

			for(int i=0;i<no_of_Char;i++)
			{
				String toadd="1";
				lastout=lastout+toadd;
			}
			element.clear();
			element.sendKeys(lastout);
			updateBtn.click();

			if (errorMsgExists(displayedErrorMsg))
				report("FAIL",no_of_Char +"Integers field check", null  , null, null, null, true);
			else{
				report("PASS", "Error msg not displayed ", null  , null, null, null, false);
				clickOK();

			}
		}
		catch(Exception e){
			recover(e.toString());	
		}
	}

	public void clickOK(){
		if (wait == null) wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='btn btn-success']")));
		okayBtn.click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[@class='btn btn-success']")));	
	}

	public void reset(String fieldValue, WebElement Element){
		Element.clear();
		Element.sendKeys(fieldValue);
		updateBtn.click();
		clickOK();
	}

	public void clickupdateBtnVerifySavedMsg() throws Exception{
		try {
			updateBtn.click();
			String expectedmsg ="Profile updated Successfully!";
			String actualmsg = savedSuccessMsg.getText();

			if(actualmsg.equalsIgnoreCase(expectedmsg))
				report("PASS", null, null , null, null, null, false);
			else
				report("FAIL", null, null , null, null, null, true);
		} catch (Exception e) {
			recover(e.toString());
		}
	}
}




