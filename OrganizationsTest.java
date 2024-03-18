package Vtigercrm;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import CommonUtils.BaseClass;
import CommonUtils.ExcelUtil;
import CommonUtils.JavaUtil;
import CommonUtils.WebDriverUtil;

public class OrganizationsTest extends BaseClass {
	
	WebDriverUtil wutil = new WebDriverUtil();
	JavaUtil jutil = new JavaUtil();
	ExcelUtil eutil = new ExcelUtil();
	
	
	@Test
	public void CreateOrganizationsTest() throws EncryptedDocumentException, IOException {
		
		//To read data from Excel File
	String ORGNAME = eutil.getDataFromExcelFile("Organizations", 0, 1);
	String GROUP = eutil.getDataFromExcelFile("Organizations", 1, 1);
		
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
		
		
		
		
	}

}
