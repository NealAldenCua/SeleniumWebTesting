import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BrowserCheckOutPage {
    WebDriver driver;
    WebDriverWait wait;

    // Locators
    By checkOutPage = By.className("app_logo");
    By checkOutTextSection = By.className("header_secondary_container");
    By authSection = By.xpath("//*[@id=\"header_container\"]/div[2]/span");
    By firstName = By.xpath("//*[@id=\"first-name\"]");
    By lastName = By.xpath("//*[@id=\"last-name\"]");
    By postalCode = By.xpath("//*[@id=\"postal-code\"]");
    By continueCheckOut = By.xpath("//*[@id=\"continue\"]");
    By finishCheckOut = By.xpath("//*[@id=\"finish\"]");

    // Constructor
    public BrowserCheckOutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitForCheckOutPage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(checkOutPage));
    }

    public boolean isCheckOutPageTextPresent(String expectedText){
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(checkOutTextSection, expectedText));
    }

    public void inputInformation(String firstname, String lastname, String postalcode){
        wait.until(ExpectedConditions.presenceOfElementLocated(authSection));
        WebElement firstNameElement = driver.findElement(firstName);
        WebElement lastNameElement = driver.findElement(lastName);
        WebElement postalCodeElement = driver.findElement(postalCode);

        //delay for inputs
        Actions actions = new Actions(driver);

        //firstname
        actions.sendKeys(firstNameElement, firstname).pause(Duration.ofMillis(700)).perform();

        //lastname
        actions.sendKeys(lastNameElement, lastname).pause(Duration.ofMillis(700)).perform();

        //postal
        actions.sendKeys(postalCodeElement, postalcode).pause(Duration.ofMillis(700)).perform();
    }

    public void checkout(){
        //delay for inputs
        Actions actions = new Actions(driver);

        //checkout
        WebElement continueCheckoutElement = driver.findElement(continueCheckOut);
        actions.click(continueCheckoutElement).pause(Duration.ofMillis(700)).perform();

        //scroll
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");

        //finish
        WebElement finishCheckOutElement = driver.findElement(finishCheckOut);
        actions.click(finishCheckOutElement).pause(Duration.ofMillis(1000)).perform();
    }
}
