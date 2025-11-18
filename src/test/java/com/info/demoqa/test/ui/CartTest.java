package com.info.demoqa.test.ui;

import com.info.demoqa.page.LoginPage;
import com.info.demoqa.page.ProductPage;
import com.info.demoqa.page.YourCartPage;
import com.maxsoft.testngtestresultsanalyzer.annotations.Category;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {
    @Test(description = "Verify that a standard user can add products to card to the application")
    @Category("Cart")
    public void testAddToCardButtonChange() {
        login();
        ProductPage productPage = new ProductPage(driver);
        productPage.clickAddToCartButton();
        Assert.assertTrue(productPage.isProductsTitleVisible());
    }

    @Test(description = "Verify that a standard user can view products in the card")
    @Category("Cart")
    public void testYourCart() {
        login();
        ProductPage productPage = new ProductPage(driver);
        productPage.clickAddToCartButton();
        YourCartPage yourCartPage = new YourCartPage(driver);
        yourCartPage.clickYourCartPageButton();
        Assert.assertTrue(yourCartPage.verifyYourCartIsVisible());
    }

    @Test(description = "Verify that a standard user can remove products from the card from the application")
    @Category("Cart")
    public void testYourCartRemove() {
        login();
        ProductPage productPage = new ProductPage(driver);
        productPage.clickAddToCartButton();
        YourCartPage yourCartPage = new YourCartPage(driver);
        yourCartPage.clickYourCartPageButton();
        yourCartPage.clickRemoveButton();
        Assert.assertTrue(yourCartPage.verifyYourCartIsVisible());
    }

    @Test(description = "Verify that a standard user can continue shopping from the card from the application")
    @Category("Cart")
    public void testYourCartContinueShopping() {
        login();
        ProductPage productPage = new ProductPage(driver);
        productPage.clickAddToCartButton();
        YourCartPage yourCartPage = new YourCartPage(driver);
        yourCartPage.clickYourCartPageButton();
        yourCartPage.clickContinueShopping();
        Assert.assertTrue(yourCartPage.verifyYourCartIsVisible());
    }

    @Test(description = "Verify that a standard user can checkout from the card from the application")
    @Category("Cart")
    public void testYourCartCheckout() {
        login();
        ProductPage productPage = new ProductPage(driver);
        productPage.clickAddToCartButton();
        YourCartPage yourCartPage = new YourCartPage(driver);
        yourCartPage.clickYourCartPageButton();
        yourCartPage.clickCheckout();
        Assert.assertTrue(yourCartPage.verifyYourCartIsVisible());
    }
}
