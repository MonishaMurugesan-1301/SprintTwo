package step_definition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class LoginVerify {
	
	WebDriver driver;
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\monimuru\\Downloads\\chromedriver.exe" );
		driver=new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
	}

	@When("user enters Username and Password")
	public void user_enters_username_and_password() {
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");
        
        
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("secret_sauce");
        
	}

	@And("click on Login button")
	public void click_on_login_button() {
		driver.findElement(By.xpath("//input[@id='login-button']")).click();   
	}

	@Then("user should navigate to home page")
	public void user_should_navigate_to_home_page() {
		driver.findElement(By.xpath("//div[@id='']")).isDisplayed();
		driver.close();
	    
	}

}
