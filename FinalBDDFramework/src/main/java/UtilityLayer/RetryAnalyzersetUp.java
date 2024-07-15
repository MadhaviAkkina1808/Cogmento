package UtilityLayer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import BaseLayer.BaseClass;

public class RetryAnalyzersetUp extends BaseClass implements IRetryAnalyzer {

	@Override
	public boolean retry(ITestResult result) {
		int counter = 0;
		int maxretrycounter = 5;

		if (counter < maxretrycounter) {
			counter++;
			return true;
		}
		return false;
	}

}
