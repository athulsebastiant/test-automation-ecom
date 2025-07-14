package org.ats.ecom_testing.pages;

import org.ats.ecom_testing.utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.ats.ecom_testing.utils.WaitUtils.*;

import java.time.Duration;
public class HomePage {
	WebDriver driver;
	JavascriptExecutor js;
	Actions actions;
	By signupLoginBtn = By.xpath("//a[contains(text(), 'Signup / Login')]");
	By loggedInUserName = By.xpath("//a[contains(text(),' Logged in as ')]");
	By deleteAccount = By.xpath("//a[contains(text(),' Delete Account')]");
	By logoutBtn = By.xpath("//a[contains(text(),'Logout')]");
	By contactUs = By.xpath("//a[contains(text(),'Contact us')]");
	By testCasesBtn = By.xpath("//a[contains(text(),'Test Cases')]");
	By productsBtn = By.xpath("//a[contains(text(),'Products')]");
	By subscriptionHeader = By.xpath("//h2[contains(text(),'Subscription')]");
	By subscriptionBox = By.cssSelector("input#susbscribe_email");
	By subBtn = By.cssSelector("button#subscribe");
	By succesfulSub = By.xpath("//div[@id='success-subscribe']/div");
	By cartBtn = By.xpath("//a[contains(text(),'Cart')]");
	By viewCartBtn = By.xpath("//a/u[contains(text(),'View Cart')]");
	By categoryHeader = By.xpath("//h2[contains(text(),'Category')]");
	By categoryWomen = By.xpath("//a[@href='#Women']");
	By subcategoryWomenDress = By.xpath("//div[@id='Women']/div/ul/li/a[contains(text(),'Dress')]");
	By recommededItemsHeader = By.xpath("//h2[contains(text(),'recommended items')]");
	By scrollUpArrowBtn = By.cssSelector("a#scrollUp");
	
	public HomePage() {
		this.driver = DriverFactory.getDriver();
		if (this.driver == null) {
            throw new IllegalStateException("WebDriver is null in HomePage constructor");
        }
		this.js = (JavascriptExecutor)driver;
		this.actions = new Actions(driver);
	}
	
	public boolean isHomePageVisible() {
		
		return waitForTitleContains(driver, "Automation Exercise", 10);
	}
	
	public void clickSignupLoginBtn(){
		driver.findElement(signupLoginBtn).click();
	}
	
	public boolean isLoggedInUserNameVisible() {
		waitForVisibility(driver, loggedInUserName, 10);
		return driver.findElement(loggedInUserName).isDisplayed();
	}
	
	public void clickDeleteAccountBtn() {
		driver.findElement(deleteAccount).click();
	}
	
	public void clickLogoutBtn() {
		driver.findElement(logoutBtn).click();
	}
	
	public void clickContactUsBtn() {
		driver.findElement(contactUs).click();
	}
	
	public void clickTestCasesBtn() {
		driver.findElement(testCasesBtn).click();
	}
	
	public void clickProductsBtn() {
		driver.findElement(productsBtn).click();
	}
	
	public boolean isSubscriptionHeaderVisible() {
		waitForVisibility(driver, subscriptionHeader, 10);
		return driver.findElement(subscriptionHeader).isDisplayed();
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
	
	public void clickCartBtn() {
		driver.findElement(cartBtn).click();
	}
	
	public void clickProductView(int productIndex) {
		WebElement product = driver.findElement(By.xpath("(//a[contains(text(), 'View Product')])["+productIndex+"]"));
		js.executeScript("arguments[0].scrollIntoView(true);", product);
		product.click();
	}
	
	public String clickAddToCart(int productIndex) {
		WebElement productWrapper = driver
				.findElement(By.xpath("(//div[@class='product-image-wrapper'])[" + productIndex + "]"));
		js.executeScript("arguments[0].scrollIntoView(true);", productWrapper);
		actions.moveToElement(productWrapper).perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		By dynamicAddToCartBtn = By
				.xpath("(//div[@class='product-overlay']//a[contains(text(),'Add to cart')])[" + productIndex + "]");
		waitToBeClickable(driver, dynamicAddToCartBtn, 10);
		WebElement addToCartBtn = driver.findElement(dynamicAddToCartBtn);
		actions.moveToElement(addToCartBtn).click().perform();
		WebElement productName = driver.findElement(By.xpath("(//div[@class='product-overlay'])["+productIndex+"]/div/p"));
		return productName.getText();
	}
	public void clickViewCart() {
		waitToBeClickable(driver, viewCartBtn, 10);
		actions.moveToElement(driver.findElement(viewCartBtn)).click().build().perform();
	}
	
	public boolean isCategoryHeaderDisplayed() {
		waitForVisibility(driver, categoryHeader, 10);
		return driver.findElement(categoryHeader).isDisplayed();
	}
	
	public void clickWomenCategory() {
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(categoryWomen));
		driver.findElement(categoryWomen).click();
	}
	
	public void clickWomenDressSubCategory() {
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(subcategoryWomenDress));
		driver.findElement(subcategoryWomenDress).click();
	}
	
	public boolean isRecommendedItemsDisplayed() {
		waitForVisibility(driver, recommededItemsHeader, 10);
		return driver.findElement(recommededItemsHeader).isDisplayed();
	}
	
	private String findProductInCarousel(String name) {
		return "//div[@class='recommended_items']//p[text()='"+name+"']/following-sibling::a[contains(@class, 'add-to-cart')]";
	}
	
	public void scrollToRecommendedSection() {
        WebElement recommendedSection = driver.findElement(By.xpath("//div[@class='recommended_items']"));
        js.executeScript("arguments[0].scrollIntoView(true);", recommendedSection);
    }
	
	public void clickAddToCartForRecommendedProduct(String productName) {
	    scrollToRecommendedSection();

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    By productAddToCartBtn = By.xpath(findProductInCarousel(productName));
	    By carouselRightArrow = By.cssSelector("#recommended-item-carousel .right");

	    int maxAttempts = 5;
	    int attempts = 0;

	    while (attempts < maxAttempts) {
	        try {
	            WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(productAddToCartBtn));
	            addToCartButton.click();
	            return; 
	        } catch (TimeoutException e) {
	            WebElement rightArrow = driver.findElement(carouselRightArrow);
	            rightArrow.click();
	            attempts++;
	            try {
	                Thread.sleep(1000); 
	            } catch (InterruptedException ignored) {}
	        }
	    }

	    // If this point is reached, the product was never found/clickable
	    System.out.println("Add to Cart button not found for product: " + productName);
	}
	
	public void scrollToBottomOfPage() {
		
//		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		js.executeScript("window.scroll({ top: document.body.scrollHeight, behavior: 'smooth' });");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void scrollToTop() {
		js.executeScript("window.scroll({ top: 0, behavior: 'smooth' });");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void clickScrollUpArrowBtn() {
		driver.findElement(scrollUpArrowBtn).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean verifyScrolledUp() {
		waitForVisibility(driver, By.xpath("//h2[contains(text(),'Full-Fledged practice website for Automation Engineers')]"), 10);
		return driver.findElement(By.xpath("//h2[contains(text(),'Full-Fledged practice website for Automation Engineers')]")).isDisplayed();
	}
}
