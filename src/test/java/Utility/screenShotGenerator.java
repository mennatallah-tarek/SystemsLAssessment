package Utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class screenShotGenerator {
        public static String takeScreenshot(WebDriver driver, String screenshotName) {
            String filePath = System.getProperty("Desktop/Assessment/GoogleSearch/screenshots") + "/screenshots/" + "count Mismatch" + ".png";
            try {
                File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                File destFile = new File(filePath);



                FileUtils.copyFile(srcFile, destFile);
                System.out.println("Screenshot saved at: " + filePath); // Debugging step
                Thread.sleep(1000);

            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
            return filePath;
        }
    }

