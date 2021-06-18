package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigUtilities {
    public File file;
    public FileInputStream fis;
    public static Properties Repository = new Properties();

    public ConfigUtilities () {
        file = new File(System.getProperty("user.dir") + "/src/test/resources/config.properties");
        try {
            fis = new FileInputStream(file);
            Repository.load(fis);
        } catch (Exception e) {
            System.out.println("This path" + file + " does not have the configuration file" + e.getMessage());
        }
    }

    public String getBrowserConfig() {
        return Repository.getProperty("browser");
    }

    public String getURLConfig() {
        return Repository.getProperty("QA_url");
    }

    public String getExecution() {
        return Repository.getProperty("execution");
    }
}
