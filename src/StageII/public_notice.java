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
		wde.click("link=����");
		wde.click("link=��Ŀ����");
		wde.type("name=children[1]", "����Ŀ");
		wde.click("id=submit");
		wde.click("link=�����б�");
		wde.click("link=��ӹ���");
		wde.click("id=categories_chosen");
		wde.click("xpath=/html/body/div[1]/div/div[2]/form/table/tbody/tr[1]/td[1]/div[2]/div/ul/li[1]");
		wde.type("id=title", "��һ�򹫸�");
		wde.tapClick();
		wde.tapType("��������");
		wde.enterClick();
		wde.tapType("��ϸ���ݡ�");
		wde.click("id=submit");
		boolean bl = wde.isTextPresent("��һ�򹫸�</a>");
		assertEquals(bl,true);
	
	}
	@AfterSuite
	public void close() {
		this.wde.driver.quit();
	}
}
