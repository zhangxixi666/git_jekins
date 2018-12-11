package com.webtest.test;

import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestLogin_TestNG implements Runnable{
	 public static final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSS");

	    @Test
	    public void run() {
	        System.out.println(Thread.currentThread().getId()+"-----------------------"+sf.format(new Date()));//��ӡ�߳�����ʱ��
	        
	        /*
	         * ������ InterenetExplorerDriverʱ�����ܻ�����һ����ȫ������ʾ��"Protected Mode must be
	         * set to the same value (enabled or disabled) for all
	         * zones"����Ҫ�����һ���⣬��Ҫ�����ض��Ĺ���
	         */
	        DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
	        
	        
	        //������ã�����ƥ��node��Ҫʹ�õ������
	        capability.setBrowserName("microsoft edge");
	        capability.setVersion("9");
	        capability.setPlatform(Platform.WINDOWS);
	        
	        WebDriver driver = null;
	        
	        //���ñ��������������ʵ����Driver��ʱ����"WebDriver driver = new InternetExplorerDriver(capability)"���ַ�ʽ���ͱ�������
	        System.setProperty("webdriver.edge.driver","D:\\g3softwaretesting\\MicrosoftWebDriver.exe");
	        
	        try{
//	            driver = new EdgeDriver(capability);//���ز��ԣ���Զ�̷�ʽ
	            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capability);//Զ�̷�ʽ�����ö��߳���Ҫ��ôд
	            System.out.println(Thread.currentThread().getId()+"����163������ҳ��ʼʱ�䣺"+sf.format(new Date()));
	            
	            driver.get("http://mail.163.com/");//����ҳ
	            
	        }catch (Exception e) {
	                System.out.println(Thread.currentThread().getId()+" Visit http://mail.163.com/ Error !!!");
	                e.printStackTrace();
	                this.CaptureScreenshot(Thread.currentThread().getId()+"visit", driver);
	                driver.quit();
	                Thread.currentThread().interrupt();
	            }
	        
	 }
	    public void CaptureScreenshot(String fileName, WebDriver driver) {
	        String dirName = "d:/screenshot";
	        if (!(new File(dirName).isDirectory())) {
	            new File(dirName).mkdir();
	        }
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
	        String time = sdf.format(new Date());
	        TakesScreenshot tsDriver = (TakesScreenshot) driver;
	        File image = new File(dirName + File.separator + time + "_" + fileName==null?"":fileName + ".png");
	        tsDriver.getScreenshotAs(OutputType.FILE).renameTo(image);
	    }
}
