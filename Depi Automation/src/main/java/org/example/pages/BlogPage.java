package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BlogPage {
    WebDriver driver;
    WebDriverWait wait;

    public BlogPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    private final By article = By.xpath("//*[@id=\"mz-article-tab-76210960-0\"]/div/div/div[1]/div/div[1]/a");
    private final By commentTextArea = By.xpath("//*[@id=\"input-comment\"]");
    private final By postCommentBtn = By.xpath("//*[@id=\"button-comment\"]");

    public void accessArticle(){
        wait.until(ExpectedConditions.elementToBeClickable(article)).click();
    }

    public void typeAComment(String msg){
        driver.findElement(commentTextArea).clear();
        driver.findElement(commentTextArea).sendKeys(msg);
        wait.until(ExpectedConditions.elementToBeClickable(postCommentBtn)).click();
    }
}
