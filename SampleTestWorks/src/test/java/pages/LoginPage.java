package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class LoginPage {
    static Logger logger = LogManager.getLogger(LoginPage.class);
    WebDriver driver;
    public LoginPage(WebDriver ldriver) {
        this.driver = ldriver;
    }

    @FindBy(how= How.ID, using = "txtUsername")
    WebElement userName;
    @FindBy(how= How.NAME, using = "txtPassword")
    WebElement password;
    @FindBy(how= How.ID, using = "btnLogin")
    WebElement loginButton;

    public void loginToApplication(String uname, String upass) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        userName.sendKeys(uname);
        password.sendKeys(upass);
        loginButton.click();
        logger.info("Button clicked");
    }
}
