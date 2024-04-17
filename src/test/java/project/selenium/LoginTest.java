package project.selenium;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import project.selenium.pages.HomePage;
import project.selenium.pages.LoginPage;

import static project.selenium.actions.ScreenshotAdd.takeScreenshot;

public class LoginTest {
  private WebDriver driver;
  private LoginPage loginPage;

  @Before
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", "/path-to-chromedriver/chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().setSize(new Dimension(1936, 1056));
    loginPage = new LoginPage(driver);
  }

  @After
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void loginUser() {
    HomePage homePage = loginPage.navigateToLoginPage().
            loginWithCredentials("test", "2203").
            withoutLogout().failedLoginWithCredentials();
    takeScreenshot(driver, "failedLogin");
    homePage.withoutLogout().loginWithCredentials("test", "2202");
    takeScreenshot(driver, "login");
    homePage.logout().logoutMessage();
    takeScreenshot(driver, "logout");
  }
}
