package UtilityLayer;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ListenersSetup extends ExtentReport implements ITestListener {
	public static ExtentReports extentreports;
	public static ExtentTest extentTest;

	@Override
	public void onStart(ITestContext context) {
		extentreports = ExtentReport.Setup(context.getSuite().getName());
	}

	@Override
	public void onTestStart(ITestResult result) {
		extentTest = extentreports.createTest("Test case name" + result.getMethod().getMethodName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.PASS, "Test Case Name:" + result.getMethod().getMethodName());
		String destinationpath = Screenshot.takesScreenshot("PassScreenshot:", result.getMethod().getMethodName());
		extentTest.addScreenCaptureFromPath(destinationpath);

	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.log(Status.FAIL, "Test Case Name:" + result.getMethod().getMethodName());
		String destinationpath = Screenshot.takesScreenshot("FailScreenshot:", result.getMethod().getMethodName());
		extentTest.addScreenCaptureFromPath(destinationpath);

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.log(Status.SKIP, "Test Case Name:" + result.getMethod().getMethodName());

	}

	@Override
	public void onFinish(ITestContext context) {
		extentreports.flush();
	}

}
