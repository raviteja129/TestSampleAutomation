package testcases;

import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.BaseClass;
import pages.LoginPage;

public class LoginTest extends BaseClass {
    static Logger logger = LogManager.getLogger(LoginTest.class);

    @Test
    public void LoginApp() {
        extentTest = extent.createTest("LOGINPAGE");
        extentTest.log(Status.INFO, "Username and Password validation");
        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
        loginPage.loginToApplication(excelUtilities.getStringData("LoginData",0,0), excelUtilities.getStringData("LoginData",0,1));
        extentTest.log(Status.INFO, "Loggedin successfully");
        logger.info("LoginPage :: Successful");
    }
}
