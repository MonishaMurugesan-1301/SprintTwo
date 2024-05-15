//package Step_definition;
//
//import java.time.Duration;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.PageFactory;
//
//import Pages.Homepage;
//import io.cucumber.java.en.*;
//
//public class HomepageVerify {
//	//WebDriver driver;
//	WebDriver driver= new ChromeDriver();
//    Homepage in = PageFactory.initElements(driver, Homepage.class);
//	
//    @Given("User is on the home page")
//    public void user_is_on_the_home_page() {
//        System.setProperty("webdriver.chrome.driver","C:\\Users\\monimuru\\Desktop\\Path\\chromedriver-win64\\chromedriver.exe" );
//        //driver = new ChromeDriver();
//        driver.get("https://www.amazon.com");
//        driver.manage().window().maximize();
//    }
//
//
//    @When("User opens Today's deals")
//    public void user_opens_Today_s_deals()  {
//        in.enterdelivery();
//        in.enterDeals();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//    }
//
//
//    @And("go for Electronics")
//    public void go_for_Electronics() {
//        in.enterElectronics();
//
//    }
//    
//    @Then("User can able to see on the Electronics page")
//    public void user_can_able_to_see_on_the_electronics_page() {
//        System.out.println("Electronic products must be appeared");
//        
//    }
//}
package Step_definition;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import Pages.Homepage;
import io.cucumber.java.en.*;

public class HomepageVerify {
    WebDriver driver;
    Homepage in;

    // Use a constructor to initialize driver and in objects
    public HomepageVerify() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\monimuru\\Downloads\\ChPath\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        in = PageFactory.initElements(driver, Homepage.class);
    }

    @Given("User is on the home page")
    public void user_is_on_the_home_page() {
        driver.get("https://www.amazon.com");
        driver.manage().window().maximize();
    }

    @When("User opens Today's deals")
    public void user_opens_Today_s_deals() {
        in.enterdelivery();
        in.enterDeals();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @And("go for Electronics")
    public void go_for_Electronics() {
        in.enterElectronics();
    }

    @Then("User can able to see on the Electronics page")
    public void user_can_able_to_see_on_the_electronics_page() {
        System.out.println("Electronic products must be appeared");
    }
}

