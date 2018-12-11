package com.webtest.test;

import org.openqa.selenium.WebDriver;
import com.webtest.core.BaseTest;
import com.webtest.utils.ReadProperties;
//封装不同浏览器完成指定账户登陆的操作
public class Common {
	/*//构造函数，基于父类打开指定浏览器。Common extends BaseTest情况下
	public Common(String type) throws Exception {
		super(type);
		// TODO Auto-generated constructor stub
	}
	
	public WebDriver Login_certain() throws Exception{
		String url = ReadProperties.getPropertyValue("base_url");
		webtest.open(url);
		webtest.type("name=account", "zfy666");
		webtest.type("name=password", "522506");
		webtest.click("xpath=//button[@type='submit']");
		return this.getDriver();
	}*/
	public static BaseTest bt = null;
	
	private static WebDriver login(BaseTest bt) throws Exception{
		String url = ReadProperties.getPropertyValue("base_url");
		bt.webtest.open(url);
		bt.webtest.type("name=account", "zfy666");
		bt.webtest.type("name=password", "522506");
		bt.webtest.click("xpath=//button[@type='submit']");
		return bt.getDriver();
	}
	
	public static WebDriver ff_login() throws Exception{
		bt = new BaseTest("firefox");
		return login(bt);
	}
	
	public static WebDriver e_login() throws Exception{
		bt = new BaseTest("edge");
		return login(bt);
	}
	
	
	public static WebDriver c_login() throws Exception{
		bt = new BaseTest("chrome");
		return login(bt);
	}
	
	
	
}
