package com.prathmesh.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Homepage {

    // WebDriver instance
    WebDriver driver;
    WebDriverWait wait;

    // Page elements
    //Product cards
    @FindBy(xpath = "//div[@class='inventory_item']")
    public List<WebElement> productCards;

    //Initialize PageFactory
    public Homepage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Return number of products
    public int getProductCount() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(productCards));
        return productCards.size();
    }

    //Return product names
    public List<String> PrintProductNames() {
        List<String> names = new ArrayList<>();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        for (WebElement card : productCards) {
            // Wait until the product name is visible inside the card
            WebElement nameElement = wait.until(ExpectedConditions.visibilityOf(
                    card.findElement(By.xpath(".//div[contains(@class,'inventory_item_name')]"))
            ));
            names.add(nameElement.getText());
        }

        return names;
    }

    // Add a specific product to cart
    public void addProductToCart(String productName) {
        boolean productFound = false;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        for (WebElement card : productCards) {
            // Wait until the product name is visible inside the card
            WebElement nameElement = wait.until(ExpectedConditions.visibilityOf(
                    card.findElement(By.xpath(".//div[contains(@class,'inventory_item_name')]"))));

            String name = nameElement.getText();

            if (name.equalsIgnoreCase(productName)) {
                WebElement addToCartButton = card.findElement(By.xpath(".//button[contains(@class,'btn btn_primary btn_small btn_inventory')]"));
                wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
                addToCartButton.click();
                System.out.println(productName + " added to cart!");
                productFound = true;
                break;
            }
            if (!productFound) {
                System.out.println("Product '" + productName + "' not found on the page!");
                break;
            }


        }


    }

}