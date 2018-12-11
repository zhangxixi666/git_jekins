package StageII;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.WebDriverEngine;
import com.webtest.core.WebTestListener;
import com.webtest.test.Common;
@Listeners(WebTestListener.class)
public class AddProduct {
	WebDriverEngine wbt = null;
	@Test(priority = 0) 
	public void sucAdd_test() throws Exception {
		wbt=new WebDriverEngine(Common.ff_login());
		wbt.click("id=s-menu-1");
		wbt.enterFrame("iframe-1");//wbt.driver.findElement(By.id("iframe-1"))
		wbt.click("xpath=.//*[@id='mainNavbar']/ul/li[8]/a");
		wbt.click("id=menuActions");
		wbt.type("id=name","������ÿ�");
		wbt.type("id=code","CreditCard001");
		wbt.selectByVisibleText("id=category", "/��Ѷ/΢��/΢��֧��");
		wbt.selectByVisibleText("id=type", "������");
		wbt.selectByVisibleText("id=status", "����");
		
		wbt.click("id=submit");
//		wbt.leaveFrame();
	}
	@Test(priority = 1) 
	public void failAdd_test()throws Exception{
		/*WebDriverEngine wbt = new WebDriverEngine(Common.ff_login());
		wbt.click("id=s-menu-1");
		wbt.enterFrame("iframe-1");
		wbt.click("xpath=.//*[@id='mainNavbar']/ul/li[8]/a");*/
		wbt.click("id=menuActions");
		wbt.type("id=name","���֧����ʽ");
		wbt.type("id=code","CreditCard001");
		wbt.selectByVisibleText("id=category", "/��Ѷ/΢��/΢��֧��");
		wbt.selectByVisibleText("id=type", "������");
		wbt.selectByVisibleText("id=status", "����");
		wbt.click("id=submit");
		boolean bl = wbt.isTextPresent("<strong>����</strong>�Ѿ���<strong>CreditCard01</strong>������¼�ˡ�");
		wbt.leaveFrame();
		assertEquals(bl,true);
		
		
	}
	@AfterSuite
	public void close() {
		this.wbt.driver.quit();
	}
}
