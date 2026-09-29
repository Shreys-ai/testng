package com.browserstack;

import com.browserstack.SeleniumTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class BStackFailedTest extends SeleniumTest {
    @Test(groups = {"regression"})
    public void addProductToCart() throws Exception {
        // navigate to bstackdemo
        driver.get("https://www.bstackdemo.com");

        // Initialize WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Check the title
        Assert.assertTrue(driver.getTitle().matches("StackDemo"));

        // Wait for product element to be visible and save the text for later verify
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"1\"]/p")));
        String productOnScreenText = driver.findElement(By.xpath("//*[@id=\"1\"]/p")).getText();
        
        // Wait for add to cart button to be visible and click
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"1\"]/div[4]")));
        driver.findElement(By.xpath("//*[@id=\"1\"]/div[4]")).click();
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        //Call getScreenshotAs method to create image file
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        
        // Wait for cart to be visible and verify it's opened
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".float\\-cart__content")));
        Assert.assertTrue(driver.findElement(By.cssSelector(".float\\-cart__content")).isDisplayed());

        // Check the product inside the cart is same as of the main page
        String productOnCartText = "randomText";
        Assert.assertEquals(productOnScreenText, productOnCartText);
    }

}
