package project.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public PostPage navigateToPostPage() {
        driver.findElement(By.cssSelector(".button-collapse > .material-icons")).click();
        driver.findElement(By.linkText("Create a post")).click();
        return new PostPage(driver);
    }

    public EditProfilePage navigateToEditProfile() {
        driver.findElement(By.cssSelector("#nav-mobile .waves-effect > .navbar-text")).click();
        return new EditProfilePage(driver);
    }

    public LoginPage logout() {
        driver.findElement(By.id("logout-mobile")).click();
        return new LoginPage(driver);
    }
    public LoginPage logoutMobile() {
        driver.findElement(By.cssSelector(".button-collapse > .material-icons")).click();
        return new LoginPage(driver);
    }
    public LoginPage withoutLogout() {
        return new LoginPage(driver);
    }
}
