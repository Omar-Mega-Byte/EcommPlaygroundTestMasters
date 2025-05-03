package org.example.tests;

import org.example.BaseTest;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.example.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LambdaCheckoutTest extends BaseTest{

    @Test
    public void checkoutTest() {
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");

        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("godzilla@gmail.com", "Haha_123");

        homePage.accessHome();
        homePage.clickAProduct();
        productPage.addToCart();
        homePage.accessCart();
        homePage.checkOutAndFillForm("Omar","Ahmed","HelwanSoft","123 Nile St", "Floor 2", "Cairo","11435", "01012345678", "Egypt", 1008);

        Assert.assertTrue(driver.getCurrentUrl().contains("route=checkout/success"),
                "Checkout failed, not redirected to success page");
    }

}
