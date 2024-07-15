package UtilityLayer;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseLayer.BaseClass;

public class Handledropdown extends BaseClass {

	public static void selectByVisibleText(WebElement wb, String value) {
		new Select(WaitClass.visibilityofelement(wb)).selectByVisibleText(value);
	}

	public static void selectByValue(WebElement wb, String value) {
		new Select(WaitClass.visibilityofelement(wb)).selectByValue(value);
	}

	public static void selectByIndex(WebElement wb, int index) {
		new Select(WaitClass.visibilityofelement(wb)).selectByIndex(index);
	}

	public static String getFirstSelectedOption(WebElement wb) {
		return new Select(WaitClass.visibilityofelement(wb)).getFirstSelectedOption().getText();
	}

	public static void getOptions(WebElement wb) {
		List<WebElement> ls = new Select(WaitClass.visibilityofelement(wb)).getOptions();
		for (WebElement abc : ls) {
			System.out.println(abc.getText());
		}
	}

	public static int sizeOfDorpDown(WebElement wb) {
		return new Select(WaitClass.visibilityofelement(wb)).getOptions().size();
	}

	// without Select tag
	public static void dropDownWithoutSelect(WebElement wb, List<WebElement> listValue, String expectedValue) {
		WaitClass.click(wb);
		new WebDriverWait(getDriver(), Duration.ofSeconds(30))
				.until(ExpectedConditions.visibilityOfAllElements(listValue));
		for (WebElement list : listValue) {
			String abc = list.getText();
			if (abc.equalsIgnoreCase(expectedValue)) {
				WaitClass.click(list);
				break;
			}
		}

	}
}