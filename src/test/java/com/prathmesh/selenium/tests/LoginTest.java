package com.prathmesh.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.prathmesh.selenium.base.Baseclass;
import com.prathmesh.selenium.pages.Loginpage;
import com.prathmesh.selenium.utils.configreader;

public class LoginTest extends Baseclass {

	Loginpage login;
	
	@Test
	public void Loginintoapplication() {
		
		 login = new Loginpage(driver);
		login.Login(configreader.getproperties("username"), configreader.getproperties("password"));
		
		//actual title
		String actTitle = login.getPageTitle();
		System.out.println("Page title after login : "+actTitle);
		
		// Expected title
        String expTitle = "Swag Labs";
		
	   Assert.assertEquals(actTitle, expTitle ,"Title verification failed!");                                                                                                    
		
	}
}
                                                          
   
   
