package org.ats.ecom_testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.ats.ecom_testing.utils.WaitUtils.*;

import org.ats.ecom_testing.utils.DriverFactory;
public class DeletedAccountPage {
	WebDriver driver;
	By accountDeletedHeader = By.xpath("//h2/b[contains(text(),'Account Deleted!')]");
	By continueBtn = By.xpath("//a[contains(text(),'Continue')]");
	public DeletedAccountPage() {
		// TODO Auto-generated constructor stub
		this.driver = DriverFactory.getDriver();
	}
	
	public boolean isAccountDeletedHeaderVisible() {
		waitForVisibility(driver, accountDeletedHeader, 10);
		return driver.findElement(accountDeletedHeader).isDisplayed();
	}
	
	public void clickContinueBtn() {
		driver.findElement(continueBtn).click();
	}
	
}
