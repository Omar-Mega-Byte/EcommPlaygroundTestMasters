package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class AddressBookPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public AddressBookPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    private final By newAddress = By.xpath("//*[@id=\"content\"]/div[2]/div[2]/a");
    private final By continueBtn = By.xpath("//*[@id=\"content\"]/form/div/div[2]/input");
    private final By fName = By.id("input-firstname");
    private final By lName = By.id("input-lastname");
    private final By company = By.id("input-company");
    private final By firstAddress = By.id("input-address-1");
    private final By secondAddress = By.id("input-address-2");
    private final By city = By.id("input-city");
    private final By postalCode = By.id("input-postcode");
    private final By country = By.id("input-country");
    private final By region = By.id("input-zone");
    private final By successMessage = By.cssSelector("div.alert-success");

    public void addNewAddress(String firstName, String lastName, String comp, String addr1, String addr2,
                              String cityName, String postCode, String countryName, String regionCode) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(newAddress)).click();

            fillInputField(fName, firstName);
            fillInputField(lName, lastName);
            fillInputField(company, comp);
            fillInputField(firstAddress, addr1);
            fillInputField(secondAddress, addr2);
            fillInputField(city, cityName);
            fillInputField(postalCode, postCode);

            Select countryDropdown = new Select(wait.until(ExpectedConditions.elementToBeClickable(country)));
            countryDropdown.selectByVisibleText(countryName);

            wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.cssSelector("#input-zone option[value='" + regionCode + "']")
            ));

            Select regionDropdown = new Select(driver.findElement(region));
            regionDropdown.selectByValue(regionCode);

            wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();
        } catch (Exception e) {
            System.err.println("Error adding new address: " + e.getMessage());
            try {
                Select regionDropdown = new Select(driver.findElement(region));
                System.out.println("Available region options:");
                for (WebElement option : regionDropdown.getOptions()) {
                    String value = option.getAttribute("value");
                    String text = option.getText();
                    if (!value.isEmpty()) {
                        System.out.println("Value: " + value + ", Text: " + text);
                    }
                }
            } catch (Exception debugEx) {
                System.err.println("Could not retrieve region options: " + debugEx.getMessage());
            }
            throw e;
        }
    }

    public void verifyAddressAddedSuccessfully() {
        WebElement successElement = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        String expectedMessage = "Your address has been successfully added";
        String actualMessage = successElement.getText().replaceAll("[\\n\\t]", "").trim();
        if (!actualMessage.contains(expectedMessage)) {
            throw new AssertionError(
                    "Expected success message to contain: '" + expectedMessage + "', but found: '" + actualMessage + "'"
            );
        }
    }

    private void fillInputField(By locator, String value) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        if (value != null && !value.isEmpty()) {
            element.sendKeys(value);
        }
    }
}