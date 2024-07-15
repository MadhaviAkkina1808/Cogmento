package UtilityLayer;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import BaseLayer.BaseClass;
import io.cucumber.java.Scenario;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Screenshot extends BaseClass {
	
	public static void extentScreenshots(Scenario scenario) {
		TakesScreenshot ts= (TakesScreenshot)getDriver();
		byte[] src=ts.getScreenshotAs(OutputType.BYTES);
		scenario.attach(src, "image/png", scenario.getName());
	}
	
	
	public static String takesScreenshot(String foldername, String screenshotname) {

		String destinationpath = System.getProperty(("user.dir") + "//" + foldername + "//" + DateAndTime.captureyear()
				+ "//" + DateAndTime.captureMonthAndYear() + "//" + screenshotname
				+ DateAndTime.captureCurrentDateAndTime() + ",png");
		try {
			FileUtils.copyFile(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE),
					new File(destinationpath));
		} catch (Exception e) {

			e.printStackTrace();
		}

		return destinationpath;
	}

	public static String fullScreenshot(String foldername, String screenshotname) throws IOException {

		String destinationpath = System.getProperty("user.dir") + "//" + foldername + "//" + DateAndTime.captureyear()
				+ "//" + DateAndTime.captureMonthAndYear() + "//" + screenshotname
				+ DateAndTime.captureCurrentDateAndTime() + ".png";

		ImageIO.write(new AShot().shootingStrategy(ShootingStrategies.viewportPasting(2000)).takeScreenshot(getDriver())
				.getImage(), "png", new File(destinationpath));

		return destinationpath;

	}

}
