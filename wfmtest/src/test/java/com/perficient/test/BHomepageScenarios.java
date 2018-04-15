package com.perficient.test;

import org.testng.annotations.Test;

import com.perficient.core.TestDriver;
import com.perficient.pageObjects.HomepageFactory;

public class BHomepageScenarios extends TestDriver {


	@Test
	public void TC_Home_001() throws Exception {

		try{

			HomepageFactory homepage = new HomepageFactory(driver);
			//verification of Side navigation bar 		
			homepage.verifyHomepageELementspresence(homepage.homeLink , homepage.homeLinktext);
			homepage.verifyHomepageELementspresence(homepage.dashboardLink ,homepage.dashboardLinktext);
			homepage.verifyHomepageELementspresence(homepage.profileLink,homepage.profileLinktext);
			homepage.verifyHomepageELementspresence(homepage.managementLink,homepage.managementLinktext);
			homepage.verifyHomepageELementspresence(homepage.administrationLink,homepage.administrationLinktext);
			homepage.verifyHomepageELementspresence(homepage.notificationLink,homepage.notificationLinktext);
			homepage.verifyHomepageELementspresence(homepage.ptoLink,homepage.ptoLinktext);
			homepage.verifyHomepageELementspresence(homepage.wfhLink,homepage.wfhLinktext);
			homepage.verifyHomepageELementspresence(homepage.supportLink,homepage.supportLinktext);

			//verification of bubble Image links		
			homepage.verifyHomepageELementspresence(homepage.talentAqusitionBubbleImage ,homepage.talentAqusitionBubbleText);
			homepage.verifyHomepageELementspresence(homepage.workForceManagementBubbleImage,homepage.workForceManagementBubbleText);
			homepage.verifyHomepageELementspresence(homepage.myProfileBubbleImage,homepage.myProfileBubbleText);
			homepage.verifyHomepageELementspresence(homepage.leaveCalendarBubbleImage,homepage.leaveCalendarBubbleText);
			homepage.verifyHomepageELementspresence(homepage.workFromHomeCalendarBubbleImage,homepage.workFromHomeCalendarBubbleText);
			homepage.verifyHomepageELementspresence(homepage.trainingAndDevelopmentBubbleImage,homepage.trainingAndDevelopmentBubbleText);
			homepage.verifyHomepageELementspresence(homepage.financeBubbleImage,homepage.financeBubbleText);
			homepage.verifyHomepageELementspresence(homepage.helpdeskBubbleImage,homepage.helpdeskBubbleText);
			//homepage.verifyLoginNamelinks(loginPage.loginName);
			//homepage.logoutBtn.click();

		} catch (Exception e) {
			recover(e.toString());
		}
	}


}
