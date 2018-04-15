package com.perficient.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.perficient.util.CommonUtilities;


public class HomepageFactory extends CommonUtilities {

	WebDriver driver;

	@FindBy(xpath = "//li/a[@href = '#/home']")
	public WebElement homeLink;

	@FindBy(xpath = "//li/a[@href = '#/dashboard']")
	public WebElement dashboardLink;

	@FindBy(xpath = "//li/a[@href = '#/profile']")
	public WebElement profileLink;

	@FindBy(xpath = "//li[@class = 'treeview parent ng-scope']//a[@href = 'javascript:void(0);']")
	public WebElement managementLink;

	@FindBy(xpath = "//li[@class = 'treeview parent']//a[@href = 'javascript:void(0);']")
	public WebElement administrationLink;

	@FindBy(xpath="//a[@href='#/employees']")
	public WebElement managementEmpLink;

	@FindBy(xpath="//a[@href='#/emproles']")
	public WebElement managementEmpRolesLink;

	@FindBy(xpath="//a[@href='#/holidays']")
	public WebElement managementHolidaysLink;

	@FindBy(xpath="//a[@href='#/importpto']")
	public WebElement managementManageLeaveLink;

	@FindBy(xpath="//a[@href='#/designations']")
	public WebElement managementDesignationLink;

	@FindBy(xpath="//a[@href='#/roles']")
	public WebElement managementRolesLink;

	@FindBy(xpath="//li[@class='ng-scope']/a[@href='javascript:void(0);']")
	public WebElement managementReportsLink;

	@FindBy(xpath="//a[@href='#/report/jobtitle']")
	public WebElement managementReportsDesignationLink;

	@FindBy(xpath="//a[@href='#/report/ebsreport']")
	public WebElement managementReportsEBSReportsLink;

	@FindBy(xpath="//a[@href='#/report/reports_pto']")
	public WebElement managementReportsLeaveReportsLink;

	@FindBy(xpath="//a[@href='#/report/reports_wfh']")
	public WebElement managementReportsWFHReportsLink;

	@FindBy(xpath="//a[@href='#/report/reports_ticket']")
	public WebElement managementReportsTicketReportLink;

	@FindBy(xpath="//a[@href='#/projects']")
	public WebElement administrationProjectLink;

	@FindBy(xpath="//a[@href='#/projectmembers']")
	public WebElement administrationProjectMembersLink;

	@FindBy(xpath="//a[@href='html/ptd/index.html']")
	public WebElement administrationPTDLink;

	@FindBy(xpath="//a[@href='#/supportDashboard']")
	public WebElement administrationHelpDeskDashLink;

	@FindBy(xpath = "//li/a[@href = '#/notifications']")
	public WebElement notificationLink;

	@FindBy(xpath = "//li/a[@href = '#/pto']")
	public WebElement ptoLink;

	@FindBy(xpath = "//li/a[@href = '#/wfh']")
	public WebElement  wfhLink;

	@FindBy(xpath = "//li/a[@href = '#/ticket']")
	public WebElement supportLink;

	@FindBy(xpath = "//li/a[@href = '#/home']/span")
	public WebElement homeLinktext;

	@FindBy(xpath = "//li/a[@href = '#/dashboard']/span")
	public WebElement dashboardLinktext;

	@FindBy(xpath = "//li/a[@href = '#/profile']/span")
	public WebElement profileLinktext;

	@FindBy(xpath = "//li[@class = 'treeview parent ng-scope']//a[@href = 'javascript:void(0);']/span")
	public WebElement managementLinktext;

	@FindBy(xpath = "//li[@class = 'treeview parent']//a[@href = 'javascript:void(0);']/span")
	public WebElement administrationLinktext;

	@FindBy(xpath = "//li/a[@href = '#/notifications']/span")
	public WebElement notificationLinktext;

	@FindBy(xpath = "//li/a[@href = '#/pto']/span")
	public WebElement ptoLinktext;

	@FindBy(xpath = "//li/a[@href = '#/wfh']/span")
	public WebElement  wfhLinktext;

	@FindBy(xpath = "//li/a[@href = '#/ticket']/span")
	public WebElement supportLinktext;

	@FindBy(xpath = "//img[@src = 'images/talent.png']")
	public WebElement talentAqusitionBubbleImage;

	@FindBy(xpath = "//span[contains(text(),'Talent Acquisition')]")
	public WebElement talentAqusitionBubbleText;

	@FindBy(xpath = "//img[@src = 'images/workforcemanagement.png']")
	public WebElement workForceManagementBubbleImage;

	@FindBy(xpath = "//span[contains(text(),'Work Force Management')]")
	public WebElement workForceManagementBubbleText;

	@FindBy(xpath = "//img[@src = 'images/myprofile.png']")
	public WebElement myProfileBubbleImage ;

	@FindBy(xpath = "//span[contains(text(),'My Profile')]")
	public WebElement myProfileBubbleText ;

	@FindBy(xpath = "//img[@src = 'images/myleavecalendar.png']")
	public WebElement leaveCalendarBubbleImage;

	@FindBy(xpath = "//span[contains(text(),'Leave Calendar')]")
	public WebElement leaveCalendarBubbleText;

	@FindBy(xpath = "//img[@src ='images/wfhcalendar.png']")
	public WebElement workFromHomeCalendarBubbleImage;

	@FindBy(xpath = "//div/a/span[contains(text(),'Work Force Management')]")
	public WebElement workFromHomeCalendarBubbleText;

	@FindBy(xpath = "//img[@src = 'images/training.png']")
	public WebElement trainingAndDevelopmentBubbleImage;

	@FindBy(xpath = "//span[contains(text(),'Training and Development')]")
	public WebElement trainingAndDevelopmentBubbleText;

	@FindBy(xpath = "//img[@src = 'images/finance.png']")
	public WebElement financeBubbleImage;

	@FindBy(xpath = "//span[contains(text(),'My Profile')]")
	public WebElement financeBubbleText ;

	@FindBy(xpath = "//img[@src = 'images/helpdesk.png']")
	public WebElement helpdeskBubbleImage;

	@FindBy(xpath = "//span[contains(text(),'Help Desk')]")
	public WebElement helpdeskBubbleText;

	@FindBy(linkText = "Profile")
	public WebElement profileBtn;

	@FindBy(id="logout" )
	public WebElement logoutBtn;

	@FindBy(xpath = "//h3[@class = 'section-title']")
	public WebElement profileHeader;

	@FindBy(xpath = "//h1[@class = 'section-title leave-title']")
	public WebElement ptoHeader;

	@FindBy(xpath = "//h1[@class = 'section-title leave-title']")
	public WebElement wfhHeader;	

	@FindBy(xpath = "//h3[@class = 'section-title ng-binding']")
	public WebElement helpdeskHeader;

	@FindBy(xpath = "//h1[text() ='Project']")
	public WebElement AdmProjectHeader;

	public HomepageFactory(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void verifyLoginNamelinks(WebElement element) throws Exception{

		try {
			boolean isElementPresent = element.isDisplayed();
			if (isElementPresent){
				element.click();
				profileBtn.isDisplayed();
				logoutBtn.isDisplayed();
				report("PASS", "verifyLoginNamelinks", null , null,	null, null, false);
			}
			else
				report("FAIL", "verifyLoginNamelinks", null  , null, null, null, true);
		} catch (Exception e) {
			recover(e.toString());
		}
	}
	public void verifyHomepageELementspresence(WebElement element ,WebElement hovertext) throws Exception{

		try {

			boolean isElementPresent = element.isDisplayed();
			if (isElementPresent){
				Actions action = new Actions(driver);
				action.moveToElement(element).build().perform();
				hovertext.getText();
				report("PASS", "verifyHomepageELementspresence", null , null, hovertext.getText(), null, false);
			}
			else
				report("FAIL", "verifyHomepageELementspresence", null  , null, hovertext.getText(), null, true);
		} catch (Exception e) {
			recover(e.toString());
		}
	}
	public void clickonLink(WebElement element , WebElement header,String ExpectedtextinHeader) throws Exception{
		try{

			element.click();
			String textPresentInHeader = header.getText();
			if(ExpectedtextinHeader.equalsIgnoreCase(textPresentInHeader))
				report("PASS", "clickonLink", null , null, null, null, false);
			else
				report("FAIL", "clickonLink", null  , null,null, null, true);

		}catch (Exception e) {
			recover(e.toString());
		}

	}

}





