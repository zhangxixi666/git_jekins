package com.webtest.test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.SeleniumScreenShot;
import com.webtest.core.WebTestListener;
@Listeners(WebTestListener.class)
public class login_test {
	@Test
	public void test_clogin() throws Exception{
		Common.c_login();
		/*SeleniumScreenShot a = new SeleniumScreenShot(Common.ff_login());
		a.screenShot();*/
	}
	@Test
	public void test_elogin() throws Exception{
		Common.e_login();
	}
	@Test
	public void test_fflogin() throws Exception{
		Common.ff_login();
	}
	@Test
	public void test_fail()throws Exception{
		System.out.println("wrong!");
	}
}
