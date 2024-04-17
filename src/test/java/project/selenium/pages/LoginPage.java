package project.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage navigateToLoginPage() {
        driver.get("http://localhost:8080/login");
        return this;
    }

    public HomePage loginWithCredentials(String username, String password) {
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys(username);

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(password);
        passwordField.submit();

        return new HomePage(driver);
    }

    public HomePage failedLoginWithCredentials() {
        driver.findElement(By.cssSelector(".card-panel")).click();
        return new HomePage(driver);
    }

    public HomePage logoutMessage() {
        driver.findElement(By.cssSelector(".alert")).click();
        return new HomePage(driver);
    }

    public HomePage navigateToHomePage() {
        driver.get("http://localhost:8080/");
        return new HomePage(driver);
    }
}
