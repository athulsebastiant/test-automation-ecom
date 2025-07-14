package org.ats.ecom_testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import static org.ats.ecom_testing.utils.WaitUtils.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ats.ecom_testing.utils.DriverFactory;
public class SignupDataEntryPage {
	WebDriver driver;
	Actions actions;
	JavascriptExecutor js;
	private static final Logger log = LogManager.getLogger(SignupDataEntryPage.class);

	By enterAccountInfoHeader = By.xpath("//h2/b[contains(text(),'Enter Account Information')]");
	By selectTitleMr = By.id("id_gender1"); 
	By selectTitleMrs = By.id("id_gender2");
	By enterName = By.xpath("//input[@id='name']");
	By enterPasswd = By.xpath("//input[@id='password']");
	By selectDay = By.cssSelector("select#days.form-control");
	By selectMonth = By.cssSelector("select#months.form-control");
	By selectYear = By.cssSelector("select#years.form-control");
	By checkNewsletter = By.cssSelector("input#newsletter");
	By checkSpOffer = By.cssSelector("input#optin");
	
	// Address info
	
	By enterFirstName = By.cssSelector("input#first_name");
	By enterLastName = By.cssSelector("input#last_name");
	By enterCompany = By.cssSelector("input#company");
	By enterAdd1 = By.cssSelector("input#address1");
	By enterAdd2 = By.cssSelector("input#address2");
	By selectCountry = By.cssSelector("select#country");
	By enterState = By.cssSelector("input#state");
	By enterCity = By.cssSelector("input#city");
	By enterZipcode = By.cssSelector("input#zipcode");
	By enterMob = By.cssSelector("input#mobile_number");
	
	By createAccBtn = By.xpath("//button[contains(text(),'Create Account')]");
	
	
	
	public SignupDataEntryPage() {
		// TODO Auto-generated constructor stub
		this.driver = DriverFactory.getDriver();
		this.actions = new Actions(driver);
		this.js = (JavascriptExecutor)driver;
	}
	
	public boolean isEnterAccountInfoVisible() {
		log.info("Checking visibility of 'Enter Account Information' header.");
		try {
			waitForVisibility(driver, enterAccountInfoHeader, 10);
			return driver.findElement(enterAccountInfoHeader).isDisplayed();
		} catch (TimeoutException e) {
			log.error("Timeout waiting for header.", e);
		} catch (NoSuchElementException e) {
			log.error("Header not found.", e);
		} catch (Exception e) {
			log.error("Error verifying header visibility.", e);
		}
		return false;
	}
	
	public void selectTitleMr() {
		log.info("Selecting 'Mr' as title.");
		try {
			driver.findElement(selectTitleMr).click();
		} catch (Exception e) {
			log.error("Failed to select 'Mr'.", e);
		}
	}
	
	public void selectTitleMrs() {
		log.info("Selecting 'Mrs' as title.");
		try {
			driver.findElement(selectTitleMrs).click();
		} catch (Exception e) {
			log.error("Failed to select 'Mrs'.", e);
		}
	}
	
//	public void typeName(String name) {
//		driver.findElement(enterName).sendKeys(name);
//	}
	
	public void typePswd(String pswd) {
		log.info("Entering password.");
		try {
			driver.findElement(enterPasswd).sendKeys(pswd);
		} catch (Exception e) {
			log.error("Failed to enter password.", e);
		}
	}
	
	public void chooseDay(String day) {
		log.info("Selecting day: " + day);
		try {
			new Select(driver.findElement(selectDay)).selectByVisibleText(day);
		} catch (Exception e) {
			log.error("Failed to select day.", e);
		}
	}
	
	public void chooseMonth(String month) {
		log.info("Selecting month: " + month);
		try {
			new Select(driver.findElement(selectMonth)).selectByVisibleText(month);
		} catch (Exception e) {
			log.error("Failed to select month.", e);
		}
	}
	
	public void chooseYear(String year) {
		log.info("Selecting year: " + year);
		try {
			new Select(driver.findElement(selectYear)).selectByVisibleText(year);
		} catch (Exception e) {
			log.error("Failed to select year.", e);
		}
	}
	
	public void optNewsLetter(boolean choice) {
		log.info("Newsletter opt-in: " + choice);
		try {
			if (choice) {
				js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(checkNewsletter));
				driver.findElement(checkNewsletter).click();
			}
		} catch (Exception e) {
			log.error("Failed to select newsletter option.", e);
		}
	}
	
	public void optSpOffer(boolean choice) {
		log.info("Special offer opt-in: " + choice);
		try {
			if (choice) {
				js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(checkSpOffer));
				driver.findElement(checkSpOffer).click();
			}
		} catch (Exception e) {
			log.error("Failed to select special offer option.", e);
		}
	}
	
	public void typeFirstname(String fn) {
		log.info("Entering first name.");
		try {
			driver.findElement(enterFirstName).sendKeys(fn);
		} catch (Exception e) {
			log.error("Failed to enter first name.", e);
		}
	}
	
	public void typeLastname(String ln) {
		log.info("Entering last name.");
		try {
			driver.findElement(enterLastName).sendKeys(ln);
		} catch (Exception e) {
			log.error("Failed to enter last name.", e);
		}
	}
	
	public void typeCompany(String cn) {
		log.info("Entering company.");
		try {
			driver.findElement(enterCompany).sendKeys(cn);
		} catch (Exception e) {
			log.error("Failed to enter company.", e);
		}
	}
	
	public void typeAddress1(String add1) {
		log.info("Entering address line 1.");
		try {
			driver.findElement(enterAdd1).sendKeys(add1);
		} catch (Exception e) {
			log.error("Failed to enter address 1.", e);
		}
	}
	
	public void typeAddress2(String add2) {
		log.info("Entering address line 2.");
		try {
			driver.findElement(enterAdd2).sendKeys(add2);
		} catch (Exception e) {
			log.error("Failed to enter address 2.", e);
		}
	}
	
	public void chooseCountry(String country) {
		log.info("Selecting country: " + country);
		try {
			new Select(driver.findElement(selectCountry)).selectByVisibleText(country);
		} catch (Exception e) {
			log.error("Failed to select country.", e);
		}
	}
	
	public void typeState(String state) {
		log.info("Entering state.");
		try {
			driver.findElement(enterState).sendKeys(state);
		} catch (Exception e) {
			log.error("Failed to enter state.", e);
		}
	}
	
	public void typeCity(String city) {
		log.info("Entering city.");
		try {
			driver.findElement(enterCity).sendKeys(city);
		} catch (Exception e) {
			log.error("Failed to enter city.", e);
		}
	}
	
	public void typeZip(String zip) {
		log.info("Entering zip code.");
		try {
			driver.findElement(enterZipcode).sendKeys(zip);
		} catch (Exception e) {
			log.error("Failed to enter zip code.", e);
		}
	}
	
	public void typeMob(String mob) {
		log.info("Entering mobile number.");
		try {
			driver.findElement(enterMob).sendKeys(mob);
		} catch (Exception e) {
			log.error("Failed to enter mobile number.", e);
		}
	}
	
	public void clickCreateAccount() {
		log.info("Clicking on 'Create Account' button.");
		try {
			driver.findElement(createAccBtn).click();
		} catch (Exception e) {
			log.error("Failed to click 'Create Account'.", e);
		}
	}
}
