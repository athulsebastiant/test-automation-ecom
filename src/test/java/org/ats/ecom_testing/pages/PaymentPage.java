package org.ats.ecom_testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import static org.ats.ecom_testing.utils.WaitUtils.*;

import org.ats.ecom_testing.utils.DriverFactory;
public class PaymentPage {
	WebDriver driver;
	JavascriptExecutor js;
	By nameOnCard = By.xpath("//input[@name='name_on_card']");
	By cardNumber = By.xpath("//input[@name='card_number']");
	By cvc = By.xpath("//input[@name='cvc']");
	By expMonth = By.xpath("//input[@name='expiry_month']");
	By expYear = By.xpath("//input[@name='expiry_year']");
	By payAndConfirmBtn = By.cssSelector("button#submit");
	By successpaymentMsg = By.xpath("//div[contains(text(),'Your order has been placed successfully!')]");
	public PaymentPage() {
		this.driver = DriverFactory.getDriver();
		this.js = (JavascriptExecutor)driver;
	}
	
	public void fillNameOnCard(String name) {
		driver.findElement(nameOnCard).sendKeys(name);
	}
	
	public void fillCardNumber(String no) {
		driver.findElement(cardNumber).sendKeys(no);
	}
	
	public void fillcvc(int cvcN) {
		driver.findElement(cvc).sendKeys(String.valueOf(cvcN));
	}
	
	public void fillExpMonth(int m) {
		driver.findElement(expMonth).sendKeys(String.valueOf(m));
	}
	
	public void fillExpYear(int y) {
		driver.findElement(expYear).sendKeys(String.valueOf(y));
	}
	
	public void clickPayandConfirmBtn() {
		js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(payAndConfirmBtn));
		driver.findElement(payAndConfirmBtn).click();
	}
	
	public boolean isPaymentSuccessMessageDisplayed() {
		waitForVisibility(driver, successpaymentMsg, 10);
		return driver.findElement(successpaymentMsg).isDisplayed();
	}
}
