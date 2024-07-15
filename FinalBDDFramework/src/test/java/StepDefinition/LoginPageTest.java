package StepDefinition;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import BaseLayer.BaseClass;
import PageLayer.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LoginPageTest extends BaseClass {
	public static LoginPage login;

	@Given("user is on login page using {string} browser")
	public void user_is_on_login_page_using_browser(String browsername) {
		BaseClass.initialization(browsername);
	}

	@When("user entered valid username and password")
	public void user_entered_valid_username_and_password(DataTable dataTable) {
		List<List<String>> list = dataTable.asLists();
		String uName = list.get(0).get(0);
		String pWord = list.get(0).get(1);
		login = new LoginPage();
		login.userenteredvalidusernameandpassword(uName, pWord);

	}

	@When("user should click on login button")
	public void user_should_click_on_login_button() {
		login.usershouldclickonloginbutton();
	}

	@Given("user is on homepage and validate the title of homepage")
	public void user_is_on_homepage_and_validate_the_title_of_homepage() {
		login.userisonhomepageandvalidatethetitleofhomepage();
		String actualTitle = getDriver().getTitle();
		Assert.assertEquals(actualTitle.contains("Cogmento"), true);

	}

	@Given("Validate the url of the homepage")
	public void validate_the_url_of_the_homepage() {
		login.validatetheurlofthehomepage();
		String actualurl = getDriver().getCurrentUrl();
		Assert.assertEquals(actualurl.contains("cogmento"), true);
	}

	@Given("valdate the logo of the homepage")
	public void valdate_the_logo_of_the_homepage() {
		login.valdatethelogoofthehomepage();
	}
	
	@AfterStep
	public static void extentScreenshots(Scenario scenario) {
		TakesScreenshot ts= (TakesScreenshot)getDriver();
		byte[] src=ts.getScreenshotAs(OutputType.BYTES);
		scenario.attach(src, "image/png", scenario.getName());
	}
	
}
