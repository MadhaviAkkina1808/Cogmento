package UtilityLayer;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseLayer.BaseClass;

public class HandleFrames extends BaseClass {

	public static void frameByIdOrName(String idorname) {

		new WebDriverWait(getDriver(), Duration.ofSeconds(30))
				.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(idorname));
	}

	public static void framebyIndex(int frameindex) {
		new WebDriverWait(getDriver(), Duration.ofSeconds(30))
				.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameindex));
	}

	public static void frameByWebElement(WebElement framewb) {
		new WebDriverWait(getDriver(), Duration.ofSeconds(30))
				.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(framewb));
	}

	public static void parentframe() {
		getDriver().switchTo().parentFrame();

	}

	public static void defaultContent() {
		getDriver().switchTo().defaultContent();
	}

}
