package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LambdaRegisterTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/register");
        driver.manage().window().setSize(new Dimension(430, 932));

        System.out.println("Register Page URL --> " + driver.getCurrentUrl());
        System.out.println("Register Page Title --> " + driver.getTitle());

        driver.findElement(By.id("input-firstname")).sendKeys("Omar");
        driver.findElement(By.id("input-lastname")).sendKeys("Mohamed");
        driver.findElement(By.id("input-email")).sendKeys("omar" + System.currentTimeMillis() + "@example.com"); // Unique email
        driver.findElement(By.id("input-telephone")).sendKeys("+201234567890");

        driver.findElement(By.id("input-password")).sendKeys("Password123");
        driver.findElement(By.id("input-confirm")).sendKeys("Password123");

        driver.findElement(By.cssSelector("label[for='input-newsletter-yes']")).click();

        driver.findElement(By.cssSelector("label[for='input-agree']")).click();

        driver.findElement(By.cssSelector("input[type='submit'][value='Continue']")).click();

        System.out.println("Page title after registration: " + driver.getTitle());
        System.out.println("Page URL after registration: " + driver.getCurrentUrl());
        driver.quit();
    }
}
