import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BrowserHomePage {
    WebDriver driver;
    WebDriverWait wait;

    // Locators
    By homePage = By.id("page_wrapper");
    By homePageTextSection = By.className("page_wrapper");

    // Constructor
    public BrowserHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitForHomePage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(homePage));
    }

    public boolean isHomePageTextPresent(String expectedText){
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(homePageTextSection, expectedText));
    }
}
