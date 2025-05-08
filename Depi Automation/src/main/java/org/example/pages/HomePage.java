package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    CheckoutPage checkoutPage;
    ProductPage productPage;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.checkoutPage = new CheckoutPage(driver);
        this.productPage = new ProductPage(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    private final By home = By.xpath("//*[@id=\"widget-navbar-217834\"]/ul/li[1]/a");
    private final By product = By.xpath("//*[@id=\"mz-product-listing-image-39217984-0-2\"]/div/div[1]/img");
    public final By product2 = By.xpath("//*[@id=\"mz-product-listing-image-39217984-0-3\"]/div/div[1]/img");
    private final By cart = By.id("entry_217825");
    private final By editCart = By.xpath("//*[@id=\"entry_217850\"]/a");
    private final By wishlist = By.id("entry_217824");
    private final By checkoutBtn = By.xpath("//*[@id=\"content\"]/div[2]/a[2]");
    private final By searchBtn = By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div[2]/input");
    private final By compareLink = By.xpath("//*[@id=\"entry_217823\"]/a");
    private final By blogLink = By.xpath("//*[@id=\"widget-navbar-217834\"]/ul/li[3]/a");
    private final By widgetLink = By.xpath("//*[@id=\"widget-navbar-217834\"]/ul/li[5]/ul/li[3]/a");
    private final By addonsLink= By.xpath("//*[@id=\"widget-navbar-217834\"]/ul/li[5]/a");

    public void clickAProduct(){
        WebElement productElement = wait.until(ExpectedConditions.elementToBeClickable(product));
        productElement.click();
    }

    public void accessCart(){
        wait.until(ExpectedConditions.elementToBeClickable(cart)).click();
        wait.until(ExpectedConditions.elementToBeClickable(editCart)).click();
    }

    public void accessWishlist(){
        wait.until(ExpectedConditions.elementToBeClickable(wishlist)).click();
    }

    public void accessHome(){
        wait.until(ExpectedConditions.elementToBeClickable(home)).click();
    }

    public void accessWidget(){
        Actions actions = new Actions(driver);
        actions.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(addonsLink))).perform();
        wait.until(ExpectedConditions.elementToBeClickable(widgetLink)).click();
    }

    public void accessBlog(){
        wait.until(ExpectedConditions.elementToBeClickable(blogLink)).click();
    }

    public void checkOutAndFillForm(String firstName, String lastName, String comp, String addr1, String addr2,
                                    String cityName, String postCode, String phone, String countryName, int regionIndex) {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn)).click();
        checkoutPage.fillCheckoutForm(firstName, lastName, comp, addr1, addr2, cityName, postCode, phone, countryName, regionIndex);
    }

    public void searchAProduct(String product){

    }

    public void compareProducts(){
        WebElement compareElement = wait.until(ExpectedConditions.elementToBeClickable(compareLink));
        compareElement.click();
    }

    public boolean isCartNotEmpty() {
        List<WebElement> cartItems = driver.findElements(By.cssSelector(".table-responsive tbody tr"));
        return !cartItems.isEmpty();
    }

    public boolean isWishlistNotEmpty() {
        List<WebElement> wishlistItems = driver.findElements(By.cssSelector(".table-responsive tbody tr"));
        return !wishlistItems.isEmpty();
    }
}
