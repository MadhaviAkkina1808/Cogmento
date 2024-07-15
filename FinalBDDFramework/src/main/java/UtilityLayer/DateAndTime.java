package UtilityLayer;

import java.text.SimpleDateFormat;
import java.util.Date;

import BaseLayer.BaseClass;

public class DateAndTime extends BaseClass {

	public static String captureyear() {
		return new SimpleDateFormat("yyyy").format(new Date());
	}

	public static String captureMonthAndYear() {
		return new SimpleDateFormat("MMyyyyy").format(new Date());
	}

	public static String captureCurrentDateAndTime() {
		return new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
	}

}
