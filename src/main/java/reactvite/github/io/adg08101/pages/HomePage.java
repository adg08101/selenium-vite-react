package reactvite.github.io.adg08101.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import reactvite.github.io.adg08101.pages.base.BasePage;

public class HomePage extends BasePage {

    private By someElement = By.className("nav-brand");  // adjust to actual element

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToHome() {
        openUrl("https://adg08101.github.io/react-vite/");
    }

    public boolean isSomeElementDisplayed() {
        return driver.findElement(someElement).isDisplayed();
    }
}
