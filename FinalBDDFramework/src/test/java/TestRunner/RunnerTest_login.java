package TestRunner;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;



@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/java/Feature/TC_001_Login.feature",
		"src/test/java/Feature/TC_002_ContactPage.feature" }, glue = {
		"StepDefinition" }, dryRun = false, monochrome = true,
				plugin={"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class RunnerTest_login extends AbstractTestNGCucumberTests{
	@DataProvider(parallel=true)
	@Override
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
