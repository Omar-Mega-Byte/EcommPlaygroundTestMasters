package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LambdaLoginTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");

        driver.manage().window().setSize(new Dimension(430, 932));

        System.out.println("Login Page URL --> " + driver.getCurrentUrl());
        System.out.println("Login Page Title --> " + driver.getTitle());

        driver.findElement(By.id("input-email")).sendKeys("godzilla@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("Haha_123");
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        System.out.println("After login URL --> " + driver.getCurrentUrl());

        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/logout");

        driver.findElement(By.xpath("//*[contains(text(),'Continue')]")).click();


        System.out.println("After logout URL --> " + driver.getCurrentUrl());

        driver.quit();
    }
}
