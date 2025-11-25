package reactvite.localhost;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
// import org.openqa.selenium.edge.EdgeDriver;

public class LocalHost {
    private static String siteUrl = "http://localhost:5173/";
    public WebDriver getDriver() {
        System.out.println("Welcome to Selenium course 101.");
        // 1. Set the driver property

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-position=1920,-1000");
        options.addArguments("--window-size=1500,800");
        // options.addArguments("--headless");

        // 2. Initialize the browser
        WebDriver chromeDriver = new ChromeDriver(options);
        // WebDriver edgeDriver = new EdgeDriver();

        return chromeDriver;
    }
}
