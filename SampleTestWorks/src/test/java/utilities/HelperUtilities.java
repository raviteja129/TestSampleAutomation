package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HelperUtilities {
    public static void captureScreenShot(WebDriver driver) {
        File scrShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File scrDirPath = new File(System.getProperty("user.dir") + "/target/screenShot");
        try {
            if (scrDirPath.exists()) {
                FileHandler.copy(scrShot, new File(scrDirPath + "/Orange-HRM" + getDateTimeStamp() + ".png"));
            } else {
                scrDirPath.mkdir();
                FileHandler.copy(scrShot, new File(scrDirPath + "/Orange-HRM" + getDateTimeStamp() + ".png"));
            }
        } catch (Exception e) {
            System.out.println("Unable to capture screenshot and store in " + scrDirPath + " location " + e.getMessage());
        }
    }

    public static String getDateTimeStamp() {
        DateFormat custFormat = new SimpleDateFormat("YYYY-MM-dd_hh_mm_ss");
        Date currDate = new Date();
        return custFormat.format(currDate);
    }
}
