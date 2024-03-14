package Vtigercrm;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import CommonUtils.ExcelUtil;
import CommonUtils.JavaUtil;
import CommonUtils.PropertyFileUtil;
import CommonUtils.WebDriverUtil;

public class Organization {
	public static WebDriver driver;
	
	
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
			//Object creation
			PropertyFileUtil putil = new PropertyFileUtil();
			JavaUtil jutil = new JavaUtil();
			ExcelUtil eutil = new ExcelUtil();
			WebDriverUtil wutil = new WebDriverUtil();
			
			
			//To read data from Property File
			String BROWSER = putil.getDataFromPropertyFile("Browser");
			String URL = putil.getDataFromPropertyFile("Url");
			String USERNAME = putil.getDataFromPropertyFile("Username");
			String PASSWORD = putil.getDataFromPropertyFile("Password");
		
			//To read data from Excel File
			String ORGNAME = eutil.getDataFromExcelFile("Organizations", 0, 1);
			String GROUP = eutil.getDataFromExcelFile("Organizations", 1, 1);
			
			//To Launch the browser
					if(BROWSER.equals("Chrome")) {
						 driver = new ChromeDriver();
					}else if(BROWSER.equals("Edge")) {
						 driver = new EdgeDriver();
					}else {
						 driver = new FirefoxDriver();
					}
				
					//To maximize window
					wutil.maximize(driver);
					
				//To apply implicit wait
			wutil.implicitwait(driver);
					
				//To launch application
				driver.get(URL);
				
				//Login to application
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
				
				
				//Click on Organizations
				driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
				
				//Click on Create Organization..(+)
				driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();
				
				//Enter Organization name
				driver.findElement(By.name("accountname")).sendKeys(ORGNAME+jutil.getRandomNumber());
				
				//Click on group radio button
			driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
				
				//Select support group in the dropdown
				WebElement dropdown = driver.findElement(By.name("assigned_group_id"));
				
				wutil.handledropdown(dropdown, GROUP);
				
				//Click on Save button
				driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
				
				Thread.sleep(2000);
				
				//Mouse hover on image
				WebElement image = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
				wutil.mousehover(driver, image);
				
				//Click on signout
				driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	
	
	}

}

