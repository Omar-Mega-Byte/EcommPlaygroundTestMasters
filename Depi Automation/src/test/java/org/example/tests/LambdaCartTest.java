package org.example.tests;

import org.example.BaseTest;
import org.example.pages.HomePage;
import org.example.pages.ProductPage;
import org.testng.annotations.Test;
import org.testng.Assert;

public class LambdaCartTest extends BaseTest {

    @Test
    public void CartTest() {
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=common/home");
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);

        homePage.clickAProduct();
        productPage.addToCart();
        homePage.accessCart();

        Assert.assertTrue(driver.getCurrentUrl().contains("route=checkout/cart"),
                "Cart page URL is incorrect");

        Assert.assertTrue(homePage.isCartNotEmpty(),
                "Cart is empty after adding product");
    }
}