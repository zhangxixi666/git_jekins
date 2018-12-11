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
		wbt.type("id=name","添加信用卡");
		wbt.type("id=code","CreditCard001");
		wbt.selectByVisibleText("id=category", "/腾讯/微信/微信支付");
		wbt.selectByVisibleText("id=type", "虚拟类");
		wbt.selectByVisibleText("id=status", "正常");
		
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
		wbt.type("id=name","添加支付方式");
		wbt.type("id=code","CreditCard001");
		wbt.selectByVisibleText("id=category", "/腾讯/微信/微信支付");
		wbt.selectByVisibleText("id=type", "虚拟类");
		wbt.selectByVisibleText("id=status", "正常");
		wbt.click("id=submit");
		boolean bl = wbt.isTextPresent("<strong>代号</strong>已经有<strong>CreditCard01</strong>这条记录了。");
		wbt.leaveFrame();
		assertEquals(bl,true);
		
		
	}
	@AfterSuite
	public void close() {
		this.wbt.driver.quit();
	}
}
