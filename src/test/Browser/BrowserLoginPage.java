import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrowserLoginPage {
    WebDriver driver;
    WebDriverWait wait;

    // Locators
    By mainContent = By.id("root");
    By homePage = By.id("page_wrapper");

    By productTextSection = By.className("login_logo");
    By homePageTextSection = By.className("page_wrapper");

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
        driver.findElement(usernameField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public void waitForHomePage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(homePage));
    }

    public boolean isHomePageTextPresent(String expectedText){
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(homePageTextSection, expectedText));
    }
}
