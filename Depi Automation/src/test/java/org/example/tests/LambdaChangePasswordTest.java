package org.example.tests;

import org.example.BaseTest;
import org.example.pages.LoginPage;
import org.example.pages.MyAccountPage;
import org.testng.annotations.Test;

public class LambdaChangePasswordTest extends BaseTest {
    @Test
    public void changePassword(){
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/account");
        MyAccountPage myAccountPage = new MyAccountPage(driver);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("godzilla@gmail.com", "Haha_123");

        myAccountPage.changePassword("Haha_123","Haha_123");
        myAccountPage.verifyPasswordChangedSuccessfully();
    }
}
