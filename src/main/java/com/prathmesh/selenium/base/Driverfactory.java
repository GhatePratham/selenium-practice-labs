package com.prathmesh.selenium.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driverfactory {

	 // ThreadLocal ensures thread-safety for parallel execution in future
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    // Launch browser
    public static void initDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // open browser in maximized mode
        //options.addArguments("--disable-notifications");
        driver.set(new ChromeDriver(options));
    }

    // Return driver instance
    public static WebDriver getDriver() {
        return driver.get(); //Returns the current thread’s driver
    }

    // Quit driver
    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();//Cleans up driver reference after quitting
        }
}
}