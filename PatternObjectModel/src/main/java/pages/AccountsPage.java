package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import wdMethods.ProjectMethods;

public class AccountsPage extends ProjectMethods{
	
	public AccountsPage() {		
		PageFactory.initElements(driver,this);
	}	
	
	
	@FindBy(how=How.LINK_TEXT,using="Create Account")
	private WebElement eleCreateAccountLink;
	
	public AccountsPage clickCreateAccount() {
	click(eleCreateAccountLink);
		return this;	
	}
	
	@FindBy(how=How.ID,using="sectionHeaderTitle_accounts")
	private WebElement eleSectionHeader;
	
	public AccountsPage verifySectionHeader() {
	verifyDisplayed(eleSectionHeader);
		return this;	
	}
	
	@FindBy(how =How.ID,using="accountName")
	private WebElement eleAccountName;
	
	public AccountsPage typeAccountName(String data) {
		type(eleAccountName, data);
		return this;
	}
	
	@FindBy(how =How.NAME,using="industryEnumId")
	private WebElement eleIndustry;
	
	public AccountsPage selectIndustry(String data) {
		selectDropDownUsingText(eleIndustry, data);
		return this;
	}
	
	@FindBy(how =How.ID,using="currencyUomId")
	private WebElement eleCurrency;
	
	public AccountsPage selectCurrency(String data) {
		selectDropDownUsingText(eleCurrency, data);
		return this;
	}
	
	@FindBy(how =How.ID,using="dataSourceId")
	private WebElement eleDataSource;
	
	public AccountsPage selectDataSource(String data) {
		selectDropDownUsingText(eleDataSource, data);
		return this;
	}
	
	@FindBy(how =How.ID,using="marketingCampaignId")
	private WebElement eleMarket;
	
	public AccountsPage selectMarket(String data) {
		selectDropDownUsingText(eleMarket, data);
		return this;
	}
	
	@FindBy(how =How.ID,using="primaryPhoneNumber")
	private WebElement elePrimaryContact;
	
	public AccountsPage typePrimaryContact(String data) {
		type(elePrimaryContact, data);
		return this;
	}
	
	@FindBy(how =How.ID,using="generalCity")
	private WebElement eleCity;
	
	public AccountsPage typeCity(String data) {
		type(eleCity, data);
		return this;
	}
	
	@FindBy(how =How.ID,using="primaryEmail")
	private WebElement elePrimaryEmail;
	
	public AccountsPage typeEmail(String data) {
		type(elePrimaryEmail, data);
		return this;
	}
	
	@FindBy(how =How.ID,using="generalCountryGeoId")
	private WebElement eleCountryGeoId;
	
	public AccountsPage selectCountryGeoId(String data) throws InterruptedException {
		selectDropDownUsingText(eleCountryGeoId, data);
		Thread.sleep(2000);
		return this;
	}
	
	@FindBy(how =How.ID,using="generalStateProvinceGeoId")
	private WebElement eleState;
	
	public AccountsPage selectState(String data) {
		selectDropDownUsingText(eleState, data);
		return this;
	}
	
	@FindBy(how =How.LINK_TEXT,using="Merge Accounts")
	private WebElement eleMergeAccountLink;
	
	public MergeAccountPage clickMergeAccount() {
		click(eleMergeAccountLink);
		return new MergeAccountPage();
	}
	
	@FindBy(how =How.XPATH,using="//input[@class='smallSubmit']")
	private WebElement eleCreateAccount;
	
	public AccountDetailsPage clickCreateAccountbtn() {
		click(eleCreateAccount);
		return new AccountDetailsPage();
	}
	
}
