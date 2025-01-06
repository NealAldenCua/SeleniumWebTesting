import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BrowserHomePage {
    WebDriver driver;
    WebDriverWait wait;

    // Locators
    By homePage = By.id("page_wrapper");
    By homePageTextSection = By.className("page_wrapper");
    By authSection = By.xpath("//*[@id=\"header_container\"]/div[2]/span");
    By SauceBackpackItem = By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]");
    By SauceBikeLight = By.xpath("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]");
    By Cart = By.xpath("//*[@id=\"shopping_cart_container\"]/a");

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

    public void addToCartItems(){
        wait.until(ExpectedConditions.presenceOfElementLocated(authSection));
        WebElement sauceBackPackItemElement = driver.findElement(SauceBackpackItem);
        WebElement sauceBikeLightElement = driver.findElement(SauceBikeLight);
        WebElement cartElement = driver.findElement(Cart);

        //delay for inputs
        Actions actions = new Actions(driver);

        //first item and second item
        actions.click(sauceBackPackItemElement).pause(Duration.ofMillis(700)).perform();
        actions.click(sauceBikeLightElement).pause(Duration.ofMillis(700)).perform();

        //cart
        actions.click(cartElement).pause(Duration.ofMillis(700)).perform();
    }
}
