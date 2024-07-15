package UtilityLayer;

import java.util.List;

import org.openqa.selenium.WebElement;

import BaseLayer.BaseClass;

public class Calender extends BaseClass {

	public static void findmonthandyear(WebElement actualmonthandyear, String expectedmonthandyear, WebElement next) {

		while (true) {
			if (WaitClass.getText(actualmonthandyear).equalsIgnoreCase(expectedmonthandyear)) {
				break;
			} else {
				WaitClass.click(next);
			}
		}
	}

	public static void selectDate(List<WebElement> listdates, String expectedDate) {

		for (WebElement dates : listdates) {
			if (WaitClass.getText(dates).contains(expectedDate)) {
				WaitClass.click(dates);
				break;
			}

		}
	}

}
