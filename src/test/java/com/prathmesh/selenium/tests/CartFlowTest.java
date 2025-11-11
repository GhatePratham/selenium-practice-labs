package com.prathmesh.selenium.tests;

import com.prathmesh.selenium.pages.Homepage;
import com.prathmesh.selenium.pages.Loginpage;
import com.prathmesh.selenium.utils.configreader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.prathmesh.selenium.base.Baseclass;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

public class CartFlowTest extends Baseclass {

	Loginpage login;
	Homepage home;

	@Test
	public void AddProduct() {

		login = new Loginpage(driver);
		home = new Homepage(driver);

		login.Login(configreader.getproperties("username"), configreader.getproperties("password"));

		//actual title
		String actTitle = login.getPageTitle();
		System.out.println("Page title after login : " + actTitle);

		// Expected title
		String expTitle = "Swag Labs";
		//Validate
		Assert.assertEquals(actTitle, expTitle, "Title verification failed!");

		//get ProductCount
		int count= home.getProductCount();
		System.out.println("No of products cards available are : " +count);

		//get product names
		List<String> allNames = home.PrintProductNames();
		System.out.println("Product Names:");
		for (String name : allNames) {
			System.out.println(name);
		}

		//Add Specific Product to Cart
		String expProduct = "Sauce Labs Backpack";
		home.addProductToCart(expProduct);


	}
}

