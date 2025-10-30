package prathmesh;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.Baseclass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchTest extends Baseclass{

	WebDriver driver ;
	
	@Test
	public void VerifySauceDemoTitle() {
		
		//Actual Title
		String ActTitle = driver.getTitle();
		System.out.println("Page Title is : "+ActTitle);
		
		// Expected title
        String expTitle = "Swag Labs";
		
        Assert.assertEquals(ActTitle, expTitle , "Title verification failed!");
		
	}

	}
	

