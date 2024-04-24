package project.cucumber.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.*;

public class ForgotPasswordSteps {
    private final WebDriver driver = CommonSteps.getDriver();

    @When("I click on the {string} input button")
    public void clickButton(String button) {
        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit' and @value='" + button + "']"));
        submitButton.click();
    }

    @Then("I should land on the {string} page")
    public void verifyPage(String page) {
        assertTrue(driver.getCurrentUrl().contains(page.toLowerCase()));
    }

    @Then("I should see forget password {string} status message as {string}")
    public void verifyMessage(String status, String expectedMessage) {
        WebElement message = driver.findElement(By.xpath("//div[@class='alert alert-" + status + "']/p"));
        String actualMessage = message.getText();
        assertEquals(expectedMessage, actualMessage);
    }
}
