package StageII;

import java.util.Random;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.WebDriverEngine;
import com.webtest.core.WebTestListener;
import com.webtest.test.Common;

//9055
@Listeners(WebTestListener.class)
public class oaAddBlock {
	WebDriverEngine wde = null;
	@Test(priority = 7)
	public void addBlock_test() throws Exception{
		wde = new WebDriverEngine(Common.ff_login());		
		wde = InOA.inoa(wde);
		wde.click("xpath=/html/body/div[1]/div/div[2]/a");
		wde.selectByVisibleText("id=blocks","ϵͳ����");
		wde.type("xpath=//*[@id=\"title\"]", "����������");
		wde.selectByVisibleText("id=grid", "100%");
		wde.click("xpath=/html/body/div[2]/div/div/div[2]/form/table/tbody/tr[2]/td/div/div/div/button");//������ɫѡ��ť
				       ///html/body/div[2]/div/div/div[2]/form/table/tbody/tr[2]/td/div/div/div/button 	
		wde.click("xpath=//button[@data-id='success']");		
		wde.typeAndClear("xpath=.//*[@id='params[num]']","10");
		wde.click("id=submit");
		wde = InOA.outoa(wde);
	}
	@Test(priority = 8)
	public void addBlocks_test() throws Exception{
		wde = new WebDriverEngine(Common.ff_login());
		wde = InOA.inoa(wde);
		Random random = new Random();//���������
		String common = "xpath=//button[@data-id=";//'success']
		String[] color = {"'default']","'primary']","'warning']","'danger']","'success']","'info']",};//��ɫid�ַ�������
		for(int i = 0;i<10;i++) {
			String BlockName = "����������" + "_" +i;//��������						
			int block_r = random.nextInt(2)+1;//�������������֤������������������			
			int size_r = random.nextInt(6);//�������������֤�������Ĵ�С�������			
			int color_r = random.nextInt(6);//�������������֤������ɫ�������			
			wde.click("link=�������");
			wde.selectByIndex("id=blocks",block_r);
			wde.type("xpath=.//*[@id='title']",BlockName);
			wde.selectByIndex("id=grid", size_r);
			wde.click("xpath=/html/body/div[2]/div/div/div[2]/form/table/tbody/tr[2]/td/div/div/div/button");//������ɫѡ��ť 	
			wde.click(common + color[color_r]);System.out.println(common + color[color_r]);	
			if(block_r == 1) {wde.typeAndClear("xpath=.//*[@id='params[num]']","10");}
			wde.click("id=submit");						
		}
		wde = InOA.outoa(wde);
	}
	@AfterSuite
	public void close() {
		this.wde.driver.quit();
	}
}
