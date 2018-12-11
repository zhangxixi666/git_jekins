package com.webtest.test;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class LoginClass {
	  private WebDriver dr;  
	     DesiredCapabilities browsers;  

	     @Parameters({"browser","nodeIp"})  
	     @Test 
	     public void setUp(String browser,String nodeIp) {  
	         if(browser.equals("edge")) browsers = DesiredCapabilities.edge();  
	         else if(browser.equals("firefox")) browsers = DesiredCapabilities.firefox();  
	         else if(browser.equals("chrome")) browsers = DesiredCapabilities.chrome();   

	         try {
	            dr = new RemoteWebDriver(new URL(nodeIp+"/wd/hub"),browsers);
	        } catch (MalformedURLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }  
	         dr.get("https://www.baidu.com/");  

	         //查看用的哪个进程
	         long id = Thread.currentThread().getId();
	         System.out.println("Thread id is: " + id);
	     }  
	
}
