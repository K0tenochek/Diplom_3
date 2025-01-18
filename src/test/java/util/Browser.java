package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Browser {

    public static WebDriver getWebDriver() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/test/resources/browser.properties"));
        BrowserType browserType = BrowserType.valueOf(properties.getProperty("testBrowser"));
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        switch (browserType) {
            case CHROME:
                return new ChromeDriver(options);
            case YANDEX:
//                System.setProperty("webdriver.chrome.driver", "path/to/yandex/driver");
                return new ChromeDriver(options);
            default:
                throw new RuntimeException("Unsupported browser");
        }
    }

    public enum BrowserType {
        CHROME, YANDEX
    }
}
