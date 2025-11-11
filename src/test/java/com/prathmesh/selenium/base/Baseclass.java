package com.prathmesh.selenium.base;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.prathmesh.selenium.base.Driverfactory;
import com.prathmesh.selenium.reports.Extentmanager;
import com.prathmesh.selenium.utils.ScreenshotUtils;
import com.prathmesh.selenium.utils.configreader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {

	protected WebDriver driver ;
	protected ExtentReports extent;
	protected ExtentTest test;

	@BeforeSuite
	public void setupReports () {
		extent = Extentmanager.getreportsInstance();
	}

	@BeforeClass
	public void setup() {

		Driverfactory.initDriver();
		driver = Driverfactory.getDriver();
		configreader.loadproperties();

		driver.get(configreader.getproperties("baseUrl"));
	}

	@BeforeMethod
	public void startLogging(Method method) {
		test = extent.createTest(method.getName()); // Logs each test separately
	}

	@AfterMethod
	public void logResults(ITestResult result) {

		if(result.getStatus()==ITestResult.FAILURE) {
			String screenshotPath = ScreenshotUtils.capturescreenshot(driver, result.getName());
			test.log(Status.FAIL, "Test FAILED: " + result.getThrowable());
			test.addScreenCaptureFromPath(screenshotPath);
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test PASSED");
		}
		else {
			test.log(Status.SKIP, "Test SKIPPED");
		}
	}

	@AfterClass
	public void teardown() {
		Driverfactory.quitDriver();
	}

	@AfterSuite
	public void tearDownReport() {
		extent.flush();
	}
}
