package PageLayer;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import BaseLayer.BaseClass;
import UtilityLayer.Handledropdown;
import UtilityLayer.WaitClass;


public class ContactPage extends BaseClass{
	
	@FindBy(xpath="//Span[text()='Contacts']")
	private WebElement contacts;
	
	@FindBy(xpath="//button[text()='Create']")
	private WebElement create;
	
	@FindBy(name="first_name")
	private WebElement firstName;
	
	@FindBy(name="last_name")
	private WebElement LastName;
	
	@FindBy(name="middle_name")
	private WebElement middleName;
	
	@FindBy(name="status")
	private WebElement status;
	
	@FindBys(@FindBy (xpath="//div[@Class='visible menu transition']/child::div"))
	private List<WebElement> dropdown;
	
	@FindBy(name="category")
	private WebElement category;
	
	@FindBy(xpath="//button[text()='Save']")
	private WebElement saveButton;
	
	@FindBy(xpath="//button[@class='ui button icon']")
	private WebElement delete;
	
	@FindBy(xpath="//button[text()='Delete']")
	private WebElement delete1; 
	
	@FindBy(xpath="//span[text()='Log Out']")
	private WebElement logOut;
	
	
	public ContactPage() {
		PageFactory.initElements(getDriver(),this);
	}
	
	


public void clickoncontactstab() {
WaitClass.click(contacts);	
}

public void clickoncreatebutton() {
	WaitClass.click(create);
}



public void contactinformaton(String fName,String lName,String mName,String expectedStatus, String expectedCategory) {
WaitClass.SendKeys(firstName, fName);
WaitClass.SendKeys(LastName, lName);
WaitClass.SendKeys(middleName, mName);
Handledropdown.dropDownWithoutSelect(status, dropdown, expectedStatus);
Handledropdown.dropDownWithoutSelect(category, dropdown, expectedCategory);

}

public void clickonsavebutton() {
	WaitClass.click(saveButton);
}



public void deletethecreatedcontact() {
WaitClass.click(delete);
}

public void clickonprofileicon() {
	WaitClass.click(delete1);

}


public void clickonlogoutoption() {
WaitClass.click(logOut);
}

}