/**
 * A sample test script. 
 * @author Srinivasan Ramasamy
 * @version 1.0
 */

package com.perficient.test;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.perficient.core.TestDriver;
import com.perficient.pageObjects.LoginFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ALoginScenarios extends TestDriver {

	@Test
	public void LoginTC000() throws Exception {
		try {
			driver.get(parameters.get("URL"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (Exception e) {
			recover(e.toString());
		}
	}

	@Test (enabled = false)
	public void LoginTC001() throws Exception {
		// Setup the PageObject Object which contains all the WebElements
		LoginFactory loginPage = new LoginFactory(driver);
		try {
			loginPage = new LoginFactory(driver);
			loginPage.setUsername(parameters.get("UserName"));
			loginPage.setPassword(parameters.get("Password"));
			loginPage.clickSubmitButton();
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(loginPage.loginErrorMessage));
			loginPage.errorMsgCheck(parameters.get("ErrorMessage"));
			loginPage.clickErrorOkButton();
		} catch (Exception e) {
			recover(e.toString());
		}
	}

	@Test(enabled = false)
	public void LoginTC002() throws Exception {
		LoginFactory loginPage = new LoginFactory(driver);
		try {
			loginPage = new LoginFactory(driver);
			loginPage.setUsername(parameters.get("UserName"));
			loginPage.setPassword(parameters.get("Password"));
			loginPage.clickSubmitButton();
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(loginPage.loginErrorMessage));
			loginPage.errorMsgCheck(parameters.get("ErrorMessage"));
			loginPage.clickErrorOkButton(); 
		} catch (Exception e) {
			recover(e.toString());
		}
	}

	@Test(enabled = false)
	public void LoginTC003() throws Exception {
		LoginFactory loginPage = new LoginFactory(driver);
		
		try {
			loginPage.setUsername(parameters.get("UserName"));
			loginPage.setPassword(parameters.get("Password"));
			loginPage.clickSubmitButton();
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(loginPage.loginErrorMessage));
			loginPage.errorMsgCheck(parameters.get("ErrorMessage"));
			loginPage.clickErrorOkButton();
		} catch (Exception e) {
			recover(e.toString());
		}
	}


@Test
public void LoginTC004() throws Exception {
	LoginFactory loginPage = new LoginFactory(driver);
	
		try{
		loginPage = new LoginFactory(driver);
		loginPage.setUsername(parameters.get("UserName"));
		loginPage.setPassword(parameters.get("Password"));
		loginPage.clickSubmitButton();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(loginPage.loginName));
		loginPage.loginNameCheck(parameters.get("LoginName"));
	} catch (Exception e) {
		recover(e.toString());
	}
		
@Test
public void LoginTC005() throws Exception {
	try{
		loginPage = new LoginFactory(driver);
		loginPage.setUsername(parameters.get("UserName"));
		loginPage.setPassword(parameters.get("Password"));
		loginPage.clickSubmitButton();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(loginPage.loginName));
		loginPage.loginNameCheck(parameters.get("LoginName"));
	} catch (Exception e) {
		recover(e.toString());
}
}
}

