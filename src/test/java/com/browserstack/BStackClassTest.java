package com.browserstack;

import com.browserstack.SeleniumTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BStackClassTest {
    public WebDriver driver;
    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        // driver.get("https://www.google.com");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        System.out.println("This runs before the first method in this class.");
    }

    @Test
    public void addProductToCartInClass() throws Exception {
        // navigate to bstackdemo
        driver.get("https://www.bstackdemo.com");

        // Check the title
        Assert.assertTrue(driver.getTitle().matches("StackDemo"));

        // Save the text of the product for later verify
        String productOnScreenText = driver.findElement(By.xpath("//*[@id=\"1\"]/p")).getText();
        // Click on add to cart button
        driver.findElement(By.xpath("//*[@id=\"1\"]/div[4]")).click();
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        //Call getScreenshotAs method to create image file
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        // See if the cart is opened or not
        Assert.assertTrue(driver.findElement(By.cssSelector(".float\\-cart__content")).isDisplayed());

        // Check the product inside the cart is same as of the main page
        String productOnCartText = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div[2]/div[2]/div[2]/div/div[3]/p[1]")).getText();
        Assert.assertEquals(productOnScreenText, productOnCartText);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        // driver.get("https://www.google.com");
        driver.quit();
        System.out.println("This runs after all methods in this class.");
    }
}
