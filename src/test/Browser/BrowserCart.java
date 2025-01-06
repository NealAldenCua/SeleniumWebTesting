import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BrowserCart {
    WebDriver driver;
    WebDriverWait wait;

    //locators
    By cartPage = By.xpath("//*[@id=\"header_container\"]/div[2]/span");
    By cartPageTextSection = By.className("header_secondary_container");
    By authSection = By.xpath("//*[@id=\"header_container\"]/div[2]/span");
    By CartCheckOut = By.xpath("//*[@id=\"checkout\"]");

    // Constructor
    public BrowserCart(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitForCartPage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(cartPage));
    }

    public boolean isCartPageTextPresent(String expectedText){
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(cartPageTextSection, expectedText));
    }

    public void cartCheckOut(){
        wait.until(ExpectedConditions.presenceOfElementLocated(authSection));
        WebElement cartElement = driver.findElement(CartCheckOut);

        //delay for inputs
        Actions actions = new Actions(driver);

        //cart
        actions.click(cartElement).pause(Duration.ofMillis(700)).perform();
    }
}
