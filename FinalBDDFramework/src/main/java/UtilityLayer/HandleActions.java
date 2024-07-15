package UtilityLayer;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import BaseLayer.BaseClass;

public class HandleActions extends BaseClass {

	public static void click(WebElement wb) {
		new Actions(getDriver()).click(WaitClass.visibilityofelement(wb)).build().perform();
	}

	public static void doubleClick(WebElement wb) {
		new Actions(getDriver()).doubleClick(WaitClass.visibilityofelement(wb)).build().perform();
	}

	public static void rightClick(WebElement wb) {
		new Actions(getDriver()).contextClick(WaitClass.visibilityofelement(wb)).build().perform();
	}

	public static void mouseHover(WebElement wb) {
		new Actions(getDriver()).moveToElement(WaitClass.visibilityofelement(wb)).build().perform();
	}

	public static void dragAndDrop(WebElement src, WebElement trg) {
		new Actions(getDriver()).dragAndDrop(WaitClass.visibilityofelement(src), WaitClass.visibilityofelement(trg))
				.build().perform();
	}

	public static void release(WebElement wb) {
		new Actions(getDriver()).release(WaitClass.visibilityofelement(wb)).build().perform();
	}

	public static void clickAndHold(WebElement wb) {
		new Actions(getDriver()).clickAndHold(WaitClass.visibilityofelement(wb)).build().perform();
	}

	public static void sendkeys(WebElement wb, String value) {
		new Actions(getDriver()).sendKeys(WaitClass.visibilityofelement(wb), value).build().perform();
	}

	public static void enterUpperCase(WebElement wb, String value) {
		new Actions(getDriver()).keyDown(Keys.SHIFT).sendKeys(WaitClass.visibilityofelement(wb), value).build()
				.perform();
	}
}
