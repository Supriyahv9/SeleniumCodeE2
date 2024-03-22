package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	
	//Here driver is global
		public WebDriver driver;
	
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createorganization;

	public WebElement getCreateorganization() {
		return createorganization;
	}
	
	//Create a Constructor
	public OrganizationsPage(WebDriver driver) {
		//To initialize the webelement
	PageFactory.initElements(driver, this);
	}
	
	//Create a Method
	public OrganizationInformationPage Organizations() {
		//Click on Create Organization..(+)
		createorganization.click();
		return new OrganizationInformationPage(driver);
	}
	
	
	
	
}
