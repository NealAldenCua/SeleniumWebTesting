import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Setup {
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

      browserPage.waitForMainContent();
      if (browserPage.isProductTextPresent("Swag Labs")) {
         System.out.println("Text is present in the login page.");
      } else {
         System.out.println("Text is not present.");
      }

      browserPage.fillSignupForm("standard_user", "secret_sauce");

      browserHomePage.waitForHomePage();
      if (browserPage.isHomePageTextPresent("Swag Labs")) {
         System.out.println("Text is present in the home page.");
      } else {
         System.out.println("Text is not present.");
      }
   }

//   @AfterMethod
//   public void teardown() {
//      if (driver != null) {
//         driver.quit();
//      }
//   }
}