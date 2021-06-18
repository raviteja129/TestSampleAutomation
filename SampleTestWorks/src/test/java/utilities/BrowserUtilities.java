package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BrowserUtilities {
    public static WebDriver startApp(String executionType, String browserName, String appURL) throws MalformedURLException {
        WebDriver driver = null;

        if(executionType.contains("local") || executionType.contains("LOCAL") ) {
            if (browserName.contains("Chrome") || browserName.contains("CHROME")  || browserName.contains("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            else if (browserName.contains("firefox") || browserName.contains("FIREFOX")  || browserName.contains("Firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            else {
                System.out.println("Check the drivers availability to initiate the browser");
            }
            driver.manage().window().maximize();
            driver.get(appURL);
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            return driver;
        }
        else {
            if (browserName.contains("CHROME") || browserName.contains("Chrome") || browserName.contains("chrome")) {
                DesiredCapabilities cap = new DesiredCapabilities();
                cap.setBrowserName(BrowserType.CHROME);
                driver = new RemoteWebDriver(new URL("http://localhost:4545/wd/hub"), cap);
            } else if (browserName.contains("FIREFOX") || browserName.contains("Firefox") || browserName.contains("firefox")) {
                DesiredCapabilities cap = new DesiredCapabilities();
                cap.setBrowserName(BrowserType.CHROME);
                driver = new RemoteWebDriver(new URL("http://localhost:4545/wd/hub"), cap);
            } else {
                System.out.println("Check the drivers availability to initiate the browser");
            }
            driver.manage().window().maximize();
            driver.get(appURL);
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            return driver;
        }
    }

    public static void closeBrowser(WebDriver driver) {
        driver.quit();
    }
}
