package com.webtest.core;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;


import com.webtest.utils.Log;
import com.webtest.utils.ReadProperties;

/**
 * author:lihuanzhen
 * ��ʼ�������
 */


public class BaseTest {

	public  WebDriverEngine webtest;
	private WebDriver driver;
	public String driverType;

	//���캯��
	public BaseTest(String type) throws Exception{
		driverType = type;
		driver = this.newWebDriver(driverType);
		driver.manage().window().maximize();
		Log.info(driverType);
		webtest = new WebDriverEngine(driver);
	}
	

	private WebDriver newWebDriver(String driverType) throws IOException {
		WebDriver driver = null;
	 if (driverType.equalsIgnoreCase("firefox")) {
		    String firefox_driver = ReadProperties.getPropertyValue("gecko_driver");
			String firefox_path = ReadProperties.getPropertyValue("firefox_path");
			System.setProperty("webdriver.gecko.driver", firefox_driver);
			System.setProperty("webdriver.firefox.bin", firefox_path);
			driver = new FirefoxDriver();
	
			Log.info("Using Firefox");
		}  else if (driverType.equalsIgnoreCase("chrome")) {
			String chrome_path = ReadProperties.getPropertyValue("chrome_path");
			System.setProperty("webdriver.chrome.driver",chrome_path);
			driver = new ChromeDriver();
			Log.info("Using Chrome");
		
		}else if(driverType.equalsIgnoreCase("edge")) {
			String edge_path = ReadProperties.getPropertyValue("edge_path");
			System.setProperty("webdriver.edge.driver",edge_path);
			driver = new EdgeDriver();
			Log.info("Using Edge");
		}else{
			System.out.println("Not found this browser,You can use ��firefox��, ��chrome�� or ��edge��");//�����Ҫ���������firefox, chrome, edge���ӡ��Ϣ�Ҳ�����������������ؿ�ָ�롣
			return null;
		}

		
		return driver;

	
	}

	
	


//	@BeforeSuite
//	public void doBeforeSuite() throws Exception {
//
////		driverType=ReadProperties.getPropertyValue("driverType");
////		driver = this.newWebDriver(driverType);
////		driver.manage().window().maximize();
////		Log.info(driverType);
////		webtest = new WebDriverEngine(driver);
//		System.out.println("before");
//	
//	
//	}


	@AfterSuite
	public void doAfterMethod() {
		if(this.driver != null){
			this.driver.quit();
			}
		Log.info("Quitted Browser");
	}
	

	

	
	public WebDriver getDriver() {
        return driver;
    }

	public static final String cfilePath="conf/cfg.properties";
	
	public static String getCfgProperty(String key) throws IOException{
		// TODO Auto-generated method stub
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(cfilePath);
		prop.load(fis);
		fis.close();
		return prop.getProperty(key);
		
	}


	

}
