package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.prathmesh.selenium.base.Driverfactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {

	  protected WebDriver driver ;
	
	@BeforeMethod
	
	public void setup() {
		Driverfactory.initDriver();
		driver = Driverfactory.getDriver();
		driver.get("https://www.saucedemo.com/");
	}
	
	@AfterMethod
	public void teardown() {
		
		//close browser
		Driverfactory.quitDriver();
}
}
