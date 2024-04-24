package project.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CommonSteps {
    private static WebDriver driver;
    public static WebDriver getDriver() {
        return driver;
    }
    @Given("Driver initial")
    public void driverInit() {
        System.setProperty("webdriver.chrome.driver", "/path-to-chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1936, 1056));
    }

    @Given("I am a logged in user")
    public void iAmLoggedInUser() {
        driver.get("http://localhost:8080/login");
        driver.findElement(By.id("username")).sendKeys("test");
        driver.findElement(By.id("password")).sendKeys("2202");
        WebElement loginButton = driver.findElement(By.cssSelector("input.btn.btn-primary[type='submit']"));
        loginButton.click();
    }

    @Given("I navigate to the {string} page")
    public void navigateToPage(String page) {
        driver.get("http://localhost:8080/" + page);
    }

    @When("I fill in {string} with {string}")
    public void fillInField(String field, String value) {
        WebElement inputField = driver.findElement(By.name(field));
        inputField.clear();
        inputField.sendKeys(value);
    }

    @And("I press Enter")
    public void pressEnter() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
    }

    @Then("I close the browser")
    public void closeBrowser() {
        driver.quit();
    }
}
