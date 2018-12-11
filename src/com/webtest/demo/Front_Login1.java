package com.webtest.demo;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvider;

public class Front_Login1 extends BaseTest{


	public Front_Login1(String type) throws Exception {
		super(type);
		// TODO Auto-generated constructor stub
	}

	@Test(dataProvider="excel",dataProviderClass=NSDataProvider.class)
	public void testSearch(String u_name,String u_pwd) throws Exception  {
		
		webtest.open("http://localhost:8032/mymovie/");
		webtest.click("link=µÇÂ¼");
		webtest.type("name=username", u_name);
		webtest.type("name=password", u_pwd);
		webtest.click("xpath=//input[@value='ÂíÉÏµÇÂ¼']");
		assertTrue(webtest.ifContains("ÍË³ö"));
		

	}

}
