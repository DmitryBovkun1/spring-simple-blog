package project.cucumber.steps;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;

public class RegistrationSteps {
    private final WebDriver driver = CommonSteps.getDriver();
    @Then("I should see {string} message for {string} field on page")
    public void checkErrorMessage(String errorMessage, String inputField) {
        WebElement errorElement = driver.findElement(By.xpath("//p[contains(@class, 'card-panel')][contains(@class, 'red')][contains(@class, 'darken-1')][contains(text(), '" + errorMessage + "')]"));
        assertTrue(errorElement.isDisplayed());
    }
}
