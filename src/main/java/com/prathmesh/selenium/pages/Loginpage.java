package com.prathmesh.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

	// WebDriver instance
    WebDriver driver;
    
   // Page elements (locators)
	@FindBy(xpath = "//input[@id='user-name']")private WebElement Username;
	@FindBy(xpath = "//input[@id='password'] ")private WebElement Password ; 
	@FindBy(xpath =  "//input[@id='login-button']")private WebElement Loginbutton ; 
	
	public Loginpage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // initializes all @FindBy elements
	}
	
	//  Page actions (methods)
	public  void enterusername (String username) {
		Username.sendKeys(username);
	}
	
	public void enterpassword (String password) {
		Password.sendKeys(password);
	}
	
	public void clickLogin () {
		Loginbutton.click();
	}
	
	public void Login(String username , String password) {
		enterusername(username);
		enterpassword(password);
		clickLogin();
	}
	
	//  Optional verification
    public String getPageTitle() {
        return driver.getTitle();
    }
	
	
	
}
	