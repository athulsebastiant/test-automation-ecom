package org.ats.ecom_testing.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ats.ecom_testing.utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.ats.ecom_testing.utils.WaitUtils.*;

import java.time.Duration;
public class HomePage {
	private static final Logger log = LogManager.getLogger(HomePage.class);
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
		 log.info("Verifying home page title contains 'Automation Exercise'");
		 try {
	            boolean visible = waitForTitleContains(driver, "Automation Exercise", 10);
	            log.info("Home page visibility: {}", visible);
	            return visible;
	        } catch (TimeoutException e) {
	            log.error("Timeout waiting for home page title", e);
	            return false;
	        } catch (Exception e) {
	            log.error("Unexpected error verifying home page", e);
	            return false;
	        }
	}
	
	public void clickSignupLoginBtn(){
		 log.info("Clicking Signup / Login button");
	        try {
	            driver.findElement(signupLoginBtn).click();
	            log.info("Signup / Login clicked");
	        } catch (Exception e) {
	            log.error("Error clicking Signup / Login button", e);
	            throw e;
	        }
	}
	
	public boolean isLoggedInUserNameVisible() {
		log.info("Checking if 'Logged in as' is visible");
        try {
            waitForVisibility(driver, loggedInUserName, 15);
            boolean visible = driver.findElement(loggedInUserName).isDisplayed();
            log.info("Logged in username visible: {}", visible);
            return visible;
        } catch (TimeoutException e) {
            log.error("Timeout waiting for logged-in username", e);
            return false;
        } catch (NoSuchElementException e) {
            log.error("Logged-in username element not found", e);
            return false;
        } catch (Exception e) {
            log.error("Unexpected error checking logged-in username", e);
            return false;
        }
	}
	
	public void clickDeleteAccountBtn() {
		log.info("Clicking Delete Account button");
        try {
            driver.findElement(deleteAccount).click();
            log.info("Delete Account clicked");
        } catch (Exception e) {
            log.error("Error clicking Delete Account button", e);
            throw e;
        }
	}
	
	public void clickLogoutBtn() {
		 log.info("Clicking Logout button");
	        try {
	            driver.findElement(logoutBtn).click();
	            log.info("Logout clicked");
	        } catch (Exception e) {
	            log.error("Error clicking Logout button", e);
	            throw e;
	        }
	}
	
	public void clickContactUsBtn() {
		log.info("Clicking Contact Us button");
        try {
            driver.findElement(contactUs).click();
            log.info("Contact Us clicked");
        } catch (Exception e) {
            log.error("Error clicking Contact Us button", e);
            throw e;
        }
	}
	
	public void clickTestCasesBtn() {
		log.info("Clicking Test Cases button");
        try {
            driver.findElement(testCasesBtn).click();
            log.info("Test Cases clicked");
        } catch (Exception e) {
            log.error("Error clicking Test Cases button", e);
            throw e;
        }
	}
	
	public void clickProductsBtn() {
		log.info("Clicking Products button");
        try {
            driver.findElement(productsBtn).click();
            log.info("Products clicked");
        } catch (Exception e) {
            log.error("Error clicking Products button", e);
            throw e;
        }
	}
	
	public boolean isSubscriptionHeaderVisible() {
		log.info("Checking subscription section visibility");
        try {
            waitForVisibility(driver, subscriptionHeader, 10);
            boolean visible = driver.findElement(subscriptionHeader).isDisplayed();
            log.info("Subscription header visible: {}", visible);
            return visible;
        } catch (Exception e) {
            log.error("Error checking subscription header visibility", e);
            return false;
        }
	}
	
	public void subscribe(String email) {
		log.info("Subscribing with email: {}", email);
        try {
            js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(subscriptionBox));
            driver.findElement(subscriptionBox).sendKeys(email);
            log.info("Subscribe email entry performed");
            driver.findElement(subBtn).click();
            log.info("Subscribe button clicked");
        } catch (Exception e) {
            log.error("Error performing subscribe", e);
            throw e;
        }
	}
	
	public boolean subConfirmation() {
		log.info("Verifying subscription confirmation");
        try {
            waitForVisibility(driver, succesfulSub, 10);
            boolean visible = driver.findElement(succesfulSub).isDisplayed();
            log.info("Subscription confirmation visible: {}", visible);
            return visible;
        } catch (Exception e) {
            log.error("Error verifying subscription confirmation", e);
            return false;
        }
	}
	
	public void clickCartBtn() {
		log.info("Clicking Cart button");
        try {
            driver.findElement(cartBtn).click();
            log.info("Cart clicked");
        } catch (Exception e) {
            log.error("Error clicking Cart button", e);
            throw e;
        }
	}
	
	public void clickProductView(int productIndex) {
		log.info("Clicking View Product for index {}", productIndex);
        try {
            WebElement product = driver.findElement(By.xpath("(//a[contains(text(), 'View Product')])[" + productIndex + "]"));
            js.executeScript("arguments[0].scrollIntoView(true);", product);
            product.click();
            log.info("Clicked View Product for index {}", productIndex);
        } catch (Exception e) {
            log.error("Error clicking View Product at index " + productIndex, e);
            throw e;
        }
	}
	
	public String clickAddToCart(int productIndex) {
		 log.info("Adding product #{} to cart", productIndex);
	        try {
	            WebElement wrapper = driver.findElement(By.xpath("(//div[@class='product-image-wrapper'])[" + productIndex + "]"));
	            js.executeScript("arguments[0].scrollIntoView(true);", wrapper);
	            actions.moveToElement(wrapper).perform();
	            Thread.sleep(2000);
	            By addBtn = By.xpath("(//div[@class='product-overlay']//a[contains(text(),'Add to cart')])[" + productIndex + "]");
	            waitToBeClickable(driver, addBtn, 10);
	            WebElement btn = driver.findElement(addBtn);
	            actions.moveToElement(btn).click().perform();
	            String name = driver.findElement(By.xpath("(//div[@class='product-overlay'])[" + productIndex + "]/div/p")).getText();
	            log.info("Product #{} '{}' added to cart", productIndex, name);
	            return name;
	        } catch (InterruptedException e) {
	            log.error("Interrupted during addToCart wait", e);
	            Thread.currentThread().interrupt();
	            throw new RuntimeException(e);
	        } catch (Exception e) {
	            log.error("Error adding product #{} to cart", productIndex, e);
	            throw e;
	        }
	}
	public void clickViewCart() {
		 log.info("Clicking View Cart");
	        try {
	            waitToBeClickable(driver, viewCartBtn, 10);
	            actions.moveToElement(driver.findElement(viewCartBtn)).click().build().perform();
	            log.info("View Cart clicked");
	        } catch (Exception e) {
	            log.error("Error clicking View Cart", e);
	            throw e;
	        }
	}
	
	public boolean isCategoryHeaderDisplayed() {
		log.info("Checking category header visibility");
        try {
            waitForVisibility(driver, categoryHeader, 10);
            boolean visible = driver.findElement(categoryHeader).isDisplayed();
            log.info("Category header visible: {}", visible);
            return visible;
        } catch (Exception e) {
            log.error("Error checking category header visibility", e);
            return false;
        }
	}
	
	public void clickWomenCategory() {
		log.info("Clicking Women category");
        try {
            js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(categoryWomen));
            driver.findElement(categoryWomen).click();
            log.info("Women category clicked");
        } catch (Exception e) {
            log.error("Error clicking Women category", e);
            throw e;
        }
	}
	
	public void clickWomenDressSubCategory() {
		log.info("Clicking Women Dress subcategory");
        try {
            js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(subcategoryWomenDress));
            driver.findElement(subcategoryWomenDress).click();
            log.info("Women Dress subcategory clicked");
        } catch (Exception e) {
            log.error("Error clicking Women Dress subcategory", e);
            throw e;
        }
	}
	
	public boolean isRecommendedItemsDisplayed() {
		log.info("Checking recommended items visibility");
        try {
            waitForVisibility(driver, recommededItemsHeader, 10);
            boolean visible = driver.findElement(recommededItemsHeader).isDisplayed();
            log.info("Recommended items visible: {}", visible);
            return visible;
        } catch (Exception e) {
            log.error("Error checking recommended items visibility", e);
            return false;
        }
	}
	
	private String findProductInCarousel(String name) {
		return "//div[@class='recommended_items']//p[text()='"+name+"']/following-sibling::a[contains(@class, 'add-to-cart')]";
	}
	
	public void scrollToRecommendedSection() {
		log.info("Scrolling to recommended items section");
        try {
            WebElement section = driver.findElement(By.xpath("//div[@class='recommended_items']"));
            js.executeScript("arguments[0].scrollIntoView(true);", section);
            log.info("Scrolled to recommended items");
        } catch (Exception e) {
            log.error("Error scrolling to recommended section", e);
            throw e;
        }
    }
	
	public void clickAddToCartForRecommendedProduct(String productName) {
		log.info("Adding recommended product '{}' to cart", productName);
		try {
			
		
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
	            log.info("Recommended product '{}' added to cart", productName);
	            return; 
	        } catch (TimeoutException e) {
	        	log.warn("Recommended product '{}' not clickable, rotating carousel (attempt {})", productName, attempts+1);
	            WebElement rightArrow = driver.findElement(carouselRightArrow);
	            rightArrow.click();
	            
	            
	                Thread.sleep(1000); 
	                attempts++;
	        }

	    
		}
	    log.error("Could not add recommended product '{}' after {} attempts", productName, attempts);
		}catch (InterruptedException e) {
			// TODO: handle exception
			log.error("Interrupted while adding recommended product '{}'", productName, e);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
		}catch (Exception e) {
            log.error("Error adding recommended product '{}' to cart", productName, e);
            throw e;
        }
	}
	
	public void scrollToBottomOfPage() {
		
//		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		log.info("Scrolling to bottom of page");
		try {
            js.executeScript("window.scroll({ top: document.body.scrollHeight, behavior: 'smooth' });");
            Thread.sleep(1000);
            log.info("Scrolled to bottom");
        } catch (InterruptedException e) {
            log.error("Interrupted during scroll to bottom", e);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        } catch (Exception e) {
            log.error("Error scrolling to bottom", e);
            throw e;
        }
	}
	
	public void scrollToTop() {
		log.info("Scrolling to top of page");
        try {
            js.executeScript("window.scroll({ top: 0, behavior: 'smooth' });");
            Thread.sleep(1000);
            log.info("Scrolled to top");
        } catch (InterruptedException e) {
            log.error("Interrupted during scroll to top", e);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        } catch (Exception e) {
            log.error("Error scrolling to top", e);
            throw e;
        }
	}
	
	public void clickScrollUpArrowBtn() {
		log.info("Clicking scroll up arrow button");
        try {
            driver.findElement(scrollUpArrowBtn).click();
            Thread.sleep(1000);
            log.info("Scroll up arrow clicked");
        } catch (InterruptedException e) {
            log.error("Interrupted after clicking scroll up arrow", e);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        } catch (Exception e) {
            log.error("Error clicking scroll up arrow", e);
            throw e;
        }
	}
	
	public boolean verifyScrolledUp() {
		log.info("Verifying scrolled up to top header");
		try {
			waitForVisibility(driver, By.xpath("//h2[contains(text(),'Full-Fledged practice website for Automation Engineers')]"), 10);
			boolean visible =  driver.findElement(By.xpath("//h2[contains(text(),'Full-Fledged practice website for Automation Engineers')]")).isDisplayed();
			log.info("'Full-Fledged practice website for Automation Engineers' visible: {}", visible);
			return visible;
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Error Verifying scrolled up to top header", e);
            return false;
		}
		
	}
}
