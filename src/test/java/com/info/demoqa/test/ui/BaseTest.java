package com.info.demoqa.test.ui;

import com.info.demoqa.page.LoginPage;
import com.info.demoqa.util.PropertyFileReader;
import com.maxsoft.testngtestresultsanalyzer.DriverHolder;
import com.maxsoft.testngtestresultsanalyzer.TestAnalyzeReportListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.time.Duration;

@Listeners(TestAnalyzeReportListener.class)
public class BaseTest {
    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        DriverHolder.setDriver(driver);
        driver = DriverHolder.getDriver();
        driver.get(PropertyFileReader.getPropertyValue("base_url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
    }

    public void login() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(PropertyFileReader.getPropertyValue("username"), PropertyFileReader.getPropertyValue("password"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
