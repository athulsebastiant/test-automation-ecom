package org.ats.ecom_testing.utils;

import org.ats.ecom_testing.pages.DeletedAccountPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DeleteAccountUtil {
	public static void deleteAccount(WebDriver driver) {
		DeletedAccountPage deletedAccountPage = new DeletedAccountPage();
		Assert.assertTrue(deletedAccountPage.isAccountDeletedHeaderVisible(),"Account Deleted Header not visble");
		deletedAccountPage.clickContinueBtn();
	}
}
