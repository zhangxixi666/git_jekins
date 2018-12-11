package com.webtest.test;

import org.testng.annotations.Test;

public class TestMultiBroswer {
	@Test(enabled=true, threadPoolSize=5, invocationCount=10)
	public void test1() throws Exception{
		Common.ff_login();
	}
	
	@Test(enabled=true, threadPoolSize=5, invocationCount=10)
	public void test2() throws Exception{
		Common.e_login();
	}
	
	@Test(enabled=true, threadPoolSize=5, invocationCount=10)
	public void test3() throws Exception{
		Common.c_login();
	}
}
