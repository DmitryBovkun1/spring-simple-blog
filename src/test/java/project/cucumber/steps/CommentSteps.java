package project.cucumber.steps;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;

public class CommentSteps {
    private final WebDriver driver = CommonSteps.getDriver();
    @When("I click on the {string} button")
    public void clickButton(String button) {
        WebElement addButton = driver.findElement(By.xpath("//button[contains(text(), '" + button + "')]"));
        addButton.click();
    }
    @Then("I should see the comment {string} added to the blog")
    public void verifyCommentAdded(String message) {
        WebElement commentElement = driver.findElement(By.xpath("//li[contains(@class, 'collection-item') and .//*[contains(text(), '" + message + "')]]"));
        assertTrue(commentElement.isDisplayed());
    }
}
