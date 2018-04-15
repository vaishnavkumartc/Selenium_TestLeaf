package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Then;
import wdMethods.ProjectMethods;

public class EditLeadPage extends ProjectMethods{

	public EditLeadPage() {		
		PageFactory.initElements(driver,this);
	}	


	@FindBy(how=How.XPATH,using="//input[@class='inputBox' and @name='companyName']")
	private WebElement eleCompanyName;
	@Then("enter the company name to change (.*)")
	public EditLeadPage verifyFirstName(String data) {
		type(eleCompanyName, data);
		return this;		
	}
	
	@FindBy(how=How.XPATH,using="//input[@value='Update' and @name='submitButton']")
	private WebElement eleUpdateBtn;
	@Then("click update")
	public EditLeadPage clickUpdate() {
		click(eleUpdateBtn);
		return this;		
	}
	







}
