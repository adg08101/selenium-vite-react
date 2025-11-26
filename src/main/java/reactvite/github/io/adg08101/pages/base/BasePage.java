package reactvite.github.io.adg08101.pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
    private final WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openUrl(String url) {
        driver.get(url);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public void navigate(By by) {
        WebElement element = driver.findElement(by);
        element.click();
    }

    public WebDriverWait getWait() {
        return wait;
    }
}
