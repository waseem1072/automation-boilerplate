package com.info.demoqa.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    private WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddToCartButton() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    public boolean isProductsTitleVisible() {
        return driver.findElement(By.xpath("//span[@class='title']")).isDisplayed();
    }
}
