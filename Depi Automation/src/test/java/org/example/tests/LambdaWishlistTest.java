package org.example.tests;

import org.example.BaseTest;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.example.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LambdaWishlistTest extends BaseTest {

    @Test
    public void CartTest() {

        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("godzilla@gmail.com", "Haha_123");

        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=common/home");
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);

        homePage.clickAProduct();
        productPage.addToWishlist();
        homePage.accessWishlist();

        Assert.assertTrue(driver.getCurrentUrl().contains("route=account/wishlist"),
                "Wishlist page URL is incorrect");
        Assert.assertTrue(homePage.isWishlistNotEmpty(),
                "Wishlist is empty after adding product");
    }
}