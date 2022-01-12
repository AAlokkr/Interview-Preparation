package InterviewPrep.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;

import static utils.ScreenshotUtil.getScreenshot;


public class Login {

    private WebDriver driver;
    private final By txtUsername = By.id("email");
    private final By txtPassword = By.id("pass");
    private final By btnLogin = By.name("login");
    private final By errorMessage = By.xpath("//*[@id='email_container']/div[2]");

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void doLogin(String username, String password) {
        driver.findElement(txtUsername).sendKeys(username);
        driver.findElement(txtPassword).sendKeys(password);
        driver.findElement(btnLogin).click();
        System.out.println("Entered Details and clicked on login");
    }

    public void verifyLogin() throws IOException {
        boolean flag;
        WebDriverWait wait;
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));

        if (driver.findElement(errorMessage).isDisplayed()) {
            flag = true;
            getScreenshot(driver);
        }
        else
            flag = false;

        Assert.assertTrue(flag);
    }

}
