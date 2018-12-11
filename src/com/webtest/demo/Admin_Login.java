package com.webtest.demo;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class Admin_Login extends BaseTest{
	
	public Admin_Login(String type) throws Exception {
		super(type);
		// TODO Auto-generated constructor stub
	}

	@Test
	public void testLogin() {
		//打开页面
		webtest.open("http://localhost:8032/MyMovie/admin.php/Login/index.html");
		//文本框输入
		webtest.type("name=username", "admin");
		webtest.type("name=password", "admin");
		//点击
		webtest.click("xpath=//input[@type = 'submit']");
		assertTrue(webtest.isTextPresent("退出"));
	}
}
