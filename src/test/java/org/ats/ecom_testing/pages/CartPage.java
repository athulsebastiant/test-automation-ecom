package org.ats.ecom_testing.pages;

import static org.ats.ecom_testing.utils.WaitUtils.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.ats.ecom_testing.utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	WebDriver driver;
	JavascriptExecutor js;
	By subscriptionBox = By.cssSelector("input#susbscribe_email");
	By subBtn = By.cssSelector("button#subscribe");
	By succesfulSub = By.xpath("//div[@id='success-subscribe']/div");
	By proceedToCheckoutBtn = By.xpath("//a[contains(text(),'Proceed To Checkout')]");
	By registerLoginBtn = By.xpath("//a[u[contains(text(),'Register / Login')]]");
	By signupLogin = By.xpath("//a[contains(text(), 'Signup / Login')]");
	
	
	
	public CartPage() {
		this.driver = DriverFactory.getDriver();
		this.js = (JavascriptExecutor)driver;
	}
	
	public void subscribe(String email) {
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(subscriptionBox));
		driver.findElement(subscriptionBox).sendKeys(email);
		driver.findElement(subBtn).click();
	}
	
	public boolean subConfirmation() {
		waitForVisibility(driver, succesfulSub, 10);
		return driver.findElement(succesfulSub).isDisplayed();
	}
	
	public Set<String> getAllProductsinCart(){
		Set<String> productNames = new HashSet();
		List<WebElement> nameElements = driver.findElements(By.xpath("//table/tbody/tr/td[2]/h4/a"));
		for(WebElement element : nameElements) {
	        productNames.add(element.getText().trim());
	    }

	    return productNames;
	}
	
	public String getProductNameAtIndex(int index) {
	    String xpath = "//table/tbody/tr[" + index + "]/td[2]/h4/a";
	    WebElement nameElement = driver.findElement(By.xpath(xpath));
	    return nameElement.getText().trim();
	}
	
	
	
	public int getQuantity(int productIndex) {
		By quantity = By.xpath("//table/tbody/tr["+productIndex+"]/td[4]");
		waitForVisibility(driver, quantity, 10);
		
		String qty = driver.findElement(quantity).getText();
		return Integer.parseInt(qty);
	}

	public void clickProceedToCheckoutBtn() {
		waitToBeClickable(driver, proceedToCheckoutBtn, 10);
		driver.findElement(proceedToCheckoutBtn).click();
	}
	
	public void clickRegisterLoginBtn() {
		waitToBeClickable(driver, registerLoginBtn, 10);
		driver.findElement(registerLoginBtn).click();
	}
	
	public void clickRemoveProduct(int productIndex) {
		By removeProductBtn = By.xpath("//table/tbody/tr["+productIndex+"]/td[6]/a");
		driver.findElement(removeProductBtn).click();
	}
	
	public void waitUntilProductRemoved(String productName) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    wait.until(driver -> {
	        Set<String> currentProducts = getAllProductsinCart();
	        return !currentProducts.contains(productName);
	    });
	}
	
	public void clickSignupLogin() {
		driver.findElement(signupLogin).click();
	}

}
