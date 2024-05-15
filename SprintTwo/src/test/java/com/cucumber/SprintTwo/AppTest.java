package com.cucumber.SprintTwo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppTest {
	
    public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver","C:\\Users\\monimuru\\Desktop\\Path\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver=new ChromeDriver();
        // TODO Auto-generated method stub

         driver.get("https://www.google.com/");
         driver.manage().window().maximize();
         driver.get("https://www.saucedemo.com/");

    }
    
}
