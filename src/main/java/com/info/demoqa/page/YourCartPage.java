package com.info.demoqa.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YourCartPage {
    private WebDriver driver;

    public YourCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickYourCartPageButton() {
        driver.findElement(By.id("shopping_cart_container")).click();
    }

    public void clickRemoveButton() {
        driver.findElement(By.id("remove-sauce-labs-backpack")).click();
    }

    public void clickContinueShopping() {
        driver.findElement(By.id("continue-shopping")).click();
    }

    public void clickCheckout() {
        driver.findElement(By.id("checkout")).click();
    }

    public boolean verifyYourCartIsVisible() {
        return driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).isDisplayed();
    }
}
