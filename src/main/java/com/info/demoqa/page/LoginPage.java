package com.info.demoqa.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) {
        inputUsername(username);
        inputPassword(password);
        clickLoginButton();
    }

    private void inputUsername(String username) {
        driver.findElement(By.id("user-name")).sendKeys(username);
    }

    private void inputPassword(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    private void clickLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    public boolean isProductsTitleVisible() {
        return driver.findElement(By.xpath("//span[@class='title']")).isDisplayed();
    }
}
