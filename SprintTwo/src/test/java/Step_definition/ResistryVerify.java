package Step_definition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import Pages.Registry;
import io.cucumber.java.en.*;

public class ResistryVerify {
	WebDriver driver= new ChromeDriver();
	Registry in=PageFactory.initElements(driver,Registry.class);
	
	@Given("User is on the home pagee")
	public void user_is_on_the_home_pagee() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\monimuru\\Desktop\\Path\\chromedriver-win\\chromedriver.exe" );

        driver.get("https://www.amazon.com");
        driver.manage().window().maximize();
        
        in.enterdelivery();
    }

	@When("User click on Registry")
	public void user_click_on_registry() {
		in.enterRegistry();
	    }

	@And("Go for Registrant name and gift list type")
	public void go_for_registrant_name_and_gift_list_type() {
		in.enterRegistrantname();
		
		in.entergiftlisttype(); 
		List <WebElement> allElements= driver.findElements(By.xpath("//span[@class='a-dropdown-prompt']"));
        System.out.println(allElements.size());
    String price="Gift List";
            for(int i=0;i<allElements.size();i++){
            if(price.equals(allElements.get(i).getText())){
                allElements.get(i).click();

 

            break;
            }
    driver.findElement(By.xpath("//a[@id=\"gr-find-stripe__occasion_1\"]")).click();
            }
    }
	
	@Then("User can go for search")
	public void user_can_go_for_search() {
		in.enterSearch();
	}


}
