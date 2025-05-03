package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    WebDriver driver;

    private By firstName = By.id("input-firstname");
    private By lastName = By.id("input-lastname");
    private By email = By.id("input-email");
    private By phone = By.id("input-telephone");
    private By password = By.id("input-password");
    private By confirmPassword = By.id("input-confirm");
    private By newsletterYes = By.cssSelector("label[for='input-newsletter-yes']");
    private By agree = By.cssSelector("label[for='input-agree']");
    private By continueButton = By.cssSelector("input[type='submit'][value='Continue']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void register(String fName, String lName, String emailStr, String phoneNum, String pass) {
        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(email).sendKeys(emailStr);
        driver.findElement(phone).sendKeys(phoneNum);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(confirmPassword).sendKeys(pass);
        driver.findElement(newsletterYes).click();
        driver.findElement(agree).click();
        driver.findElement(continueButton).click();
    }
}
