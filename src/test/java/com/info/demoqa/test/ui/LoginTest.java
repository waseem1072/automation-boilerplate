package com.info.demoqa.test.ui;

import com.maxsoft.testngtestresultsanalyzer.annotations.Category;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test(description = "Verify that a standard user can login to the application")
    @Category("Login")
    public void testStandardUser() {
        login();
    }
}