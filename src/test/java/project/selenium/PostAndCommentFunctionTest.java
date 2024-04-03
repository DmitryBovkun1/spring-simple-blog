package project.selenium;

import com.project.BlogApp;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import java.util.*;

public class PostAndCommentFunctionTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", "/path-to-chromedriver/chromedriver.exe");
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void postandcommentfunction() {
    driver.get("http://localhost:8080/");
    driver.manage().window().setSize(new Dimension(757, 1020));
    driver.findElement(By.cssSelector(".button-collapse > .material-icons")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".button-collapse > .material-icons"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    driver.findElement(By.linkText("Login")).click();
    driver.findElement(By.id("username")).click();
    driver.findElement(By.id("username")).sendKeys("test");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("2202");
    driver.findElement(By.id("password")).sendKeys(Keys.ENTER);
    driver.findElement(By.cssSelector(".button-collapse > .material-icons")).click();
    driver.findElement(By.linkText("Create a post")).click();
    driver.findElement(By.id("title")).click();
    driver.findElement(By.id("title")).click();
    driver.findElement(By.id("title")).click();
    {
      WebElement element = driver.findElement(By.id("title"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    driver.findElement(By.id("title")).sendKeys("test");
    driver.findElement(By.id("body")).click();
    driver.findElement(By.id("body")).sendKeys("testtesttesttesttest");
    {
      WebElement element = driver.findElement(By.cssSelector(".select-dropdown:nth-child(2)"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).clickAndHold().perform();
    }
    {
      WebElement element = driver.findElement(By.cssSelector(".disabled > span"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).release().perform();
    }
    driver.findElement(By.cssSelector(".select-wrapper")).click();
    driver.findElement(By.cssSelector(".select-dropdown:nth-child(2)")).click();
    driver.findElement(By.cssSelector("li:nth-child(2) > span")).click();
    driver.findElement(By.cssSelector("li:nth-child(4) > span")).click();
    driver.findElement(By.cssSelector("li:nth-child(5) > span")).click();
    driver.findElement(By.cssSelector(".form-wrap")).click();
    driver.findElement(By.id("create-btn")).click();
    driver.findElement(By.cssSelector(".card:nth-child(1) .material-icons")).click();
    driver.findElement(By.id("newComment")).click();
    driver.findElement(By.id("newComment")).sendKeys("test comment");
    driver.findElement(By.cssSelector(".input-field > .waves-effect")).click();
    driver.findElement(By.cssSelector(".collection-item > p")).click();
    driver.findElement(By.cssSelector(".collection-item > p")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".collection-item > p"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    driver.findElement(By.cssSelector(".collection-item > p")).click();
    driver.findElement(By.cssSelector(".container:nth-child(3) > .row")).click();
    driver.findElement(By.cssSelector(".deep-orange > .material-icons")).click();
    driver.findElement(By.cssSelector(".button-collapse > .material-icons")).click();
    driver.close();
  }
}
