package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import wdMethods.ProjectMethods;

public class AccountDetailsPage extends ProjectMethods{
	
	public AccountDetailsPage() {		
		PageFactory.initElements(driver,this);
	}	
	
	@FindBy(how=How.ID,using="sectionHeaderTitle_accounts")
	private WebElement eleAccountDetailsSection;
	
	public AccountDetailsPage verifyAccountDetailsSection() {
	verifyDisplayed(eleAccountDetailsSection);
		return this;	
	}
	
	@FindBy(how=How.XPATH,using=("(//span[text()='Account Name']/following::td/span[@class='tabletext'])[1]"))
	private WebElement eleAccountName;
	
	public String getAccountName() {
		String accountName;
		accountName = eleAccountName.getText();
		accountName = accountName.trim().substring(accountName.indexOf('(')+1, accountName.indexOf(')'));
		return accountName;
	}
	@FindBy(how=How.LINK_TEXT,using="Find Accounts")
	private WebElement eleFindAccountsLink;

	public FindAccountsPage clickFindAccounts() {
		click(eleFindAccountsLink);
		return new FindAccountsPage();	
	}
}
