package StageII;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.WebDriverEngine;
import com.webtest.core.WebTestListener;
import com.webtest.test.Common;
@Listeners(WebTestListener.class)
public class DayOff {
	WebDriverEngine wde = null;
	@Test(priority = 5)
	public void dayoff_test() throws Exception {
		wde=new WebDriverEngine(Common.ff_login());
		wde=InOA.inoa(wde);
		wde.click("link=�ڼ���");
		wde.click("link=�½�");
		if(!wde.isChecked("id=typeholiday")){wde.click("id=typeholiday");}
		wde.type("id=name", "���Լ���-1");
		wde.tapClick();wde.tapType("2018-12-4");wde.enterClick();
		wde.tapClick();wde.tapType("2018-12-7");wde.enterClick();
		wde.tapClick();wde.tapType("���Լ�����������");
		wde.click("id=submit");
	}
	
	@Test(priority = 6)
	public void overtime_test() {
		wde.click("link=�½�");
		if(!wde.isChecked("id=typeworking")) {wde.click("id=typeworking");}
		wde.type("id=name", "���Բ���-1");
		wde.tapClick();wde.tapType("2018-12-8");wde.enterClick();
		wde.tapClick();wde.tapType("2018-12-9");wde.enterClick();
		wde.tapClick();wde.tapType("���Բ�����������");
		wde.click("id=submit");
	}
	
	@AfterSuite
	public void close() {
		this.wde.driver.quit();
	}
}
