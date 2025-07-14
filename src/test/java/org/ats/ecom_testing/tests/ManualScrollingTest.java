package org.ats.ecom_testing.tests;

import org.ats.ecom_testing.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;



public class ManualScrollingTest extends org.ats.ecom_testing.base.BaseTest{
	
	@Test
	@Description("Test to check whether the user can scroll from top to bottom and vice-versa.")
	@Severity(SeverityLevel.MINOR)
	public void manualScrollTest() {
		HomePage home = new HomePage();
		Assert.assertTrue(home.isHomePageVisible(),"Home page is not visible");
		home.scrollToBottomOfPage();
		Assert.assertTrue(home.isSubscriptionHeaderVisible(), "Subscription header not visible");
		home.scrollToTop();
		Assert.assertTrue(home.verifyScrolledUp(), "Scroll arrow button does not scroll up");
	}
}
