package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import wdMethods.ProjectMethods;

public class FindAccountsPage extends ProjectMethods{

	public FindAccountsPage() {		
		PageFactory.initElements(driver,this);
	}	

	@FindBy(how=How.XPATH,using="//label[text()='Account ID:']/following::div/input[@name='id']")
	private WebElement eleAccountName;

	public FindAccountsPage typeAccountName(String data) {
		type(eleAccountName,data);
		return this;	
	}
	
	@FindBy(how=How.XPATH,using="//button[text()='Find Accounts']")
	private WebElement eleFindAccountsBtn;

	public FindAccountsPage clickFindAccounts() throws InterruptedException {
		click(eleFindAccountsBtn);
		Thread.sleep(500);
		return this;	
	}
	
	@FindBy(how=How.XPATH,using="//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")
	private WebElement eleFirstAccount;

	public FindAccountsPage clickFirstAccount() {
		click(eleFirstAccount);
		return this;	
	}
	
	
	
	
	
}
