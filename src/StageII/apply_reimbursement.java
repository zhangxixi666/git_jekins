package StageII;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.WebDriverEngine;
import com.webtest.core.WebTestListener;
import com.webtest.test.Common;
@Listeners(WebTestListener.class)
public class apply_reimbursement {
	WebDriverEngine wde = null;
	@Test(priority = 2)
	public void suc_apply() throws Exception {
		wde = new WebDriverEngine(Common.ff_login());
		wde = InOA.inoa(wde);
		wde.click("link=����");
		wde.click("link=���뱨��");
		wde.type("id=name", "�ͻ���֧ͬ�����뱨��");
		wde.click("id=dept_chosen");//����������
		wde.click("xpath=/html/body/div[2]/form/div/div[2]/table/tbody/tr[2]/td/div[2]/div/ul/li[2]");//ѡ����
		wde.click("xpath=//*[@id='objectTypecontract']");
		((JavascriptExecutor)wde.driver).executeScript("document.getElementById(\"category\").style ='display: ';");//����ʾ����driverΪpublicȨ��
		wde.selectByIndex("id=category", 1);
		((JavascriptExecutor)wde.driver).executeScript("document.getElementById(\"customer\").style ='display: ';");
		wde.selectByVisibleText("id=customer", "��ϣϣ");
		((JavascriptExecutor)wde.driver).executeScript("document.getElementById(\"contract\").style ='display: ';");
		wde.selectByIndex("id=contract", 1);
		wde.click("link=��ϸ");
		wde.click("id=dateList[1]");
		wde.click("xpath=/html/body/div[4]/div[3]/table/tbody/tr[2]/td[1]");
		wde.click("id=categoryList1_chosen");wde.tapType("���");wde.enterClick();
		wde.tapClick();wde.tapType("1000");
		wde.tapClick();wde.tapClick();wde.tapType("������Դһ");
		wde.click("xpath=/html/body/div[2]/form/div/div[2]/table/tbody/tr[11]/td/table/tbody/tr[1]/td[6]/i[1]");
		wde.tapClick();wde.click("xpath=/html/body/div[5]/div[3]/table/tbody/tr[1]/td[5]");
		wde.click("id=categoryList2_chosen");wde.tapType("����");wde.enterClick();
		wde.tapClick();wde.tapType("500");
		wde.tapClick();wde.tapClick();wde.tapType("������Դ��");
		wde.click("xpath=/html/body/div[2]/form/div/div[2]/table/tbody/tr[13]/td/div/table[1]/tbody/tr/td[4]/a/i");
		wde.type("id=desc","������������Դ");
		wde.click("id=submit");
	}
	@Test(priority = 3)
	public void examine() throws Exception {
		wde.click("link=����");
		wde.click("link=������");
		wde.click("link=����");
		wde.click("xpath=/html/body/div[2]/div/div[1]/div[4]/a[2]");//����
		wde.click("xpath=//*[@id='submit']");//����ͨ��
		wde.click("xpath=/html/body/div[2]/div/div[1]/div[3]/a[1]");//����
		wde.click("xpath=/html/body/div[3]/div/div/div[2]/button[1]");//ȷ��
		wde.click("id=depositor_chosen");wde.enterClick();//�˻�
		wde.click("id=submit");//�ύ
	}
	
	@AfterSuite
	public void close() {
		this.wde.driver.quit();
	}
}
