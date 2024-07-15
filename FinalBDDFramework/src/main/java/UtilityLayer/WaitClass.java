package UtilityLayer;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseLayer.BaseClass;

public class WaitClass extends BaseClass {

	public static WebElement visibilityofelement(WebElement wb) {
		return new WebDriverWait(getDriver(), Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(wb));
	}

	public static void click(WebElement wb) {
		new WebDriverWait(getDriver(), Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(wb))
				.click();
		;
	}

	public static void submit(WebElement wb) {
		new WebDriverWait(getDriver(), Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(wb))
				.submit();
	}

	public static void SendKeys(WebElement wb, String value) {
		WaitClass.visibilityofelement(wb).sendKeys(value);
	}

	public static String getText(WebElement wb) {
		return WaitClass.visibilityofelement(wb).getText();
	}

	public static String getAttribute(WebElement wb, String value) {
		return WaitClass.visibilityofelement(wb).getAttribute(value);
	}

	public static void clear(WebElement wb) {
		WaitClass.visibilityofelement(wb).clear();
	}

	public static void isDisplayed(WebElement wb) {
		WaitClass.visibilityofelement(wb).isDisplayed();
	}

	public static void isEnables(WebElement wb) {
		WaitClass.visibilityofelement(wb).isEnabled();
	}

	public static void isSelected(WebElement wb) {
		WaitClass.visibilityofelement(wb).isSelected();
	}

}
