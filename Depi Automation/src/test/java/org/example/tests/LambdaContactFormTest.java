package org.example.tests;

import org.example.BaseTest;
import org.example.pages.ContactPage;
import org.example.pages.HomePage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.testng.AssertJUnit.assertEquals;

public class LambdaContactFormTest extends BaseTest {

    @Test
    public void testContactFormSubmission() {
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=common/home");
        ContactPage contactPage = new ContactPage(driver);
        HomePage homePage = new HomePage(driver);

        homePage.accessWidget();
        contactPage.fillForm("Omar Ahmed", "example@example.com", "Test Test", "This is a test message.");

        contactPage.submitForm();

        String expectedMessage = "Thank you for your comment. It has been submitted to the webmaster for approval.";
        assertEquals("Success message should match", expectedMessage, contactPage.getSuccessMessageText());
    }
}