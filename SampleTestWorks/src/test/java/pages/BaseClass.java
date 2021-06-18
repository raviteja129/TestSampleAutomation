package pages;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import utilities.BrowserUtilities;
import utilities.ConfigUtilities;
import utilities.ExcelUtilities;
import utilities.HelperUtilities;

import java.io.File;
import java.net.MalformedURLException;

public class BaseClass {
    public WebDriver driver;
    public ConfigUtilities configUtilities;
    public ExcelUtilities excelUtilities;
    ExtentHtmlReporter reporter;
    public ExtentReports extent;
    public ExtentTest extentTest;
    static Logger logger = LogManager.getLogger(BaseClass.class);

    @BeforeSuite
    public void setUpSuite() {
        configUtilities = new ConfigUtilities();
        excelUtilities = new ExcelUtilities();
        File reportDirPath = new File(System.getProperty("user.dir") + "/target/reports");
        if (!reportDirPath.exists()) {
            reportDirPath.mkdir();
            reporter = new ExtentHtmlReporter(new File(reportDirPath+ "/FreeLogin" + HelperUtilities.getDateTimeStamp() +".html"));
            reporter.config().setDocumentTitle("Orange HRM Automation Report");
            reporter.config().setReportName("Functional Report");
            reporter.config().setTheme(Theme.DARK);
        }
        else {
            reporter = new ExtentHtmlReporter(new File(reportDirPath+ "/FreeLogin" + HelperUtilities.getDateTimeStamp() +".html"));
            reporter.config().setDocumentTitle("Orange HRM Automation Report");
            reporter.config().setReportName("Functional Report");
            reporter.config().setTheme(Theme.DARK);
        }
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("AppURL", configUtilities.getURLConfig());
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("ExecutedBy", excelUtilities.getStringData("LoginData" ,0,0));
        extent.setSystemInfo("Browser", configUtilities.getBrowserConfig());

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

    @AfterMethod
    public void tearDownMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            HelperUtilities.captureScreenShot(driver);
            extentTest.log(Status.FAIL, "Testcase failed is " + result.getName());
            extentTest.log(Status.FAIL, "Testcase failed is " + result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SKIP) {
            HelperUtilities.captureScreenShot(driver);
            extentTest.log(Status.SKIP, "Testcase skipped is " + result.getName());
            extentTest.log(Status.SKIP, "Testcase skipped is " + result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS){
            HelperUtilities.captureScreenShot(driver);
            extentTest.log(Status.PASS,"Testcase passed is " + result.getName());
        }
        extent.flush();
    }
}
