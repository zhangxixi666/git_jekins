package StageII;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.WebDriverEngine;
import com.webtest.core.WebTestListener;
import com.webtest.test.Common;
//9269
@Listeners(WebTestListener.class)
public class public_notice {
	WebDriverEngine wde = null;
	@Test(priority = 9)
	public void ClassTree() throws Exception{
		wde = new WebDriverEngine(Common.ff_login());
		wde = InOA.inoa(wde);
		wde.click("link=公告");
		wde.click("link=类目管理");
		wde.type("name=children[1]", "根类目");
		wde.click("id=submit");
		wde.click("link=公告列表");
		wde.click("link=添加公告");
		wde.click("id=categories_chosen");
		wde.click("xpath=/html/body/div[1]/div/div[2]/form/table/tbody/tr[1]/td[1]/div[2]/div/ul/li[1]");
		wde.type("id=title", "第一则公告");
		wde.tapClick();
		wde.tapType("公告正文");
		wde.enterClick();
		wde.tapType("详细内容。");
		wde.click("id=submit");
		boolean bl = wde.isTextPresent("第一则公告</a>");
		assertEquals(bl,true);
	
	}
	@AfterSuite
	public void close() {
		this.wde.driver.quit();
	}
}
