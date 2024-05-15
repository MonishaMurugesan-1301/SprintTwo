package step_Definition;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class HomepageVerify {
	
	WebDriver driver = new ChromeDriver();
	JavascriptExecutor js = (JavascriptExecutor) driver;

	 // Method to navigate to the homepage
	@Given("the user is on the homepage")
	public void the_user_is_on_the_homepage() {
		
		driver.get("https://www.oyorooms.com/");
		driver.manage().window().maximize();
	    }

	 // Method to select a city
	@When("user selects the city")
	public void user_selects_the_city() {
		driver.findElement(By.xpath("//a[@href='/hotels-in-chennai/']")).click();
	   	}
	// Method to verify available hotels
	@When("the user should see available hotels")
	public void the_user_should_see_available_hotels() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ListingContentHeader__heading']/span/h1")));	
		String text = heading.getText();
		System.out.println("Title : " +text);  
	}

	// Method to provide input for booking a hotel
	@When("the user gives the input for booking hotel")
	public void the_user_gives_the_input() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement Date = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oyo-cell headerSticky__rightHeader']/div[1]/div[2]/div/div")));	
		Date.click();
        Thread.sleep(2000);
        
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));      
        WebElement date1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='DateRangePicker']/div[3]/table/tbody/tr[3]/td[5]")));
        date1.click();  
        driver.findElement(By.xpath("//div[@class='DateRangePicker']/div[3]/table/tbody/tr[3]/td[6]")).click();
	
        WebElement rooms = driver.findElement(By.xpath("//div[@class='oyo-cell headerSticky__rightHeader']/div[1]/div[3]/div/div"));
		rooms.click();
	    Thread.sleep(2000);
	       
	    driver.findElement(By.xpath("//span[@class='guestRoomPickerPopUp__plus']")).click();
	    Thread.sleep(2000);
	        
	    driver.findElement(By.xpath("//button[@class='guestRoomPickerPopUp__addRoom']")).click();
	    Thread.sleep(2000);
	        
	    driver.findElement(By.xpath("(//span[@class='guestRoomPickerPopUp__plus'])[2]")).click();
	    Thread.sleep(2000);
	    
	    WebElement searchbtn = driver.findElement(By.xpath("//button[@class='u-textCenter searchButton searchButton--header']"));
		searchbtn.click();
        Thread.sleep(2000);
        
        WebElement sort = driver.findElement(By.xpath("//span[@class='dropdown__select']"));
        sort.click();
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("//ul[@class='dropdown__list']/li[4]")).click();
        Thread.sleep(2000); 
	   
	}

	// Method to verify the user can book a hotel
	@Then("user can book a hotel")
	public void user_can_book_a_hotel() throws InterruptedException {
		
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 400)");
		Thread.sleep(2000);
		WebElement hotel = driver.findElement(By.xpath("//h3[text()='Palette - The Slate Hotel']"));
		hotel.click();
		
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
    
        js.executeScript("window.scrollBy(0, 2500)");
        
        WebElement contbtn = driver.findElement(By.xpath("//button[@class='c-u65gu2']"));
        contbtn.click();
        Thread.sleep(2000);
        
		js.executeScript("window.scrollBy(0, 600)");
		WebElement payment = driver.findElement(By.xpath("//div[@class='c-18axi1k'][6]"));
		String amount = payment.getText();
		System.out.println(amount);	
		
		driver.quit();
	}
}