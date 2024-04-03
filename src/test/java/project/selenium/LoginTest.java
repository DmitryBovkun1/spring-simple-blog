package project.selenium;

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
import org.springframework.beans.factory.annotation.Value;

import java.util.*;

public class LoginTest {
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
  public void login() {
    driver.get("http://localhost:8080/");
    driver.manage().window().setSize(new Dimension(1936, 1056));
    {
      WebElement element = driver.findElement(By.linkText("Login"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    driver.findElement(By.linkText("Login")).click();
    driver.findElement(By.id("username")).click();
    driver.findElement(By.id("username")).sendKeys("test");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("2203");
    driver.findElement(By.id("password")).sendKeys(Keys.ENTER);
    driver.findElement(By.cssSelector(".card-panel")).click();
    driver.findElement(By.cssSelector(".card-panel")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".card-panel"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    driver.findElement(By.cssSelector(".card-panel")).click();
    driver.findElement(By.id("username")).click();
    driver.findElement(By.id("username")).sendKeys("test");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("2202");
    driver.findElement(By.id("password")).sendKeys(Keys.ENTER);
    driver.findElement(By.id("logout-mobile")).click();
    driver.findElement(By.cssSelector(".alert")).click();
    driver.findElement(By.cssSelector(".alert")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".alert"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    driver.findElement(By.cssSelector(".alert")).click();
    driver.findElement(By.cssSelector(".container:nth-child(3)")).click();
    driver.close();
  }
}
