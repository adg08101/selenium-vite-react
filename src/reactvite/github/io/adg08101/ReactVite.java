package reactvite.github.io.adg08101;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import reactvite.localhost.LocalHost;

public class ReactVite {
    private static String siteUrl = "https://adg08101.github.io/react-vite/";
    public static void main(String[] args) {
        LocalHost local = new LocalHost();
        WebDriver chromeDriver = local.getDriver();

        // 3. Open google.com
        chromeDriver.get(siteUrl);
        // edgeDriver.get(siteUrl);

        Utilities.tryForWait(1000);

        // (optional) Maximize window
        chromeDriver.manage().window().fullscreen();
        Utilities.tryForWait(1500);

        chromeDriver.manage().window().maximize();
        Utilities.tryForWait(1500);

        Dimension dimension = new Dimension(600, 350);
        chromeDriver.manage().window().setSize(dimension);

        Utilities.tryForWait(1500);

        chromeDriver.manage().window().minimize();
        // edgeDriver.manage().window().maximize();
        Utilities.tryForWait(500);

        chromeDriver.manage().window().fullscreen();
        Utilities.tryForWait(500);

        Utilities.tryForWait(500);

        String title = chromeDriver.getTitle();

        System.out.println(title);

        chromeDriver.quit(); // closes all windows and ends session
        // edgeDriver.quit();
        }
    }

