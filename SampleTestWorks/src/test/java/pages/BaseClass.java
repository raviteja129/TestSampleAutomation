package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import utilities.BrowserUtilities;
import utilities.ConfigUtilities;
import utilities.ExcelUtilities;

import java.net.MalformedURLException;

public class BaseClass {
    public WebDriver driver;
    public ConfigUtilities configUtilities;
    public ExcelUtilities excelUtilities;
    static Logger logger = LogManager.getLogger(BaseClass.class);

    @BeforeSuite
    public void setUpSuite() {
        configUtilities = new ConfigUtilities();
        excelUtilities = new ExcelUtilities();
    }

    @BeforeClass
    public void setUp() throws MalformedURLException {
        driver = BrowserUtilities.startApp(configUtilities.getExecution(), configUtilities.getBrowserConfig(),configUtilities.getURLConfig());
        logger.trace("Trace Message");
        logger.info("Start of the Application");
    }

    @AfterClass
    public void closeAll() {
        BrowserUtilities.closeBrowser(driver);
    }
}
