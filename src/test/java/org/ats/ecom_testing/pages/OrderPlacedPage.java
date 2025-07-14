package org.ats.ecom_testing.pages;
import static org.ats.ecom_testing.utils.WaitUtils.*;

import org.ats.ecom_testing.utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class OrderPlacedPage {
	WebDriver driver;
	By orderPlacedHeader = By.xpath("//h2[b[contains(text(),'Order Placed!')]]");
	By continueBtn = By.xpath("//a[contains(text(),'Continue')]");
	By downloadBtn = By.xpath("//a[contains(text(),'Download Invoice')]");
	public OrderPlacedPage() {
		this.driver = DriverFactory.getDriver();
	}
	
	public boolean isOrderPlaceHeaderDisplyed() {
		waitForVisibility(driver, orderPlacedHeader, 10);
		return driver.findElement(orderPlacedHeader).isDisplayed();
	}
	
	public void clickContinueBtn() {
		driver.findElement(continueBtn).click();
	}
	
	public void clickDownloadBtn() {
		driver.findElement(downloadBtn).click();
	}
}
