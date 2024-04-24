package project.cucumber.steps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;

public class LogoutSteps {
    private final WebDriver driver = CommonSteps.getDriver();

    @When("I click on {string} link")
    public void clickLogoutLink(String link) {
        WebElement logoutLink = driver.findElement(By.id(link));
        logoutLink.click();
    }

    @Then("I should be successfully logged out")
    public void verifySuccessfulLogout() {
        assertEquals("http://localhost:8080/login?logout", driver.getCurrentUrl());
    }

    @Then("I don't see {string} link")
    public void verifyLinkNotVisible(String linkText) {
        boolean isLinkVisible = !driver.findElements(By.linkText(linkText)).isEmpty();
        assert !isLinkVisible : "Logout link is still visible!";
    }
}
