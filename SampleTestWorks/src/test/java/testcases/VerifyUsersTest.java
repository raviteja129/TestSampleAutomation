package testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.AddUsersPage;
import pages.BaseClass;
import pages.HomePage;
import pages.LoginPage;

public class VerifyUsersTest extends BaseClass {
    static Logger logger = LogManager.getLogger(LoginTest.class);

    @Test
    public void verifyUsers() {
        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
        loginPage.loginToApplication(excelUtilities.getStringData("LoginData",0,0), excelUtilities.getStringData("LoginData",0,1));
        logger.info("LoginPage :: Successful");
        HomePage homePage = PageFactory.initElements(driver,HomePage.class);
        homePage.homePageValidation();
        logger.info("Home Page :: validation completed");
        AddUsersPage addUsersPage = PageFactory.initElements(driver, AddUsersPage.class);
        addUsersPage.addusers();
        logger.info("AddUserPage :: User Verified successfully");
    }
}
