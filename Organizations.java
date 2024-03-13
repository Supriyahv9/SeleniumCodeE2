package Vtigercrm;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import CommonUtils.PropertyFileUtil;

public class Organizations {

	public static WebDriver driver;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//Object creation
		PropertyFileUtil putil = new PropertyFileUtil();
		
		//To read data from Property File
		String BROWSER = putil.getDataFromPropertyFile("Browser");
		String URL = putil.getDataFromPropertyFile("Url");
		String USERNAME = putil.getDataFromPropertyFile("Username");
		String PASSWORD = putil.getDataFromPropertyFile("Password");
	
		//To Launch the browser
				if(BROWSER.equals("Chrome")) {
					 driver = new ChromeDriver();
				}else if(BROWSER.equals("Edge")) {
					 driver = new EdgeDriver();
				}else {
					 driver = new FirefoxDriver();
				}
			
				//To maximize window
				driver.manage().window().maximize();
				
			//To apply implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
			//To launch application
			driver.get(URL);
			
			//Login to application
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			
	
	
	
	
	
	
	
	}

}
