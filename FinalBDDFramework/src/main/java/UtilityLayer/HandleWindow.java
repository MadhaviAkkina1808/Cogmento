package UtilityLayer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import BaseLayer.BaseClass;

public class HandleWindow extends BaseClass {

	public static void handleWindoworTab(int windownumber) {

		Set<String> listwindow = getDriver().getWindowHandles();

		ArrayList<String> arrayList = new ArrayList<String>();

		Iterator<String> it = listwindow.iterator();

		while (it.hasNext()) {
			String windowid = it.next();
			arrayList.add(windowid);
		}

		getDriver().switchTo().window(arrayList.get(windownumber));

	}

	public static void handleWindoworTabFor(String parentID) {

		Set<String> listwindows = getDriver().getWindowHandles();

		String secondWindow = null;
		for (String abc : listwindows) {
			if (!abc.equals(parentID)) {
				secondWindow = abc;
			}
		}
		getDriver().switchTo().window(secondWindow);
	}

	public static void handleWindoworTabArraylist(int index) {

		Set<String> listwindows = getDriver().getWindowHandles();

		ArrayList<String> arr = new ArrayList<String>(listwindows);
		getDriver().switchTo().window(arr.get(index));
	}

}