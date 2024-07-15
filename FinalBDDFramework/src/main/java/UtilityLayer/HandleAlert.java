package UtilityLayer;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseLayer.BaseClass;

public class HandleAlert extends BaseClass {

	public static Alert alertIsPresent() {
		return new WebDriverWait(getDriver(), Duration.ofSeconds(30)).until(ExpectedConditions.alertIsPresent());
	}

	public static void alertaccept() {
		alertIsPresent().accept();
	}

	public static void alertDismiss() {
		alertIsPresent().dismiss();
	}

	public static String alertgetText() {
		return alertIsPresent().getText();
	}

	public static void alertsendKeys(String value) {
		alertIsPresent().sendKeys(value);
	}
}
