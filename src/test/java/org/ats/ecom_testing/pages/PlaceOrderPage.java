package org.ats.ecom_testing.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ats.ecom_testing.utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.ats.ecom_testing.utils.WaitUtils.*;

import java.util.ArrayList;
import java.util.List;
public class PlaceOrderPage {
	 private static final Logger log = LogManager.getLogger(PlaceOrderPage.class);
	WebDriver driver;
	By deliveryAddressLocator = By.cssSelector("#address_invoice li:not(.address_title)");
	 By billingAddressLocator = By.cssSelector("#address_invoice li:not(.address_title)");
	 By messageTextBox = By.cssSelector("textarea.form-control");
	 By placeOrderBtn = By.xpath("//a[contains(text(),'Place Order')]");
	 
	public PlaceOrderPage() {
		this.driver = DriverFactory.getDriver();
	}
	
	private List<String> getAddressLines(By ulLocator){
		log.info("Retrieving address lines using locator {}", ulLocator);
		List<String> addressLines = new ArrayList<String>();
		try {
		List<WebElement> addressElements = driver.findElements(ulLocator);
		
		for(WebElement el : addressElements) {
			String text = el.getText().trim();
		    if (!text.isEmpty()) {
		        addressLines.add(text);
		    }
		}
		log.info("Found {} address lines", addressLines.size());
		return addressLines;
		} catch (NoSuchElementException e) {
            log.error("Address elements not found for locator {}", ulLocator, e);
            return addressLines;
        } catch (Exception e) {
            log.error("Unexpected error retrieving address lines for locator {}", ulLocator, e);
            return addressLines;
        }
	}
	
	public List<String> getDeliveryAddressLines(){
		log.info("Getting delivery address lines");
		 try {
	            waitForVisibility(driver, deliveryAddressLocator, 10);
	            return getAddressLines(deliveryAddressLocator);
	        } catch (TimeoutException e) {
	            log.error("Timeout waiting for delivery address section", e);
	        } catch (Exception e) {
	            log.error("Unexpected error getting delivery address lines", e);
	        }
	        return new ArrayList<>();
	}
	
	public List<String> getBillingAddressLines(){
		 log.info("Getting billing address lines");
	        try {
	            waitForVisibility(driver, billingAddressLocator, 10);
	            return getAddressLines(billingAddressLocator);
	        } catch (TimeoutException e) {
	            log.error("Timeout waiting for billing address section", e);
	        } catch (Exception e) {
	            log.error("Unexpected error getting billing address lines", e);
	        }
	        return new ArrayList<>();
	} 
	
	public void typeDescription(String message) {
		 log.info("Typing order description: {}", message);
	        try {
	            driver.findElement(messageTextBox).sendKeys(message);
	            log.info("Order description entered");
	        } catch (NoSuchElementException e) {
	            log.error("Message textbox not found", e);
	            throw e;
	        } catch (Exception e) {
	            log.error("Unexpected error typing description", e);
	            throw e;
	        }
	}
	
	public void clickplaceOrderBtn() {
		log.info("Clicking 'Place Order' button");
        try {
            driver.findElement(placeOrderBtn).click();
            log.info("'Place Order' button clicked successfully");
        } catch (NoSuchElementException e) {
            log.error("Place Order button not found", e);
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error clicking Place Order button", e);
            throw e;
        }
	}
}
