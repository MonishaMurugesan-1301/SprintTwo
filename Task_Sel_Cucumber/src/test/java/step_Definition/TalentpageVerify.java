package step_Definition;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TalentpageVerify {
	
	WebDriver driver = new ChromeDriver();
//	JavascriptExecutor js = (JavascriptExecutor) driver;

	 // Method to navigate to the homepage
	@Given("the user is on the Talentpage")
	public void the_user_is_on_the_homepage() {
		
		driver.get("https://talent.capgemini.com/in/");
		driver.manage().window().maximize();
	    }
	
	@When("user selects the Toolkit option")
	public void user_selects_the_toolkit_option() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement global = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='tab-global']/descendant::a")));
		global.click();
	}

	@When("the user should see seven different options")
	public void the_user_should_see_seven_different_options() {
		driver.findElement(By.xpath("//div[@id='sub-nav-wrapper']/nav/ul/li[4]")).click();
		
	}

	@Then("user can select Ask Adam virtual Assistant")
	public void user_can_select_ask_adam_virtual_assistant() {
		driver.findElement(By.xpath("//div[@id='6625570C-DE0B-0B90-4EED-7A7093558863']/span/a")).click();
	
		// Handle window switching
        String Parent_w = driver.getWindowHandle();
        Set <String> set = driver.getWindowHandles();
        Iterator <String> I = set.iterator();
        while(I.hasNext()){
            String Child_w = I.next();
            if(!(Parent_w.equals(Child_w))) {
                driver.switchTo().window(Child_w);
            }
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement line = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='about_head_slab']/h1")));		
		String title = line.getText();
		System.out.println("Heading : " +title);
		
		WebElement search = driver.findElement(By.xpath("//input[@class='srch_btn']"));
		search.click();
		WebElement srchinpt = driver.findElement(By.xpath("(//input[@placeholder='Search for service or support'])[2]"));
		srchinpt.sendKeys("pingId");
		
		driver.findElement(By.className("country_go")).click();
		
		 WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
	        WebElement line2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-sm-12 showing']")));		
			String title2 = line2.getText();
			System.out.println("PingId : " +title2);
		driver.quit();
		
	}

}
