package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import wdMethods.ProjectMethods;

public class FindAccountsThroughMergeAccountPage extends ProjectMethods{
	
	public FindAccountsThroughMergeAccountPage() {		
		PageFactory.initElements(driver,this);
	}	
	
	@FindBy(how=How.NAME,using="id")
	private WebElement eleAccountIdTxt;
	
	public FindAccountsThroughMergeAccountPage enterAccntId(String data) {
		type(eleAccountIdTxt, data);
		return this;
	}
	
	@FindBy(how=How.XPATH,using="//button[text()='Find Accounts']")
	private WebElement eleFindAccountsBtn;
	
	public FindAccountsThroughMergeAccountPage clickFindAcntBtn() throws InterruptedException {
		click(eleFindAccountsBtn);
		Thread.sleep(500);
		return this;
	}
	
	@FindBy(how=How.XPATH,using="(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")
	private WebElement eleFirstAccnt;
	
	public MergeAccountPage clickFirstAccntdisplayed() {
		clickWithNoSnap(eleFirstAccnt);
		switchToWindow(0);
		return new MergeAccountPage();
	}
	
	
	
}
