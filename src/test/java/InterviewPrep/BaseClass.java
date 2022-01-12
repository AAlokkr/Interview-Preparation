package InterviewPrep;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {

    private static String url;
    private static String testDataLocation;
    private static String driverLocation;

    public static WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", driverLocation + "chromedriver.exe");
        return new ChromeDriver();
    }

    public static void openURL(WebDriver driver) {
        driver.get(url);
    }

    public static void readProperties() throws IOException {
        FileReader fileReader = new FileReader("config.properties");
        Properties properties = new Properties();
        properties.load(fileReader);
        url = properties.getProperty("url");
        testDataLocation = properties.getProperty("testdatalocation");
        driverLocation = properties.getProperty("driverlocation");
    }

    public static String getTestDataLocation() {
        return testDataLocation;
    }
}
