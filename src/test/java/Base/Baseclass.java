package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {

	  protected WebDriver driver ;
	
	@BeforeMethod
	
	public void setup() {
		// Setup ChromeDriver using WebDriverManager
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// Maximize the browser window
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
	}
	
	@AfterMethod
	public void teardown() {
		
		//close browser
		if(driver != null) {
			driver.quit();
		}
}
}
