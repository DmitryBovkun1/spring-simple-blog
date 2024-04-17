package project.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;

public class EditProfilePage {
    private WebDriver driver;

    public EditProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public void changePassword(String newPassword) {
        driver.findElement(By.cssSelector(".btn-floating > .material-icons")).click();
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.clear();
        passwordField.sendKeys(newPassword);
        passwordField.sendKeys(Keys.ENTER);
    }

    public LoginPage logout() {
        driver.findElement(By.id("logout-mobile")).click();
        return new LoginPage(driver);
    }
}
