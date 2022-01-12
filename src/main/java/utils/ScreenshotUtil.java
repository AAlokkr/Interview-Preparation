package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class ScreenshotUtil {

    public static String getTimeStamp() {
        return new Date().toString().replaceAll(":","_").replaceAll(" ", "_");
    }

    public static void getScreenshot(WebDriver driver) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("./Results/Screenshot/" +getTimeStamp()+".jpg");
        FileUtils.copyFile(srcFile, destFile);
    }
}
