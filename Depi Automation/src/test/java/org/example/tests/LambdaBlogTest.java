package org.example.tests;

import org.example.BaseTest;
import org.example.pages.BlogPage;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class LambdaBlogTest extends BaseTest {
    @Test
    public void BlogTest(){
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        HomePage homePage = new HomePage(driver);
        BlogPage blogPage = new BlogPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("godzilla@gmail.com", "Haha_123");

        homePage.accessHome();
        homePage.accessBlog();
        blogPage.accessArticle();
        blogPage.typeAComment("BLA BLA BLA BLA BLA BLA BLA BLA BLA BLA BLA BLA BLA BLA BLA BLA BLA BLA ");
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div.alert.alert-success.alert-dismissible")));
        String expectedMessage = "Thank you for your comment. It has been submitted to the webmaster for approval.";
        assertEquals("Success message should match", expectedMessage, successMessage.getText().trim());
    }
}
