package project.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PostPage {
    private WebDriver driver;

    public PostPage(WebDriver driver) {
        this.driver = driver;
    }

    public void createPost(String title, String body) {
        driver.findElement(By.id("title")).sendKeys(title);
        driver.findElement(By.id("body")).sendKeys(body);
        driver.findElement(By.cssSelector(".select-wrapper")).click();
        driver.findElement(By.cssSelector("li:nth-child(2) > span")).click();
        driver.findElement(By.cssSelector("li:nth-child(4) > span")).click();
        driver.findElement(By.cssSelector("li:nth-child(5) > span")).click();
        driver.findElement(By.cssSelector(".form-wrap")).click();
        driver.findElement(By.id("create-btn")).click();
    }

    public void openFirstPost() {
        driver.findElement(By.cssSelector(".card:nth-child(1) .material-icons")).click();
    }

    public void addComment(String comment) {
        driver.findElement(By.id("newComment")).sendKeys(comment);
        driver.findElement(By.cssSelector(".input-field > .waves-effect")).click();
    }

    public void deletePost() {
        driver.findElement(By.cssSelector(".deep-orange > .material-icons")).click();
    }
}
