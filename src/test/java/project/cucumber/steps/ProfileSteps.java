package project.cucumber.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.*;

public class ProfileSteps {
    private final WebDriver driver = CommonSteps.getDriver();
    @Then("I should see {string} heading on the Profile page")
    public void verifyProfileHeading(String expectedHeading) {
        WebElement profileHeading = driver.findElement(By.xpath("//h4[text()='" + expectedHeading + "']"));
        assertNotNull(profileHeading);
    }

    @Then("Profile \"username\" field should be prepopulated on the Profile page")
    public void verifyUsernameFieldIsPrepopulated() {
        WebElement usernameField = driver.findElement(By.xpath("//li[@class='collection-item avatar']/p[contains(text(),'Username')]/span[@class='title']"));
        String username = usernameField.getText().trim();
        assertFalse(username.isEmpty());
    }

    @Then("Profile \"username\" field should be contain {string}")
    public void checkUsernameField(String expectedUsername) {
        WebElement usernameField = driver.findElement(By.xpath("//li[@class='collection-item avatar']/p[contains(text(),'Username')]/span[@class='title']"));
        String actualUsername = usernameField.getText();
        assertEquals(expectedUsername, actualUsername);
    }

    @Then("Profile \"email\" field should be prepopulated on the Profile page")
    public void verifyEmailFieldIsPrepopulated() {
        WebElement emailField = driver.findElement(By.xpath("//li[@class='collection-item avatar']/p[contains(text(),'Email')]/span"));
        String email = emailField.getText().trim();
        assertFalse(email.isEmpty());
    }

    @Then("Profile \"email\" field should be contain {string}")
    public void checkEmailField(String expectedEmail) {
        WebElement emailField = driver.findElement(By.xpath("//li[@class='collection-item avatar']/p[contains(text(),'Email')]/span"));
        String actualEmail = emailField.getText();
        assertEquals(expectedEmail, actualEmail);
    }

    @When("I click on the edit profile link")
    public void clickEditProfileLink() {
        WebElement editProfileLink = driver.findElement(By.cssSelector("a.btn.btn-floating.right"));
        editProfileLink.click();
    }
}
