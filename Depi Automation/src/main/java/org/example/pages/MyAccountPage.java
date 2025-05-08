package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class MyAccountPage {
    WebDriver driver;
    WebDriverWait wait;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    private final By addressBook = By.xpath("//*[@id=\"column-right\"]/div/a[5]");
    private final By password = By.xpath("//*[@id=\"column-right\"]/div/a[3]");
    private final By successMessage = By.cssSelector("div.alert-success");
    private final By oldPassInput = By.xpath("//*[@id=\"input-password\"]");
    private final By newPassInput = By.xpath("//*[@id=\"input-confirm\"]");
    private final By submitButton = By.xpath("//*[@id=\"content\"]/form/div[3]/div[2]/input");

    public void changePassword(String oldPass, String newPass){
        wait.until(ExpectedConditions.elementToBeClickable(password)).click();

        wait.until(ExpectedConditions.elementToBeClickable(oldPassInput)).sendKeys(oldPass);

        wait.until(ExpectedConditions.elementToBeClickable(newPassInput)).sendKeys(newPass);

        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }

    public void verifyPasswordChangedSuccessfully() {
        WebElement successElement = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        String expectedMessage = "Success: Your password has been successfully updated.";
        String actualMessage = successElement.getText().replaceAll("[\\n\\t]", "").trim();
        if (!actualMessage.contains(expectedMessage)) {
            throw new AssertionError(
                    "Expected success message to contain: '" + expectedMessage + "', but found: '" + actualMessage + "'"
            );
        }
    }
}