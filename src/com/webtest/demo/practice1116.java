package com.webtest.demo;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
//��ʼ��ʮ�������5���û���򿪣�5���ùȸ��
public class practice1116 {
	public static void init() throws Exception{
		BaseTest[] browser = new BaseTest[10];
		int i = 10;
		for(int j=0;i>0;i--,j++) {
			if(i%2==0) {browser[j] = new BaseTest("firefox");}
			else {browser[j] = new BaseTest("chrome");}
			Thread.sleep(1500);
		}
	}
	
	public static void main(String[] args) throws Exception{
		//init();
		BaseTest edge = new BaseTest("edge");
	}
	
}
