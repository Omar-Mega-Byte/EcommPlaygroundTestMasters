package org.example.tests;

import org.example.BaseTest;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.example.pages.ProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class LambdaCompareProductTest extends BaseTest {

    @Test
    public void testCompareTwoProducts() {
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");

        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("godzilla@gmail.com", "Haha_123");

        homePage.accessHome();

        homePage.clickAProduct();
        productPage.addToComparison();

        homePage.accessHome();

        //مش عارف احطها في ال Page 😂
        driver.findElement(By.xpath("//*[@id=\"mz-product-listing-image-39217984-0-3\"]/div/div[1]/img")).click();
        productPage.addToComparison();

        homePage.compareProducts();

        wait.until(ExpectedConditions.urlContains("compare"));
        assertTrue(driver.getCurrentUrl().contains("compare"), "Comparison page should be displayed");

        int productCount = driver.findElements(By.cssSelector(".table-responsive tbody tr")).size();
        assertTrue(productCount >= 2, "At least two products should be in comparison");
    }
}