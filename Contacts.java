package Vtigercrm;

import java.io.IOException;
import java.util.Set;

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

public class Contacts {
	
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
	String FIRSTNAME = eutil.getDataFromExcelFile("Contacts", 0, 1);
	String LASTNAME = eutil.getDataFromExcelFile("Contacts", 1, 1);
	String GROUP = eutil.getDataFromExcelFile("Contacts", 2, 1);
				
				
				
	
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
			
			//Click on Contacts
			driver.findElement(By.xpath("//a[text()='Contacts']")).click();
	
			//Click on Create Contact..(+)
			driver.findElement(By.cssSelector("img[alt='Create Contact...']")).click();
			
			//Enter Firstname
			driver.findElement(By.name("firstname")).sendKeys(FIRSTNAME);
	
			//Enter Lastname
			driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
			
			//Click on Group radio button
			driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
			
			//Select team selling in the drop down
			WebElement dropdown = driver.findElement(By.name("assigned_group_id"));
			wutil.handledropdown(dropdown, GROUP);
	
			//Click on + in Organization name
			driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
			
			//To transfer the control from Parent window to child window
			wutil.switchwindow(driver, "http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=");
			
			//Enter Organization name in search tf
			driver.findElement(By.id("search_txt")).sendKeys("Intel");
			
			//Click on Search now button
			driver.findElement(By.name("search")).click();
			
			//Click on Organization name
			driver.findElement(By.xpath("//a[text()='Intel']")).click();
			
			//To transfer the control from child window to Parent window
			wutil.switchwindow(driver, "http://localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing");
			
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
