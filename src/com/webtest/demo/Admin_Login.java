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
		//��ҳ��
		webtest.open("http://localhost:8032/MyMovie/admin.php/Login/index.html");
		//�ı�������
		webtest.type("name=username", "admin");
		webtest.type("name=password", "admin");
		//���
		webtest.click("xpath=//input[@type = 'submit']");
		assertTrue(webtest.isTextPresent("�˳�"));
	}
}
