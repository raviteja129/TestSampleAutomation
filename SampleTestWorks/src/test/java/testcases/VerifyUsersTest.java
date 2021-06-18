package testcases;

import com.aventstack.extentreports.Status;
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
        extentTest = extent.createTest("LOGINPAGE");
        extentTest.log(Status.INFO, "Username and Password validation");
        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
        loginPage.loginToApplication(excelUtilities.getStringData("LoginData",0,0), excelUtilities.getStringData("LoginData",0,1));
        extentTest.log(Status.INFO, "Loggedin successfully");
        logger.info("LoginPage :: Successful");

        extentTest = extent.createTest("HOMEPAGE");
        extentTest.log(Status.INFO, "HomePage Validation");
        HomePage homePage = PageFactory.initElements(driver,HomePage.class);
        homePage.homePageValidation();
        extentTest.log(Status.INFO, "HomePage Validation completed");
        logger.info("Home Page :: validation completed");

        extentTest = extent.createTest("USERSPAGE");
        extentTest.log(Status.INFO, "UsersPage Validation");
        AddUsersPage addUsersPage = PageFactory.initElements(driver, AddUsersPage.class);
        addUsersPage.addusers();
        extentTest.log(Status.INFO, "User Verified successfully");
        logger.info("AddUserPage :: User Verified successfully");
    }
}
