package prathmesh;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchTest {

	WebDriver driver ;
		
	@BeforeMethod
	
	public void setup() {
		// Setup ChromeDriver using WebDriverManager
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// Maximize the browser window
		driver.manage().window().maximize();
		
		
	}
	
	@Test
	public void VerifySauceDemoTitle() {
		
		driver.get("https://www.saucedemo.com/");
		
		//Actual Title
		String ActTitle = driver.getTitle();
		System.out.println("Page Title is : "+ActTitle);
		
		// Expected title
        String expTitle = "Swag Labs";
		
        Assert.assertEquals(ActTitle, expTitle , "Title verification failed!");
		
		
	}
	
	@AfterMethod
	public void teardown() {
		
		//close browser
		if(driver != null) {
			driver.quit();
		}
		
	}
	
}
