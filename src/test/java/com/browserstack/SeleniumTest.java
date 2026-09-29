package com.browserstack;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class SeleniumTest {
    public WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    @SuppressWarnings("unchecked")
    public void setUpBeforeSuite() throws Exception {
        System.out.println("Running BeforeSuite");
    }

    @BeforeMethod(alwaysRun = true)
    @SuppressWarnings("unchecked")
    public void setUp1() throws Exception {
        System.out.println("Running BeforeMethod Setup1");
    }

    @BeforeMethod(alwaysRun = true)
    @SuppressWarnings("unchecked")
    public void setUp() throws Exception {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
    }

    @AfterSuite(alwaysRun = true)
    @SuppressWarnings("unchecked")
    public void tearDownAfterSuite() throws Exception {
        System.err.println("Running tearDownAfterSuite");
    }

}
