package Dropdown.Task1;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class part1 {

       public static void main(String[] args) {
                String excelFilePath = "C:\\Users\\monimuru\\Downloads\\Data.xlsx";

                System.setProperty("webdriver.chrome.driver", "C:\\Users\\monimuru\\Downloads\\ChPath\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
                WebDriver driver = new ChromeDriver();

                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

                driver.get("http://sampleapp.tricentis.com/101/index.php");
                driver.manage().window().maximize();

                try {
                    WebElement automobileLink = driver.findElement(By.linkText("Automobile"));
                    automobileLink.click();

                    Workbook workbook = new XSSFWorkbook(excelFilePath);
                    Sheet sheet = workbook.getSheetAt(0);
                    for (Row row : sheet) {
                        if (row.getRowNum() == 0) continue;
                        String vehicleModel = row.getCell(0).getStringCellValue();

                        WebElement makeDropdown = driver.findElement(By.id("make"));
                        Select select = new Select(makeDropdown);

                        boolean isPresent = false;
                        for (WebElement option : select.getOptions()) {
                            if (option.getText().equals(vehicleModel)) {
                                isPresent = true;
                                break;
                            }
                        }
                        if (isPresent) {
                            System.out.println("Vehicle model '" + vehicleModel + "' is present in the dropdown list.");
                        } else {
                            System.out.println("Vehicle model '" + vehicleModel + "' is not present in the dropdown list.");
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    driver.quit();
                }
            }
        }
