package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrganizationInformationPage {

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
}
