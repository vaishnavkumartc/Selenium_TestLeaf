package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.And;
import wdMethods.ProjectMethods;

public class MyLeads extends ProjectMethods{
	
	public MyLeads() {		
		PageFactory.initElements(driver,this);
	}	
	
	
	@FindBy(how=How.LINK_TEXT,using="Create Lead")
	private WebElement eleCreateLead;
	@And("click createLeadlink")
	public CreateLead clickCreateLead() {
	click(eleCreateLead);
		return new CreateLead();		
	}
	
	@FindBy(how=How.LINK_TEXT,using="Find Leads")
	private WebElement eleFindLead;
	@And("click findLeadlink")
	public FindleadPage clickEditLead() {
	click(eleFindLead);
		return new FindleadPage();		
	}
	
		

}
