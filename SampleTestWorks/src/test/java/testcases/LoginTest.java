package testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.AddUsersPage;
import pages.BaseClass;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseClass {
    static Logger logger = LogManager.getLogger(LoginTest.class);

    @Test
    public void LoginApp() {
        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
        loginPage.loginToApplication(excelUtilities.getStringData("LoginData",0,0), excelUtilities.getStringData("LoginData",0,1));
        logger.info("LoginPage :: Successful");
    }
}
