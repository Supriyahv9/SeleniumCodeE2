package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonUtils.WebDriverUtil;

public class HomePage {
	
	public WebDriver driver;
	
	WebDriverUtil wutil = new WebDriverUtil();
	

	@FindBy(xpath="(//a[text()='Organizations'])[1]")
	private WebElement organizations;
	
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement contacts;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement image;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signoutbtn;

	public WebElement getOrganizations() {
		return organizations;
	}

	public WebElement getContacts() {
		return contacts;
	}

	public WebElement getImage() {
		return image;
	}

	public WebElement getSignoutbtn() {
		return signoutbtn;
	}
	
	//Create a Constructor
	public HomePage(WebDriver driver) {
		//To initialize the webelement
	PageFactory.initElements(driver, this);	
	}
	
	//Create a Method
	public OrganizationsPage Home() {
		//Click on Organizations
		organizations.click();
		return new OrganizationsPage(driver);
	}
	
	//Create a Method
	public LoginPage Home(WebDriver driver) {
		//mouse hover on image
		wutil.mousehover(driver, image);
		//Click on signout button
		signoutbtn.click();
		return new LoginPage(driver);
	}
	
	
	
	
	
	
	
}
