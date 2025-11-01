package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.prathmesh.selenium.base.Driverfactory;
import com.prathmesh.selenium.utils.configreader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {

	  protected WebDriver driver ;
	
	@BeforeMethod
	
	public void setup() {
		Driverfactory.initDriver();
		driver = Driverfactory.getDriver();
		configreader.loadproperties();
		
		driver.get(configreader.getproperties("baseUrl"));
	
	}
	@AfterMethod
	public void teardown() {
		
		//close browser
		Driverfactory.quitDriver();
}
}
