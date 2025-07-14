package org.ats.ecom_testing.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Attachment;

public class AllureListener implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test Started: "+result.getMethod().getMethodName());
//		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test Passed: "+result.getMethod().getMethodName());
		takeScreenshot("Test Passed");
//		ITestListener.super.onTestSuccess(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test failed: " + result.getMethod().getMethodName());
		takeScreenshot("Test Failed");
//		ITestListener.super.onTestFailure(result);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test skipped: " + result.getMethod().getMethodName());
		takeScreenshot("Test Skipped");
//		ITestListener.super.onTestSkipped(result);
	}
	
	@Attachment(value = "Screenshot", type = "image/png")
	public byte[] takeScreenshot(String description) {
		WebDriver driver = DriverFactory.getDriver();
		if(driver != null ) {
			try {
				return((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			} catch (Exception e) {
				// TODO: handle exception
				System.err.println("Failed to take screenshot: "+e.getMessage());
				return null;
			}
		}
		return null;
	}
	
	@Attachment(value = "Page Source",type = "text/html")
	public String getPageSource() {
		WebDriver driver = DriverFactory.getDriver();
		if(driver != null){
			try {
				return driver.getPageSource();
			} catch (Exception e) {
				// TODO: handle exception
				System.err.println("Failed to get page source: " + e.getMessage());
                return "Failed to capture page source";
			}
		}
		return "Driver not available";
	}
	

}
