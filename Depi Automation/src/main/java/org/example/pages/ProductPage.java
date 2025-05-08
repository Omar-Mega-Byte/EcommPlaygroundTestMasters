package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    WebDriver driver;
    WebDriverWait wait;

    private By cartButton = By.xpath("//*[@id=\"entry_216842\"]/button");
    private By wishlisttButton = By.xpath("//*[@id=\"image-gallery-216811\"]/div[1]/button");
    private By compareButton = By.xpath("//*[@id=\"entry_216844\"]/button");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    public void addToCart(){
        driver.findElement(cartButton).click();
    }

    public void addToWishlist(){
        driver.findElement(wishlisttButton).click();
    }

    public void addToComparison(){
        wait.until(ExpectedConditions.elementToBeClickable(compareButton)).click();

    }
}
