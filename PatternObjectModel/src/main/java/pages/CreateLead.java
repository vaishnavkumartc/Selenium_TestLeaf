package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.And;
import wdMethods.ProjectMethods;

public class CreateLead extends ProjectMethods{
	
	public CreateLead() {		
		PageFactory.initElements(driver,this);
	}	
	
	
	@FindBy(how=How.ID,using="createLeadForm_companyName")
	private WebElement eleCompanyName;
	@And("enter the company name as (.*)")
	public CreateLead typeCompany(String companyName) {
	type(eleCompanyName, companyName);
		return this;		
	}
	
	@FindBy(how=How.ID,using="createLeadForm_lastName")
	private WebElement eleLastName;
	@And("enter the Last Name as (.*)")
	public CreateLead typeLastName(String lastName) {
	type(eleLastName, lastName);
		return this;		
	}
	
	@FindBy(how=How.ID,using="createLeadForm_firstName")
	private WebElement eleFirstName;
	@And("enter the First Name as (.*)")
	public CreateLead typeFirstName(String firstName) {
	type(eleFirstName, firstName);
		return this;		
	}
	
	@FindBy(how=How.NAME,using="submitButton")
	private WebElement eleCreateLeadBtn;
	@And("click on the createLead button")
	public ViewLead clickCreateLeadBtn() {
	click(eleCreateLeadBtn);
		return new ViewLead();		
	}

	
	
	
	
	
	

}
