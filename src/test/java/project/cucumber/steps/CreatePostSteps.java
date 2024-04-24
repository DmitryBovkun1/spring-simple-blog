package project.cucumber.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertNotNull;

public class CreatePostSteps {
    private final WebDriver driver = CommonSteps.getDriver();
    @When("I click on {string} link on the main menu")
    public void clickMainMenuLink(String linkText) {
        WebElement link = driver.findElement(By.linkText(linkText));
        link.click();
    }

    @When("I fill textarea in {string} with {string}")
    public void fillTextarea(String fieldName, String value) {
        WebElement textarea = driver.findElement(By.id(fieldName));
        textarea.clear();
        textarea.sendKeys(value);
    }

    @When("I choose posts options in {string} with {string}")
    public void selectOptionsInTags(String dropdownId, String tags) {
        WebElement dropdownInput = driver.findElement(By.xpath("//select[@id='" + dropdownId + "']/preceding-sibling::input[contains(@value, 'Choose your option')]"));
        dropdownInput.click();

        String[] tagArray = tags.split(",");
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("ul.dropdown-content li"));

        for (String tag : tagArray) {
            String trimmedTag = tag.trim();
            checkboxes.stream()
                    .filter(element -> element.getText().trim().equalsIgnoreCase(trimmedTag))
                    .findFirst()
                    .ifPresent(WebElement::click);
        }
        WebElement footerCopyright = driver.findElement(By.className("footer-copyright"));
        footerCopyright.click();
    }

    @Then("I should see the new blog title {string} listing on the post page")
    public void checkPostExist(String title){
        WebElement firstElementWithTitle = driver.findElement(By.xpath("//span[@class='card-title blue-grey darken-3'][contains(text(),'" + title + "')][1]"));
        assertNotNull(firstElementWithTitle);
    }
}
