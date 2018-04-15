package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import wdMethods.ProjectMethods;

public class MergeAccountPage extends ProjectMethods{
	
	public MergeAccountPage() {		
		PageFactory.initElements(driver,this);
	}	
	
	@FindBy(how=How.ID,using="sectionHeaderTitle_accounts")
	private WebElement eleMergeAccountHeader;
	
	public MergeAccountPage verifyMergeAccountHeader() {
		verifyDisplayed(eleMergeAccountHeader);
		return this;
	}
	
	
	@FindBy(how=How.XPATH,using="//table[@id='widget_ComboBox_partyIdFrom']/following-sibling::a")
	private WebElement eleLookUpAccountForFromAccnt;
	
	public FindAccountsThroughMergeAccountPage clickLookUpAccountForFromAccnt() {
		clickWithNoSnap(eleLookUpAccountForFromAccnt);
		switchToWindow(1);
		return new FindAccountsThroughMergeAccountPage();
	}
	
	
		
	
	
	

}
