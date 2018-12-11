package StageII;

import com.webtest.core.WebDriverEngine;

public class InOA {
	public static WebDriverEngine inoa(WebDriverEngine webtest) {
		webtest.click("id=s-menu-2");
		webtest.enterFrame("iframe-2");
		return webtest;
	}
	
	public static WebDriverEngine outoa(WebDriverEngine webtest) {
		webtest.leaveFrame();
		return webtest;
	}
}
