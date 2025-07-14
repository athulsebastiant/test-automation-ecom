package org.ats.ecom_testing.pages;

import org.ats.ecom_testing.utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.ats.ecom_testing.utils.WaitUtils.*;

import java.util.ArrayList;
import java.util.List;
public class PlaceOrderPage {
	WebDriver driver;
	By deliveryAddressLocator = By.cssSelector("#address_invoice li:not(.address_title)");
	 By billingAddressLocator = By.cssSelector("#address_invoice li:not(.address_title)");
	 By messageTextBox = By.cssSelector("textarea.form-control");
	 By placeOrderBtn = By.xpath("//a[contains(text(),'Place Order')]");
	 
	public PlaceOrderPage() {
		this.driver = DriverFactory.getDriver();
	}
	
	private List<String> getAddressLines(By ulLocator){
		List<WebElement> addressElements = driver.findElements(ulLocator);
		List<String> addressLines = new ArrayList<String>();
		for(WebElement el : addressElements) {
			String text = el.getText().trim();
		    if (!text.isEmpty()) {
		        addressLines.add(text);
		    }
		}
		return addressLines;
	}
	
	public List<String> getDeliveryAddressLines(){
		waitForVisibility(driver, deliveryAddressLocator, 10);
		return getAddressLines(deliveryAddressLocator);
	}
	
	public List<String> getBillingAddressLines(){
		waitForVisibility(driver, billingAddressLocator, 10);
		return getAddressLines(billingAddressLocator);
	} 
	
	public void typeDescription(String message) {
		driver.findElement(messageTextBox).sendKeys(message);
	}
	
	public void clickplaceOrderBtn() {
		driver.findElement(placeOrderBtn).click();
	}
}
