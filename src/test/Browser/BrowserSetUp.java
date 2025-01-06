import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserSetUp {
   WebDriver driver;
   String baseURL;

   @BeforeMethod
   public void setUp() {
      driver = new ChromeDriver();
      baseURL = "https://www.saucedemo.com/";
      driver.manage().window().maximize();
      driver.get(baseURL);
   }

   @Test
   public void steps() {
      BrowserLoginPage browserPage = new BrowserLoginPage(driver);
      BrowserHomePage browserHomePage = new BrowserHomePage(driver);
      BrowserCart browserCartPage = new BrowserCart(driver);
      BrowserCheckOutPage browserCheckOutPage = new BrowserCheckOutPage(driver);

      //for login
      browserPage.waitForMainContent();
      if (browserPage.isProductTextPresent("Swag Labs")) {
         System.out.println("Text is present in the login page.");
      } else {
         System.out.println("Text is not present.");
      }
      browserPage.fillSignupForm("standard_user", "secret_sauce");

      //for homepage
      browserHomePage.waitForHomePage();
      if (browserHomePage.isHomePageTextPresent("Swag Labs")) {
         System.out.println("Text is present in the home page.");
      } else {
         System.out.println("Text is not present.");
      }
      browserHomePage.addToCartItems();

      //for cart
      browserCartPage.waitForCartPage();
      if (browserCartPage.isCartPageTextPresent("Your Cart")) {
         System.out.println("Text is present in the cart page.");
      } else {
         System.out.println("Text is not present.");
      }
      browserCartPage.cartCheckOut();

      //for checkout
      browserCheckOutPage.waitForCheckOutPage();
      if (browserCheckOutPage.isCheckOutPageTextPresent("Checkout: Your Information")) {
         System.out.println("Text is present in the check out page.");
      } else {
         System.out.println("Text is not present.");
      }
      browserCheckOutPage.inputInformation("Fernando", "Alonso", "420");
      browserCheckOutPage.checkout();
   }

   @AfterMethod
   public void teardown() {
      if (driver != null) {
         driver.quit();
      }
   }
}