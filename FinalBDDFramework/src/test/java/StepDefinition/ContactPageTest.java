package StepDefinition;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;

import BaseLayer.BaseClass;
import PageLayer.ContactPage;
import UtilityLayer.ExcelReaderBDD;
import io.cucumber.java.en.When;

public class ContactPageTest extends BaseClass {

	protected static ContactPage contacts;

	@When("user is on Home page and click on contacts tab")
	public void user_is_on_home_page_and_click_on_contacts_tab() {
		contacts = new ContactPage();
		contacts.clickoncontactstab();

	}

	@When("user is on Contacts Page,validate the url contains {string}")
	public void user_is_on_contacts_page_validate_the_url_contains(String string) {
		String actualurl = getDriver().getCurrentUrl();
		Assertions.assertEquals(actualurl.contains(string), true);

	}

	@When("click on create button")
	public void click_on_create_button() {
		contacts.clickoncreatebutton();

	}

	@When("user enter contact informaton from excel sheet {string} and {int}")
	public void user_enter_contact_informaton_from_excel_sheet_and(String ContactsList, Integer rownumber)
			throws IOException, InterruptedException {
		ExcelReaderBDD excel = new ExcelReaderBDD();
		String path = System.getProperty("user.dir") + "//src//main//java//TestDataLayer//ContactsPage.xlsx";
		List<Map<String, String>> data = excel.getAllSheetTestData(path, ContactsList);
		String fname = data.get(rownumber).get("FirstName");
		String Mname = data.get(rownumber).get("LastName");
		String Lname = data.get(rownumber).get("MiddleName");
		String status = data.get(rownumber).get("Status");
		String category = data.get(rownumber).get("Category");
		contacts.contactinformaton(fname, Lname, Mname, status, category);
	}

	@When("click on save button")
	public void click_on_save_button() {
		contacts.clickonsavebutton();
	}

	@When("user will delete the created contact")
	public void user_will_delete_the_created_contact() {
		contacts.deletethecreatedcontact();
	}

	@When("user click on profile icon")
	public void user_click_on_profile_icon() {
		contacts.clickonprofileicon();
	}

	@When("user click on logout option")
	public void user_click_on_logout_option() {
		contacts.clickonlogoutoption();
	}

	@When("user close the session")
	public void user_close_the_session() {
		getDriver().close();

	}

}
