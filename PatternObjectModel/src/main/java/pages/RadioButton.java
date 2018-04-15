package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import wdMethods.ProjectMethods;

public class RadioButton extends ProjectMethods{

	public RadioButton() {		
		PageFactory.initElements(driver,this);
	}	


	@FindBy(how=How.ID,using="iframeResult")
	private WebElement frame;

	public RadioButton swithcToFrame() {
		switchToFrame(frame);
		return this;		
	}

	@FindBy(how=How.XPATH,using="//input[@type='radio'][1]")
	private WebElement Male;

	public RadioButton clickMale() {
		click(Male);
		return this;		
	}



}
