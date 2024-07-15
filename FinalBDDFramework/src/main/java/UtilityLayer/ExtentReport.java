package UtilityLayer;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import BaseLayer.BaseClass;

public class ExtentReport extends BaseClass {

	public static ExtentReports Setup(String reportName) {

		ExtentReports extentreports = new ExtentReports();

		String destinationpath = System.getProperty("user.dir") + "//ExtentReport//" + "//" + DateAndTime.captureyear()
				+ "//" + DateAndTime.captureMonthAndYear() + "//" + reportName + DateAndTime.captureCurrentDateAndTime()
				+ ".html";

		extentreports.attachReporter(new ExtentSparkReporter(destinationpath));

		return extentreports;

	}

}
