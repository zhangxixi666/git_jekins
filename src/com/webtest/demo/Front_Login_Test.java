package com.webtest.demo;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class Front_Login_Test extends BaseTest{

	public Front_Login_Test(String type) throws Exception {
		super(type);
		// TODO Auto-generated constructor stub
	}

	Login_Action action;
	
	@BeforeMethod
	public void setup()
	{
		action=new Login_Action(webtest);
	}

	@Test
	public void testLogin() throws Exception  {
		webtest.open("http://www.baidu.com");
//		action.login("qingdao01", "123456");
		assertTrue(webtest.ifContains("ÍË³ö1"));
		

	}

}
