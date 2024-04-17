package project.selenium;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import project.selenium.pages.HomePage;
import project.selenium.pages.LoginPage;
import project.selenium.pages.PostPage;

import static project.selenium.actions.ScreenshotAdd.takeScreenshot;

public class PostAndCommentFunctionTest {
  private WebDriver driver;
  private LoginPage loginPage;

  @Before
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", "/path-to-chromedriver/chromedriver.exe");
    driver = new ChromeDriver();
    driver.get("http://localhost:8080/");
    driver.manage().window().setSize(new Dimension(757, 1020));
    loginPage = new LoginPage(driver);
  }

  @After
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void postAndCommentFunction() {
    HomePage homePage = loginPage.navigateToLoginPage()
            .loginWithCredentials("test", "2202");
    PostPage postPage = homePage.navigateToPostPage();
    takeScreenshot(driver, "postAddPageOpen");
    postPage.createPost("test", "testtesttesttesttest");
    postPage.openFirstPost();
    takeScreenshot(driver, "postOpen");
    postPage.addComment("test comment");
    takeScreenshot(driver, "addCommentPost");
    postPage.deletePost();
    homePage.logoutMobile();
  }
}
