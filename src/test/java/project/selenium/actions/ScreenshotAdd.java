package project.selenium.actions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class ScreenshotAdd {
    public static void takeScreenshot(WebDriver driver, String filename) {
        if (driver instanceof TakesScreenshot) {
            TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
            File screenshot = screenshotDriver.getScreenshotAs(OutputType.FILE);
            File screenshotsDir = new File("screenshots");
            if (!screenshotsDir.exists()) {
                screenshotsDir.mkdirs();
            }

            try {
                FileHandler.copy(screenshot, new File(screenshotsDir, filename + ".png"));
                System.out.println("Screenshot taken: " + filename);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Driver does not support taking screenshots");
        }
    }
}