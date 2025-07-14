package org.ats.ecom_testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.ats.ecom_testing.utils.WaitUtils.*;

import org.ats.ecom_testing.utils.DriverFactory;
public class SignupLoginPage {
	WebDriver driver;
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
		waitForVisibility(driver, newUserSignupHeader, 10);
		return driver.findElement(newUserSignupHeader).isDisplayed();
	}

	public boolean isLoginHeaderVisible() {
		waitForVisibility(driver, loginHeader, 10);
		return driver.findElement(loginHeader).isDisplayed();
	}
	
	public void enterName(String name) {
		driver.findElement(signupNameInputBox).sendKeys(name);

	}
	
	public void enterSignupEmail(String email) {
		driver.findElement(signUpEmailInputBox).sendKeys(email);
	}
	
	public void clickSignupBtn() {
		driver.findElement(signupBtn).click();
	}
	
	public void enterLoginEmail(String email) {
		driver.findElement(loginEmailInput).sendKeys(email);
	}
	
	public void enterLoginPassword(String pswd) {
		driver.findElement(loginPass).sendKeys(pswd);
	}
	
	public void clickLoginBtn() {
		driver.findElement(loginBtn).click();
	}
	
	public boolean isIncorrectCredWarningIsVisible() {
		waitForVisibility(driver, incorrectCredWarning, 10);
		return driver.findElement(incorrectCredWarning).isDisplayed();
	}
	
	public boolean isExistingEmailWarningIsVisible() {
		waitForVisibility(driver, emailAddressExists, 10);
		return driver.findElement(emailAddressExists).isDisplayed();
	}
	
	
	
}
