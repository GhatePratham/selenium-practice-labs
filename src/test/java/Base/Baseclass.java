package Base;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

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
		 extent= Extentmanager.getreportsInstance();
	  }
	  
	@BeforeMethod
	
	public void setup(Method method) {
		test = extent.createTest(method.getName());  //  Create a test entry in Extent report for each test method
		
		Driverfactory.initDriver();
		driver = Driverfactory.getDriver();
		configreader.loadproperties();
		
		driver.get(configreader.getproperties("baseUrl"));
		test.log(Status.INFO, "Browser launched and navigated to base URL");
	
	}
	@AfterMethod
	public void teardown(ITestResult result) {
		
		 //  Log test result in Extent Report
		if(result.getStatus()==ITestResult.FAILURE) {
			String screenshotPath = ScreenshotUtils.capturescreenshot(driver, result.getName());
			test.log(Status.FAIL, "Test FAILED: " + result.getThrowable());
			test.addScreenCaptureFromPath(screenshotPath); // attach screenshot in report
		}
		else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test PASSED");
		}
		else {
			test.log(Status.SKIP, "Test Skipped");
		}
		
		//close browser
		Driverfactory.quitDriver();
		 test.log(Status.INFO, "Browser closed");
}
	@AfterSuite
	public void tearDownReport() {
	    extent.flush();
	}

	
	
}
