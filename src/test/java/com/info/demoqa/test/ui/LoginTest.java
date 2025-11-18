package com.info.demoqa.test.ui;

import com.info.demoqa.page.LoginPage;
import com.info.demoqa.page.ProductPage;
import com.maxsoft.testngtestresultsanalyzer.annotations.Category;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test(description = "Verify that a standard user can login to the application")
    @Category("Login")
    public void testStandardUser() {
        login();
    }
}