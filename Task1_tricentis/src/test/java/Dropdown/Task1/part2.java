package Dropdown.Task1;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class part2 {
	
	 public static void main(String[] args) throws InterruptedException, IOException {
         
		 WebDriver driver = new ChromeDriver();
         System.setProperty("webdriver.chrome.driver","C:\\Users\\monimuru\\Desktop\\Path\\chromedriver-win64\\chromedriver.exe");
         

         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

         driver.get("http://sampleapp.tricentis.com/101/index.php");
         driver.manage().window().maximize();
         
         
         WebElement automobileLink = driver.findElement(By.linkText("Automobile"));
         automobileLink.click();
         
                  
         Select drpMake = new Select(driver.findElement(By.name("Make")));
         drpMake.selectByIndex(2);
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
         
         WebElement enginePerformance = driver.findElement(By.cssSelector("input#engineperformance"));
         enginePerformance.sendKeys("75");
         Thread.sleep(2000);
         
         WebElement dateCalender = driver.findElement(By.xpath("//button[@name='Open Date of Manufacture Calender']"));
         dateCalender.click();
         Thread.sleep(2000);
         
         driver.findElement(By.xpath("//a[contains(text(),'1')]")).click();
         Thread.sleep(2000);
         
         Select Seat = new Select(driver.findElement(By.id("numberofseats")));
         Seat.selectByIndex(7);
         Thread.sleep(2000);
         
         Select drpFuel = new Select(driver.findElement(By.xpath("//select[@name='Fuel Type']")));
         drpFuel.selectByVisibleText("Petrol");
         
         driver.findElement(By.id("listprice")).sendKeys("52255");
         Thread.sleep(2000);
         
         driver.findElement(By.id("licenseplatenumber")).sendKeys("TN28N5555");
         Thread.sleep(2000);
         
         driver.findElement(By.id("annualmileage")).sendKeys("13500");
         Thread.sleep(2000);
         
         driver.findElement(By.xpath("//button[@name ='Next (Enter Insurant Data)']")).click();
         Thread.sleep(2000);
         
         FileInputStream fis = new FileInputStream("C:\\Users\\monimuru\\Downloads\\Data1.xlsx");         
         XSSFWorkbook workbook = new XSSFWorkbook(fis);         
         Sheet sheet = workbook.getSheetAt(2);
         
         Row insurantDataRow = sheet.getRow(2); 
         
         WebElement firstName = driver.findElement(By.id("firstname"));   
         firstName.sendKeys(insurantDataRow.getCell(0).getStringCellValue());
         
         WebElement lastName = driver.findElement(By.id("lastname"));        
         lastName.sendKeys(insurantDataRow.getCell(1).getStringCellValue());  
         
         WebElement Dob = driver.findElement(By.xpath("//input[@name='Date of Birth']"));
         Dob.sendKeys(insurantDataRow.getCell(2).getStringCellValue());
         Thread.sleep(2000);
         
         WebElement radio1= driver.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[2]/div[4]/p/label[1]"));
         WebElement radio2= driver.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[2]/div[4]/p/label[2]"));
         radio1.click();
         Thread.sleep(2000);
                 
         WebElement streetaddress = driver.findElement(By.id("streetaddress"));        
         streetaddress.sendKeys(insurantDataRow.getCell(4).getStringCellValue());
         
         WebElement country = driver.findElement(By.id("country"));        
         country.sendKeys(insurantDataRow.getCell(5).getStringCellValue());  
         
         WebElement zipcode = driver.findElement(By.id("zipcode"));        
         zipcode.sendKeys(insurantDataRow.getCell(6).getStringCellValue());   
         
         WebElement city = driver.findElement(By.id("city"));        
         city.sendKeys(insurantDataRow.getCell(7).getStringCellValue());  
         
         WebElement occupation = driver.findElement(By.id("occupation"));        
         occupation.sendKeys(insurantDataRow.getCell(8).getStringCellValue());
         
         JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript("window.scrollBy(0,250)");
         Thread.sleep(2000);
         WebElement check = driver.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[2]/div[10]/p/label[2]"));
         check.click();
         Thread.sleep(2000);
         
        
         
         driver.findElement(By.xpath("//button[@name ='Next (Enter Product Data)']")).click();
         Thread.sleep(2000);
       
         Sheet sheet1 = workbook.getSheetAt(3);
         
         Row productDataRow = sheet1.getRow(2); 

         driver.findElement(By.xpath("//input[@id='startdate']")).sendKeys(productDataRow.getCell(0).getStringCellValue());
         
         WebElement InsuranceSum = driver.findElement(By.xpath("//select[@id='insurancesum']"));
         InsuranceSum.sendKeys(productDataRow.getCell(1).getStringCellValue());
         Thread.sleep(2000);
         
         WebElement MeritRating = driver.findElement(By.id("meritrating"));
         MeritRating.sendKeys(productDataRow.getCell(2).getStringCellValue());
         Thread.sleep(2000);
         
         WebElement DamageInsurance = driver.findElement(By.name("Damage Insurance"));
         DamageInsurance.sendKeys(productDataRow.getCell(3).getStringCellValue());
         Thread.sleep(2000);
         
         WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[3]/div[5]/p/label[2]"));
         checkbox.click();
         Thread.sleep(2000);
         
         WebElement CourtesyCar = driver.findElement(By.xpath("//select[@id='courtesycar']"));
         CourtesyCar.sendKeys(productDataRow.getCell(5).getStringCellValue());
         Thread.sleep(2000);

         driver.findElement(By.xpath("//button[@id='nextselectpriceoption']")).click();
	     
         //Selecting price option
         WebElement Price = driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tfoot/tr/th[2]/label[4]"));
         Price.click();
         Thread.sleep(2000);
         
         WebElement Quote = driver.findElement(By.xpath("//*[@id=\"viewquote\"]"));
         Quote.click();
         Thread.sleep(2000);

         driver.findElement(By.id("nextsendquote")).click();
         
       //Entering Quote Details
         Sheet sheet2 = workbook.getSheetAt(4);
         Row SendQuoteRow = sheet2.getRow(2);
         
         WebElement Email = driver.findElement(By.name("E-Mail"));
         Email.sendKeys(SendQuoteRow.getCell(0).getStringCellValue());
         Thread.sleep(2000);
         
         WebElement Phone = driver.findElement(By.id("phone"));
         Phone.sendKeys(SendQuoteRow.getCell(1).getStringCellValue());
         Thread.sleep(2000);
         
         WebElement UserName = driver.findElement(By.id("username"));
         UserName.sendKeys(SendQuoteRow.getCell(2).getStringCellValue());
         Thread.sleep(2000);
         
         WebElement Password = driver.findElement(By.xpath("//input[@id='password']"));
         Password.sendKeys(SendQuoteRow.getCell(3).getStringCellValue());
         Thread.sleep(2000);
         
         WebElement confPass = driver.findElement(By.xpath("//input[@id='confirmpassword']"));
         confPass.sendKeys(SendQuoteRow.getCell(4).getStringCellValue());
         Thread.sleep(2000);
         
         WebElement Comments = driver.findElement(By.id("Comments"));
         Comments.sendKeys(SendQuoteRow.getCell(5).getStringCellValue());
         
         driver.findElement(By.xpath("//*[@id=\"sendemail\"]")).click();
         Thread.sleep(2000);
         
       }

}

