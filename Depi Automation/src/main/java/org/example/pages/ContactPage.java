package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By nameField = By.name("name");
    private By emailField = By.xpath("//*[@id=\"entry_214732\"]/div/form/div[2]/input");
    private By subjectField = By.name("subject");
    private By messageField = By.xpath("//*[@id=\"entry_214732\"]/div/form/div[4]/textarea");
    private By sendButton = By.xpath("//*[@id=\"entry_214732\"]/div/form/button");
    private By successMessage = By.cssSelector("div.alert.alert-success.alert-dismissible");

    public ContactPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }


    public void fillForm(String name, String email, String subject, String message) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(subjectField).sendKeys(subject);
        driver.findElement(messageField).sendKeys(message);
    }

    public void submitForm() {
        driver.findElement(sendButton).click();
    }

    public String getSuccessMessageText() {
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return message.getText().trim();
    }
}