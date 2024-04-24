package project.cucumber.steps;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;

public class LoginSteps {
    private final WebDriver driver = CommonSteps.getDriver();

    @When("I click Login button")
    public void clickButton() {
        WebElement loginButton = driver.findElement(By.cssSelector("input.btn.btn-primary[type='submit']"));
        loginButton.click();
    }

    @Then("I should be successfully logged in")
    public void verifySuccessfulLogin() {
        assertTrue(driver.getCurrentUrl().startsWith("http://localhost:8080/"));
        WebElement welcomeLink = driver.findElement(By.xpath("//a[contains(text(), 'Welcome')]"));
        assertTrue(welcomeLink.isDisplayed());
        WebElement logoutButton = driver.findElement(By.id("logout-mobile"));
        assertTrue(logoutButton.isDisplayed());
    }

    @Then("I should be redirected on the {string} page")
    public void verifyRedirectedToLoginPage(String page) {
        assertEquals("http://localhost:8080/" + page + "?error", driver.getCurrentUrl());
    }

    @Then("I should see {string} message as {string} on login page")
    public void verifyErrorMessage(String element, String message) {
        WebElement errorMessage = driver.findElement(By.xpath("//div[contains(text(), '" + message + "')]"));
        assertEquals(message, errorMessage.getText().trim());
    }
}

