package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import wdMethods.ProjectMethods;

public class FindleadPage extends ProjectMethods{

	public FindleadPage() {		
		PageFactory.initElements(driver,this);
	}	

	@FindBy(how=How.NAME,using="id")
	private WebElement eleLeadId;
	@And("enter the lead id as (.*)")
	public FindleadPage typeLeadid(String data) {
		type(eleLeadId, data);
		return this;		
	}

	@FindBy(how=How.XPATH,using="//button[text()='Find Leads']")
	private WebElement elefindLeadsBtn;
	@And("click find leads button")
	public FindleadPage clickFindLeadsBtn() throws InterruptedException {
		click(elefindLeadsBtn);
		//Thread.sleep(2000);
		return this;		
	}

	@FindBy(how=How.XPATH,using="//button[text()='Find Leads']")
	private WebElement eleFirstLead;
	@And("click resulting lead link")
	public ViewLead clickFirstLead(){
		click(eleFirstLead);
		return new ViewLead();		
	}
	
	@FindBy(how=How.XPATH,using="//div[text()='No records to display']")
	private WebElement eleMessageNoRecords;
	@Then("validate No Records Found Message")
	public ViewLead validateMessage() {
		verifyPartialText(eleMessageNoRecords, "No Records");
		return null;
		
	}
}
