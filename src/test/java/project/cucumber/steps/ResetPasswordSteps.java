package project.cucumber.steps;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;

public class ResetPasswordSteps {
    private final WebDriver driver = CommonSteps.getDriver();
    @Then("Invalid or expired reset token message is displayed")
    public void verifyInvalidOrExpiredTokenMessage() {
        WebElement errorMessage = driver.findElement(By.xpath("//div[@class='status-container']//p[contains(text(), 'Invalid or expired reset token.')]"));
        assertTrue("Invalid or expired reset token message is not displayed", errorMessage.isDisplayed());
    }
}
