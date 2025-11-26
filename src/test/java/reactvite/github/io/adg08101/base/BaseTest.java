package reactvite.github.io.adg08101.base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import reactvite.github.io.adg08101.utils.WebDriverFactory;

import java.io.File;
import java.io.IOException;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.createInstance();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws IOException {
        takeScreenshotProcedure("ss_teardown");
        driver.quit();
    }

    public void takeScreenshotProcedure(String name) throws IOException {
        try {
            takeScreenShotAction(name);
        } catch (UnhandledAlertException | IOException e) {
            try {
                driver.switchTo().alert().accept();
            } catch (Exception ignored) { }
            takeScreenShotAction(name);
        } catch (Exception e) {
            System.out.println("Screenshot failed: " + e.getMessage());
        }
    }

    public void takeScreenShotAction(String name) throws IOException {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenShotsPath = "./resources/screenshots/";

        FileUtils.copyFile(file, new File(screenShotsPath +
                name + System.currentTimeMillis() + ".png"));
    }
}
