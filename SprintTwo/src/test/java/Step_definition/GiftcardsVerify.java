package Step_definition;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import Pages.Giftcards;
import io.cucumber.java.en.*;

public class GiftcardsVerify {
	
	WebDriver driver= new ChromeDriver();
    Giftcards in = PageFactory.initElements(driver, Giftcards.class);

    
@Given("User is on the Amazon homepage")
public void user_is_on_the_amazon_homepage() {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\monimuru\\Desktop\\Path\\chromedriver-win64\\chromedriver.exe" );

    driver.get("https://www.amazon.com");
    driver.manage().window().maximize();
    
    in.enterdelivery();
}


@When("User click on Gift Cards")
public void user_click_on_gift_cards() throws IOException {
	in.enterGiftcards();
	
	TakesScreenshot ts = (TakesScreenshot)driver;
    File file = ts.getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(file,new File("./Screenshots/image1.1.png"));
}
//@When("Go for Valentine's Day catagory")
//public void go_for_valentine_s_day_catagory() {
//	in.enterValentinesDay();   
//}
//
//@Then("User can go for Love For Kids")
//public void user_can_go_for_love_for_kids() {
//	in.enterLoveForKids();
//	

@And("Go for Specialty Gift Cards")
public void go_for_speciality_gift_cards() {
	in.enterSpecialtyGiftCards();
}

@Then("User can go for SEPHORA")
public void user_can_go_for_sephora() {
	in.enterSEPHORA();
}

}
