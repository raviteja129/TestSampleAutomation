package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import utilities.ExcelUtilities;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AddUsersPage {
    static Logger logger = LogManager.getLogger(LoginPage.class);
    //ExcelUtilities excelUtilities;
    WebDriver driver;
    public AddUsersPage(WebDriver ldriver) {
        this.driver = ldriver;
    }

    @FindBy(how = How.XPATH, using = "//input[@id='btnAdd']")
    WebElement clickAddUsers;
    /*@FindAll({@FindBy(how=How.XPATH, using="//div[@id='tableWrapper']/table/tbody/tr/td/a")})
    WebElement findUsers;*/
    /*@FindBy(how= How.ID, using = "systemUser_employeeName_empName")
    WebElement employeeName;
    @FindBy(how= How.ID, using = "systemUser_userName")
    WebElement userName;
    @FindBy(how= How.ID, using = "systemUser_password")
    WebElement password;
    @FindBy(how= How.ID, using = "systemUser_password")
    WebElement confirmPassword;
    @FindBy(how= How.ID, using = "btnSave")
    WebElement saveButton;*/

    public void addusers() {
        //clickAddUsers.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        List<WebElement> listOfElements = driver.findElements(By.xpath("//div[@id='tableWrapper']/table/tbody/tr/td[2]/a"));
        for(WebElement names : listOfElements) {
            String adminName = names.getText();
            String actualUserValue = "Admin";
            if (adminName.equals(actualUserValue)) {
                Assert.assertEquals(actualUserValue, adminName);
                break;
            }

        }
        //System.out.println(findUsers.getText());
        /*excelUtilities = new ExcelUtilities();
        employeeName.sendKeys(excelUtilities.getStringData("AddUsers",1,0));
        logger.info("Employee Name entered");
        userName.sendKeys(excelUtilities.getStringData("AddUsers",1,1));
        logger.info("User Name entered");
        password.sendKeys(excelUtilities.getStringData("AddUsers",1,2));
        logger.info("Password entered");
        confirmPassword.sendKeys(excelUtilities.getStringData("AddUsers",1,3));
        logger.info("Confirm Password entered");
        saveButton.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);*/
    }
}