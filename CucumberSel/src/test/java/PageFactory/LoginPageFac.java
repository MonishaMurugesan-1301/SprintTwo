package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;

public class LoginPageFac{
	WebDriver driver; 


@Given("user is on sauce page")
public void user_is_on_sauce_page() {
	System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver_win32\\chromedriver.exe");
    driver=new ChromeDriver();
    driver.get("http://www.saucedemo.com/");
}

@When("^he logins with (.*) and (.*)$")
public void he_logins_with_username_and_password(String username,String password) {
    driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(username);
    driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
    //driver.findElement(By.xpath("//input[@id='login-button']"));
}

@And("user clicks on login")
public void user_clicks_on_login() {
   driver.findElement(By.xpath("//input[@id='login-button']")).click();
   driver.close();
}

@Then("he should redirect to home page")
public void he_should_redirect_to_home_page() {
    System.out.println("success");
}
}
