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
	        System.out.println(Thread.currentThread().getId()+"-----------------------"+sf.format(new Date()));//打印线程启动时间
	        
	        /*
	         * 当采用 InterenetExplorerDriver时，可能会遇到一个安全问题提示："Protected Mode must be
	         * set to the same value (enabled or disabled) for all
	         * zones"。想要解决这一问题，需要设置特定的功能
	         */
	        DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
	        
	        
	        //最好设置，用来匹配node中要使用的浏览器
	        capability.setBrowserName("microsoft edge");
	        capability.setVersion("9");
	        capability.setPlatform(Platform.WINDOWS);
	        
	        WebDriver driver = null;
	        
	        //设置本地驱动，如果你实例化Driver的时候是"WebDriver driver = new InternetExplorerDriver(capability)"这种方式，就必须设置
	        System.setProperty("webdriver.edge.driver","D:\\g3softwaretesting\\MicrosoftWebDriver.exe");
	        
	        try{
//	            driver = new EdgeDriver(capability);//本地测试，非远程方式
	            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capability);//远程方式，想用多线程需要这么写
	            System.out.println(Thread.currentThread().getId()+"访问163邮箱网页开始时间："+sf.format(new Date()));
	            
	            driver.get("http://mail.163.com/");//打开网页
	            
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
