package org.ats.ecom_testing.pages;

import org.ats.ecom_testing.utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.ats.ecom_testing.utils.WaitUtils.*;

import java.io.File;
public class ContactUsPage {
	WebDriver driver;
	
	By getInTouchHeader = By.xpath("//h2[contains(text(),'Get In Touch')]");
	By nameInput = By.xpath("//input[@placeholder='Name']");
	By emailInput = By.xpath("//input[@placeholder='Email']");
	By subjectinput = By.xpath("//input[@placeholder='Subject']");
	By messageInput = By.xpath("//textarea[@placeholder='Your Message Here']");
	By fileUpload = By.xpath("//input[@name='upload_file']");
	By submitBtn = By.xpath("//input[@value='Submit']");
	By successMsg = By.xpath("//h2[contains(text(),'Get In Touch')]/following-sibling::div[contains(text(),'Success! Your details have been submitted successfully.')]");
	By homeBtn = By.xpath("//a/span[contains(text(),' Home')]");
	public ContactUsPage() {
		this.driver = DriverFactory.getDriver();
	}
	
	public boolean isGetInTouchHeaderVisible() {
		waitForVisibility(driver, getInTouchHeader, 10);
		return driver.findElement(getInTouchHeader).isDisplayed();
	}
	
	public void enterName(String name) {
		driver.findElement(nameInput).sendKeys(name);
	}
	
	public void enterEmail(String email) {
		driver.findElement(emailInput).sendKeys(email);
	}
	
	public void enterSubject(String subject) {
		driver.findElement(subjectinput).sendKeys(subject);
	}
	
	public void enterMessage(String message) {
		driver.findElement(messageInput).sendKeys(message);
	}
	
	public void uploadFile(String relativePathToFile) {
		File file = new File(relativePathToFile);
		driver.findElement(fileUpload).sendKeys(file.getAbsolutePath());
	}
	
	public void clickSubmitBtn() {
		driver.findElement(submitBtn).click();
	}
	
	public boolean isSuccessMsgVisible() {
		waitForVisibility(driver, successMsg, 10);
		return driver.findElement(successMsg).isDisplayed();
	}
	
	public void clickHomeBtn() {
		driver.findElement(homeBtn).click();
	}
}
