package Vtigercrm;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import CommonUtils.BaseClass;
import CommonUtils.ExcelUtil;
import CommonUtils.JavaUtil;
import CommonUtils.ListenerImplementation;
import CommonUtils.PropertyFileUtil;
import CommonUtils.WebDriverUtil;
@Listeners(ListenerImplementation.class)
public class OrganizationsTest extends BaseClass {

	PropertyFileUtil putil = new PropertyFileUtil();
	WebDriverUtil wutil = new WebDriverUtil();
	ExcelUtil eutil = new ExcelUtil();
	JavaUtil jutil = new JavaUtil();
	
	@Test
	public void CreateOrganizationTest() throws IOException, InterruptedException {
		
	//To read data from Excel File
	String ORGNAME = eutil.getDataFromExcelFile("Organizations", 0, 1);
	String GROUP = eutil.getDataFromExcelFile("Organizations", 1, 1);
	
	//Click on Organization
	driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
	
	//Click on Create Organization..(+)
	driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();
	
	//wutil.Screenshot(driver);
	
	//Enter Organization Name
	driver.findElement(By.name("accountname")).sendKeys(ORGNAME+jutil.getRandomNumber());
	
	//To fail the testscript we are using asserts
	String actualurl = driver.getCurrentUrl();
	String expectedurl = "http://localhost:8888/pune/index.php?module=Accounts&action=EditView&return_action=DetailView&parenttab=Marketing";
	Assert.assertEquals(actualurl, expectedurl);
	
	
	
	//In AssignedTo Click on Group
	driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
	
	//In the dropdown select Support group
	WebElement dropdown = driver.findElement(By.name("assigned_group_id"));
	wutil.handledropdown(dropdown, GROUP);
	
	//Click on Save Button
	driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
	
	
	
	
}
}
