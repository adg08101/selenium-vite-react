package reactvite.github.io.adg08101.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import reactvite.github.io.adg08101.pages.base.BasePage;

import java.util.List;
import java.util.Random;

public class LoginPage extends BasePage {

    private final By userInput = By.name("user");
    private final By emailInput = By.name("email");
    private final By passwordInput = By.name("password");
    private final By loginButton = By.cssSelector("button[type='submit']");
    private final By errorMessage = By.cssSelector(".error-message");
    private final By formLink = By.xpath("//*[text()='Form']");
    private final By errorSelector = By.className("error");
    private final By countrySelect = By.name("country");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openAndNavigate() {
        openUrl("https://adg08101.github.io/react-vite");
        navigate(formLink);
    }

    public void enterUser(String user) {
        driver.findElement(userInput).clear();
        driver.findElement(userInput).sendKeys(user);
    }
    public void enterEmail(String email) {
        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void selectRandomCountry() {
        WebElement selectElement = driver.findElement(countrySelect);
        Select countrySelect = new Select(selectElement);

        List<WebElement> options = countrySelect.getOptions();
        int randomIndex = new Random().nextInt(0, options.size() - 1);

        options.get(randomIndex).click();
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public String getErrorMessageText() {
        return driver.findElement(errorMessage).getText();
    }

    public List<WebElement> getErrors() {
        return driver.findElements(errorSelector);
    }
}
