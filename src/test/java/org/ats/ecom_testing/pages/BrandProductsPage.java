package org.ats.ecom_testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import static org.ats.ecom_testing.utils.WaitUtils.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ats.ecom_testing.utils.DriverFactory;
public class BrandProductsPage {
	private static final Logger log = LogManager.getLogger(BrandProductsPage.class);

	WebDriver driver;
	By brandHeaderPolo = By.xpath("//h2[contains(text(),'Brand - Polo Products')]");
	By brandHeaderHM = By.xpath("//h2[contains(text(),'Brand - H&M Products')]");
	By brandLinkHM = By.xpath("//div[@class='brands-name']//li/a[contains(., 'H&M')]");
	public BrandProductsPage() {
		// TODO Auto-generated constructor stub
		this.driver = DriverFactory.getDriver();
	}
	
	public boolean isBrandHeaderPoloDisplayed() {
		log.info("Checking visibility of 'Brand - Polo Products' header");
		 try {
		waitForVisibility(driver, brandHeaderPolo, 10);
		boolean visible = driver.findElement(brandHeaderPolo).isDisplayed();
        log.info("'Brand - Polo Products' header visible: {}", visible);
        return visible;
		 } catch (TimeoutException e) {
	            log.error("Timeout waiting for 'Brand - Polo Products' header", e);
	        } catch (NoSuchElementException e) {
	            log.error("'Brand - Polo Products' header element not found", e);
	        } catch (Exception e) {
	            log.error("Unexpected error checking 'Brand - Polo Products' header", e);
	        }
	        return false;
	}
	
	public String getBrandHeaderPolo() {
		log.info("Retrieving text of 'Brand - Polo Products' header");
		try {
            String text = driver.findElement(brandHeaderPolo).getText();
            log.info("Header text: {}", text);
            return text;
        } catch (NoSuchElementException e) {
            log.error("'Brand - Polo Products' header element not found when getting text", e);
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error getting 'Brand - Polo Products' header text", e);
            throw e;
        }
	}
	
	public void clickHMBrandLink() {
		 log.info("Clicking 'H&M' brand link");
		 try {
	            driver.findElement(brandLinkHM).click();
	            log.info("'H&M' brand link clicked");
	        } catch (NoSuchElementException e) {
	            log.error("'H&M' brand link not found", e);
	            throw e;
	        } catch (Exception e) {
	            log.error("Unexpected error clicking 'H&M' brand link", e);
	            throw e;
	        }
	}
	
	public String getBrandHeaderHM() {
		log.info("Retrieving text of 'Brand - H&M Products' header");
		try {
            waitForVisibility(driver, brandHeaderHM, 10);
            String text = driver.findElement(brandHeaderHM).getText();
            log.info("Header text: {}", text);
            return text;
        } catch (TimeoutException e) {
            log.error("Timeout waiting for 'Brand - H&M Products' header", e);
            throw e;
        } catch (NoSuchElementException e) {
            log.error("'Brand - H&M Products' header element not found", e);
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error getting 'Brand - H&M Products' header text", e);
            throw e;
        }
    
	}
}
