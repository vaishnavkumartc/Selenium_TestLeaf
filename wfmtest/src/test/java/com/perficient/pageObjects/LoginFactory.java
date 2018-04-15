package com.perficient.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.perficient.util.CommonUtilities;

public class LoginFactory extends CommonUtilities {

	WebDriver driver;

	public String loginNameText;

	@FindBy(name = "username")
	public WebElement username;

	@FindBy(name = "password")
	public WebElement password;

	@FindBy(id = "login")
	public WebElement loginBtn;

	@FindBy(xpath = "//div[4]/button")
	public WebElement errorOkButton;

	@FindBy(xpath = "//div/div/div/div[3]/div")
	public WebElement loginErrorMessage;

	@FindBy(xpath = ".//*[@id='navBarInfo']/ul/li[1]/a/span")
	public WebElement loginName;

	@FindBy(xpath = ".//*[@id='navBarInfo']/ul/li[1]/a")
	public WebElement loginNameClick;

	@FindBy(xpath = "//div[5]/a/img")
	public WebElement WFHImage;


	public LoginFactory(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public LoginFactory setUsername(String text) throws Exception {
		try {
			username.sendKeys(text);
			if (username.getAttribute("value").equalsIgnoreCase(text)) {
				report("PASS", "setUsername", text, "Verify that the user name is accepted",
						"The User name is accepted", null, false);

			} else {
				report("FAIL", "setUsername", text, " Verify that the user name is accepted",
						"The User name is not accepted", null, true);
			}
		} catch (Exception e) {
			recover(e.toString());
		}
		return null;
	}

	public LoginFactory setPassword(String text) throws Exception {
		try {
			password.sendKeys(text);
			if (password.getAttribute("value").equalsIgnoreCase(text)) {
				report("PASS", "setPassword", text, "Verify that the password is accepted", "Password is accepted",
						null, false);
			} else {
				report("FAIL", "setPassword", text, "Verify that the password is accepted", "Password is not accepted",
						null, true);
			}
		} catch (Exception e) {
			recover(e.toString());
		}
		return null;
	}

	public void clickSubmitButton() throws Exception {
		try {
			loginBtn.click();
			report("PASS", "clickSubmitbutton", null, null, null, null, false);

		} catch (Exception e) {
			recover(e.toString());
		}
	}

	public void clickErrorOkButton() throws Exception {
		try {
			errorOkButton.click();
			username.clear();
			password.clear();
			report("PASS", "clickErrorOkbutton", null, null, null, null, false);
		} catch (Exception e) {
			recover(e.toString());
		}
	}

	public void loginNameCheck(String text) throws Exception {
		try {
			String loginNameText = loginName.getText().trim().toString();
			if (loginNameText.equalsIgnoreCase(text.trim().toString())) {
				report("PASS", "LoginNameCheck", text, " Verify the login name", "login name is as expected", null,false);
			} else {
				report("FAIL", "LoginNameCheck", text, " Verify the login name", "login name is incorrect", null, true);
			}
		} catch (Exception e) {
			recover(e.toString());
		}
	}

	public void errorMsgCheck(String text) throws Exception {
		try {
			String ErrMessageText = loginErrorMessage.getText();
			if (ErrMessageText.equalsIgnoreCase(text)) {
				report("PASS", "Error messgae verification", text, "Verify the error message",
						"Error message is as expected", null, false);
			} else {
				report("FAIL", "Error messgae verification", text, "Verify the error message",
						"Error message is not as expected", null, true);
			}
		} catch (Exception e) {
			recover(e.toString());
		}
	}
}
