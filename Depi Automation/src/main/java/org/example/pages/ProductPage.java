package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    WebDriver driver;

    private By cartButton = By.xpath("//*[@id=\"entry_216842\"]/button");
    private By wishlisttButton = By.xpath("//*[@id=\"image-gallery-216811\"]/div[1]/button");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addToCart(){
        driver.findElement(cartButton).click();
    }

    public void addToWishlist(){
        driver.findElement(wishlisttButton).click();
    }
}
