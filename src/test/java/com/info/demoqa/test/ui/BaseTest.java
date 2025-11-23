package com.info.demoqa.test.ui;

import com.info.demoqa.page.LoginPage;
import com.info.demoqa.util.PropertyFileReader;
import com.maxsoft.testngtestresultsanalyzer.DriverHolder;
import com.maxsoft.testngtestresultsanalyzer.TestAnalyzeReportListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.time.Duration;

@Listeners(TestAnalyzeReportListener.class)
public class BaseTest {
    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        setUpDriver(true);
        DriverHolder.setDriver(driver);
        driver = DriverHolder.getDriver();

        driver.get(PropertyFileReader.getPropertyValue("base_url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(125));
    }

    public void login() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(PropertyFileReader.getPropertyValue("username"), PropertyFileReader.getPropertyValue("password"));
    }

    private void setUpDriver(boolean headless) {
        if (headless) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless"); // Run Chrome in headless mode
            options.addArguments("--disable-gpu"); // Recommended for headless
            options.addArguments("--window-size=1920,1080"); // Optional but recommended
            options.addArguments("--remote-allow-origins=*"); // Keep your existing options
            driver = new ChromeDriver(options);
        }
        else {
            driver = new ChromeDriver();
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
