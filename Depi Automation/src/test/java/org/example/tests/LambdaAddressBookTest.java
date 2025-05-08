package org.example.tests;

import org.example.BaseTest;
import org.example.pages.AddressBookPage;
import org.example.pages.LoginPage;
import org.testng.annotations.Test;

public class LambdaAddressBookTest extends BaseTest {
    @Test
    public void addressBookTest() {
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/address");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("godzilla@gmail.com", "Haha_123");

        AddressBookPage addressBookPage = new AddressBookPage(driver);
        addressBookPage.addNewAddress(
                "Omar", "Ahmed", "HelwanSoft", "123 Nile St", "Floor 2",
                "Cairo", "11435", "Egypt", "1008"
        );
        addressBookPage.verifyAddressAddedSuccessfully();
    }
}