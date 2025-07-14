package org.ats.ecom_testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import static org.ats.ecom_testing.utils.WaitUtils.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ats.ecom_testing.utils.DriverFactory;
public class SignupLoginPage {
	WebDriver driver;
	private static final Logger log = LogManager.getLogger(SignupLoginPage.class);

	By newUserSignupHeader = By.xpath("//h2[contains(text(),'New User Signup!')]");
	By signupNameInputBox = By.xpath("//form[@action='/signup']/input[@placeholder='Name']");
	By signUpEmailInputBox = By.xpath("//form[@action='/signup']/input[@placeholder='Email Address']");
	By signupBtn = By.xpath("//button[contains(text(),'Signup')]");
	
	By loginHeader = By.xpath("//h2[contains(text(),'Login to your account')]");
	
	By loginEmailInput = By.xpath("//form[@action='/login']/input[@type='email']");
	By loginPass = By.xpath("//form[@action='/login']/input[@type='password']");
	By loginBtn = By.xpath("//form[@action='/login']/button[contains(text(),'Login')]");
	
	By incorrectCredWarning = By.xpath("//p[contains(text(),'Your email or password is incorrect!')]");
	
	By emailAddressExists = By.xpath("//p[contains(text(),'Email Address already exist!')]");
	public SignupLoginPage() {
		this.driver = DriverFactory.getDriver();
	}

	public boolean isNewUserSignupVisible() {
		log.info("Checking if 'New User Signup!' header is visible.");
		try {
			waitForVisibility(driver, newUserSignupHeader, 10);
			return driver.findElement(newUserSignupHeader).isDisplayed();
		} catch (TimeoutException e) {
			log.error("Timeout while waiting for 'New User Signup!' header.", e);
		} catch (NoSuchElementException e) {
			log.error("'New User Signup!' header not found.", e);
		} catch (Exception e) {
			log.error("Unexpected error while checking for 'New User Signup!' header.", e);
		}
		return false;
	}

	public boolean isLoginHeaderVisible() {
		log.info("Checking if 'Login to your account' header is visible.");
		try {
			waitForVisibility(driver, loginHeader, 10);
			return driver.findElement(loginHeader).isDisplayed();
		} catch (TimeoutException e) {
			log.error("Timeout while waiting for login header.", e);
		} catch (NoSuchElementException e) {
			log.error("Login header not found.", e);
		} catch (Exception e) {
			log.error("Unexpected error while checking for login header.", e);
		}
		return false;
	}
	
	public void enterName(String name) {
		log.info("Entering name: " + name);
		try {
			driver.findElement(signupNameInputBox).sendKeys(name);
		} catch (Exception e) {
			log.error("Failed to enter name.", e);
		}

	}
	
	public void enterSignupEmail(String email) {
		log.info("Entering signup email: " + email);
		try {
			driver.findElement(signUpEmailInputBox).sendKeys(email);
		} catch (Exception e) {
			log.error("Failed to enter signup email.", e);
		}
	}
	
	public void clickSignupBtn() {
		log.info("Clicking on 'Signup' button.");
		try {
			driver.findElement(signupBtn).click();
		} catch (Exception e) {
			log.error("Failed to click 'Signup' button.", e);
		}
	}
	
	public void enterLoginEmail(String email) {
		log.info("Entering login email: " + email);
		try {
			driver.findElement(loginEmailInput).sendKeys(email);
		} catch (Exception e) {
			log.error("Failed to enter login email.", e);
		}
	}
	
	public void enterLoginPassword(String pswd) {
		log.info("Entering login password.");
		try {
			driver.findElement(loginPass).sendKeys(pswd);
		} catch (Exception e) {
			log.error("Failed to enter login password.", e);
		}
	}
	
	public void clickLoginBtn() {
		log.info("Clicking on 'Login' button.");
		try {
			driver.findElement(loginBtn).click();
		} catch (Exception e) {
			log.error("Failed to click 'Login' button.", e);
		}
	}
	
	public boolean isIncorrectCredWarningIsVisible() {
		log.info("Checking for incorrect credentials warning.");
		try {
			waitForVisibility(driver, incorrectCredWarning, 10);
			return driver.findElement(incorrectCredWarning).isDisplayed();
		} catch (TimeoutException e) {
			log.error("Timeout waiting for incorrect credentials warning.", e);
		} catch (NoSuchElementException e) {
			log.error("Incorrect credentials warning not found.", e);
		} catch (Exception e) {
			log.error("Error while checking incorrect credentials warning.", e);
		}
		return false;
	}
	
	public boolean isExistingEmailWarningIsVisible() {
		log.info("Checking for existing email warning.");
		try {
			waitForVisibility(driver, emailAddressExists, 10);
			return driver.findElement(emailAddressExists).isDisplayed();
		} catch (TimeoutException e) {
			log.error("Timeout waiting for existing email warning.", e);
		} catch (NoSuchElementException e) {
			log.error("Existing email warning not found.", e);
		} catch (Exception e) {
			log.error("Error while checking existing email warning.", e);
		}
		return false;
	}
	
	
	
}
