package InterviewPrep;

import InterviewPrep.Pages.Login;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestClass extends BaseClass {

    private WebDriver driver;

    @BeforeTest
    public void invokeBrowser() throws IOException {
        readProperties();
        driver = getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test(dataProvider = "getData")
    public void testOne(String username, String password) throws IOException {
        openURL(driver);
        Login login = new Login(driver);
        login.doLogin(username, password);
        login.verifyLogin();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        return ExcelUtils.getExcelData(getTestDataLocation());
    }


}
