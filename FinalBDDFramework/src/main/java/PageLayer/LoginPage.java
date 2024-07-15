package PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseLayer.BaseClass;
import UtilityLayer.WaitClass;

public class LoginPage extends BaseClass {

	@FindBy(name = "email")
	private WebElement email;

	@FindBy(name = "password")
	private WebElement password;

	@FindBy(xpath = "//div[text()='Login']")
	private WebElement login;

	@FindBy(xpath = "//div[@class='header item']")
	private WebElement Logo;

	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void userenteredvalidusernameandpassword(String username, String Password) {

		WaitClass.SendKeys(email, username);
		WaitClass.SendKeys(password, Password);
	}

	public void usershouldclickonloginbutton() {
		WaitClass.click(login);
	}

	public void userisonhomepageandvalidatethetitleofhomepage() {

		System.out.println(getDriver().getTitle());
	}

	public void validatetheurlofthehomepage() {

		System.out.println(getDriver().getCurrentUrl());
	}

	public void valdatethelogoofthehomepage() {
		WaitClass.isDisplayed(Logo);
	}

}
