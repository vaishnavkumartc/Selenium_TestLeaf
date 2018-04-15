package com.perficient.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.perficient.util.CommonUtilities;

public class Commonmethods extends CommonUtilities {

	String orgPincodeValue;
	String orgcontactNo;
	String orgcurrentAddressValue;

	WebDriver driver;
	WebDriverWait wait;

	
	public boolean errorMsgExists(WebElement errorMsg) {
		try {
			if(errorMsg.isDisplayed())
				return true;

		}catch (NoSuchElementException e) {
			return false;
		}
		return true;
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

}




