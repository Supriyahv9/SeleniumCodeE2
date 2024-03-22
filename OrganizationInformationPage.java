package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonUtils.WebDriverUtil;

public class OrganizationInformationPage {
	
	//Here driver is global
		public WebDriver driver;
	
	WebDriverUtil wutil = new WebDriverUtil();

	@FindBy(name="accountname")
	private WebElement organizationnametf;
	
	@FindBy(xpath="(//input[@name='assigntype'])[2]")
	private WebElement groupbtn;
	
	@FindBy(name="assigned_group_id")
	private WebElement dropdown;
	
	@FindBy(xpath="(//input[@name='button'])[1]")
	private WebElement savebtn;

	public WebElement getOrganizationnametf() {
		return organizationnametf;
	}

	public WebElement getGroupbtn() {
		return groupbtn;
	}

	public WebElement getDropdown() {
		return dropdown;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	//Create a constructor
	public OrganizationInformationPage(WebDriver driver) {
		//To initialize the webelement
		PageFactory.initElements(driver, this);
	}
	
	//Create a Method
	public HomePage OrganizationInformation(String orgname,String dropdownelement) {
		//Enter Intel in Organization name tf
		organizationnametf.sendKeys(orgname);
		//Click on group radio button
		groupbtn.click();
		//Handle dropdown and select support group
		wutil.handledropdown(dropdown, dropdownelement);
		//Click on save button
		savebtn.click();
		return new HomePage(driver);
	}
	
	
	
	
}
