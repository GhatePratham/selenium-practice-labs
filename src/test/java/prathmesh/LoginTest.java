package prathmesh;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.prathmesh.selenium.pages.Loginpage;

import Base.Baseclass;

public class LoginTest extends Baseclass {

	Loginpage login;
	
	@Test
	public void Loginintoapplication() {
		
		 login = new Loginpage(driver);
		login.Login("standard_user", "secret_sauce");
		
		//actual title
		String actTitle = login.getPageTitle();
		System.out.println("Page title after login : "+actTitle);
		
		// Expected title
        String expTitle = "Swag Labs";
		
	   Assert.assertEquals(actTitle, expTitle ,"Title verification failed!");
		
	}
}
