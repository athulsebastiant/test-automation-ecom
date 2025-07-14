package org.ats.ecom_testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.ats.ecom_testing.utils.WaitUtils.*;

import org.ats.ecom_testing.utils.DriverFactory;
public class BrandProductsPage {
	WebDriver driver;
	By brandHeaderPolo = By.xpath("//h2[contains(text(),'Brand - Polo Products')]");
	By brandHeaderHM = By.xpath("//h2[contains(text(),'Brand - H&M Products')]");
	By brandLinkHM = By.xpath("//div[@class='brands-name']//li/a[contains(., 'H&M')]");
	public BrandProductsPage() {
		// TODO Auto-generated constructor stub
		this.driver = DriverFactory.getDriver();
	}
	
	public boolean isBrandHeaderPoloDisplayed() {
		waitForVisibility(driver, brandHeaderPolo, 10);
		return driver.findElement(brandHeaderPolo).isDisplayed();
	}
	
	public String getBrandHeaderPolo() {
		return driver.findElement(brandHeaderPolo).getText();
	}
	
	public void clickHMBrandLink() {
		driver.findElement(brandLinkHM).click();
	}
	
	public String getBrandHeaderHM() {
		return driver.findElement(brandHeaderHM).getText();
	}
}
