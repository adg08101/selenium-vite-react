package reactvite.github.io.adg08101.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import reactvite.github.io.adg08101.enums.BrowserType;

public class WebDriverFactory {

    public static WebDriver createInstance() {

        String browser = ConfigReader.get("browser").toLowerCase();

        BrowserType browserType = BrowserType.valueOf(browser.toUpperCase());

        switch (browserType) {

            case CHROME:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();

                if (ConfigReader.get("headless").equalsIgnoreCase("true")) {
                    chromeOptions.addArguments("--headless=new");
                }

                chromeOptions.addArguments("--remote-allow-origins=*");
                chromeOptions.addArguments("--start-maximized");
                return new ChromeDriver(chromeOptions);

            case EDGE:
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();

                if (ConfigReader.get("headless").equalsIgnoreCase("true")) {
                    edgeOptions.addArguments("--headless=new");
                }

                return new EdgeDriver(edgeOptions);

            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions ffOptions = new FirefoxOptions();

                if (ConfigReader.get("headless").equalsIgnoreCase("true")) {
                    ffOptions.addArguments("--headless");
                }

                return new FirefoxDriver(ffOptions);

            default:
                throw new RuntimeException("Invalid browser type: " + browser);
        }
    }
}