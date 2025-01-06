import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrowserLoginPage {
    WebDriver driver;
    WebDriverWait wait;

    // Locators
    By mainContent = By.id("root");
    By productTextSection = By.className("login_logo");

    By authSection = By.id("login_credentials");
    By usernameField = By.xpath("//*[@id=\"user-name\"]");
    By passwordField = By.xpath("//*[@id=\"password\"]");
    By loginButton = By.xpath("//*[@id=\"login-button\"]");

    // Constructor
    public BrowserLoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Methods for actions
    public void waitForMainContent() {
        wait.until(ExpectedConditions.presenceOfElementLocated(mainContent));
    }

    public boolean isProductTextPresent(String expectedText) {
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(productTextSection, expectedText));
    }

    public void fillSignupForm(String email, String password) {
        wait.until(ExpectedConditions.presenceOfElementLocated(authSection));
        WebElement usernameElement = driver.findElement(usernameField);
        WebElement passwordElement = driver.findElement(passwordField);
        WebElement loginElement = driver.findElement(loginButton);

        //delay for inputs
        Actions actions = new Actions(driver);

        //username
        actions.sendKeys(usernameElement, email).pause(Duration.ofMillis(700)).perform();

        //password
        actions.sendKeys(passwordElement, password).pause(Duration.ofMillis(700)).perform();

        //click login
        actions.click(loginElement).perform();
    }
}
