package org.example.tests;

import org.example.BaseTest;
import org.example.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LambdaLoginTest extends BaseTest {

    @Test
    public void loginTest() {
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("godzilla@gmail.com", "Haha_123");

        Assert.assertTrue(driver.getCurrentUrl().contains("route=account/account"),
                "Login failed, not redirected to account page");

        loginPage.logout();

    }
}
