package org.example.tests;

import org.example.BaseTest;
import org.example.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LambdaRegisterTest extends BaseTest {

    @Test
    public void registerTest() {
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/register");

        RegisterPage registerPage = new RegisterPage(driver);
        String email = "omar" + System.currentTimeMillis() + "@example.com";
        registerPage.register("Omar", "Mohamed", email, "+201234567890", "Password123");

        Assert.assertTrue(driver.getCurrentUrl().contains("route=account/success"),
                "Registration failed, not redirected to success page");
    }
}
