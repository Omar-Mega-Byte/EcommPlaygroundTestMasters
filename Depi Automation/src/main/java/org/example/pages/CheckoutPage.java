package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    WebDriver driver;
    WebDriverWait wait;

    public CheckoutPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    private By telephoneField = By.xpath("//*[@id=\"input-telephone\"]");
    private By newAddressField = By.xpath("//*[@id=\"payment-address\"]/div[2]/div/label");
    private By fName = By.xpath("//*[@id=\"input-payment-firstname\"]");
    private By lName = By.xpath("//*[@id=\"input-payment-lastname\"]");
    private By company = By.xpath("//*[@id=\"input-payment-company\"]");
    private By firstAddress = By.xpath("//*[@id=\"input-payment-address-1\"]");
    private By secondAddress = By.xpath("//*[@id=\"input-payment-address-2\"]");
    private By city = By.xpath("//*[@id=\"input-payment-city\"]");
    private By postalCode = By.xpath("//*[@id=\"input-payment-postcode\"]");
    private By country = By.xpath("//*[@id=\"input-payment-country\"]");
    private By region = By.xpath("//*[@id=\"input-payment-zone\"]");
    private By termsAndConditions = By.xpath("//*[@id=\"form-checkout\"]/div/div[2]/div/div[5]/label");
    private By continueBtn = By.xpath("//*[@id=\"button-save\"]");


    public void fillCheckoutForm(String firstName, String lastName, String comp, String addr1, String addr2,
                                 String cityName, String postCode, String phone, String countryName, int regionCode) {

        wait.until(ExpectedConditions.elementToBeClickable(newAddressField)).click();

        driver.findElement(fName).clear();
        driver.findElement(fName).sendKeys(firstName);

        driver.findElement(lName).clear();
        driver.findElement(lName).sendKeys(lastName);

        driver.findElement(company).clear();
        driver.findElement(company).sendKeys(comp);

        driver.findElement(firstAddress).clear();
        driver.findElement(firstAddress).sendKeys(addr1);

        driver.findElement(secondAddress).clear();
        driver.findElement(secondAddress).sendKeys(addr2);

        driver.findElement(city).clear();
        driver.findElement(city).sendKeys(cityName);

        driver.findElement(postalCode).clear();
        driver.findElement(postalCode).sendKeys(postCode);

        driver.findElement(telephoneField).clear();
        driver.findElement(telephoneField).sendKeys(phone);

        Select countryDropdown = new Select(driver.findElement(country));
        countryDropdown.selectByVisibleText(countryName);

        wait.until(ExpectedConditions.elementToBeClickable(region));
        Select regionDropdown = new Select(driver.findElement(region));
        regionDropdown.selectByValue(String.valueOf(regionCode));


        wait.until(ExpectedConditions.elementToBeClickable(termsAndConditions)).click();

        wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();
    }

}
