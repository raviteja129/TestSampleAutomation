package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class HomePage {
    static Logger logger = LogManager.getLogger(LoginPage.class);
    WebDriver driver;
    public HomePage(WebDriver ldriver) {
        this.driver = ldriver;
    }

    @FindBy(how= How.XPATH, using = "//a[@id='menu_admin_viewAdminModule']")
    WebElement hoverAdmin;
    @FindBy(how= How.XPATH, using = "//a[@id='menu_admin_UserManagement'][contains(text(),'User Management')]")
    WebElement hoverUserManagement;
    @FindBy(how= How.XPATH, using = "//a[@id='menu_admin_viewSystemUsers'][contains(text(),'Users')]")
    WebElement clickUsers;
    @FindBy(how=How.XPATH, using = "//div[@id='systemUser-information']/div/h1[contains(text(),'System Users')]")
    WebElement validateSystemUsers;



    public void homePageValidation() {
        String actualTitle = driver.getTitle();
        String extectedTitle = "OrangeHRM";
        Assert.assertEquals(actualTitle, extectedTitle);
        logger.info("Assertion for page title passed");
        Actions builder = new Actions(driver);
        Action mouseHoverAdmin = builder.moveToElement(hoverAdmin).build();
        mouseHoverAdmin.perform();
        logger.info("WebElement moved to Admin");
        Action mouseHoverUserManagement = builder.moveToElement(hoverUserManagement).build();
        mouseHoverUserManagement.perform();
        logger.info("WebElement moved to User Management");
        clickUsers.click();
        String actualValue = validateSystemUsers.getText();
        String expectedValue = "System Users";
        Assert.assertEquals(actualValue, expectedValue);
        logger.info("Assertion passed for System users");
    }
}
