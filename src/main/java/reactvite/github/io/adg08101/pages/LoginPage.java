package reactvite.github.io.adg08101.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginPage extends BasePage {

    private By userInput = By.name("user");
    private By emailInput = By.name("email");
    private By passwordInput = By.name("password");
    private By loginButton = By.cssSelector("button[type='submit']");
    private By errorMessage = By.cssSelector(".error-message");
    private By formLink = By.xpath("//*[text()='Form']");
    private By errorSelector = By.className("error");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        openUrl("https://adg08101.github.io/react-vite");
    }

    public void navigate() {
        WebElement link = driver.findElement(formLink);
        link.click();
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
