package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import wdMethods.ProjectMethods;

public class ViewLead extends ProjectMethods{

	public ViewLead() {		
		PageFactory.initElements(driver,this);
	}	


	@FindBy(how=How.ID,using="viewLead_firstName_sp")
	private WebElement eleForeName;
	@Then("verify the lead is created as (.*)")
	public ViewLead verifyFirstName(String expectedText) {
		verifyExactText(eleForeName, expectedText);
		return this;		
	}
	
	@FindBy(how=How.LINK_TEXT,using="Edit")
	private WebElement eleeditBtn;
	@And("click on edit lead button")
	public EditLeadPage clickEdit() {
		click(eleeditBtn);
		return new EditLeadPage();		
	}
	
	@FindBy(how=How.LINK_TEXT,using="Delete")
	private WebElement eleDelBtn;
	@And("click on delete lead button")
	public MyLeads clickDel() {
		click(eleDelBtn);
		return new MyLeads();		
	}







}
