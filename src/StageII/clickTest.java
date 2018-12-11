package StageII;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.WebDriverEngine;
import com.webtest.core.WebTestListener;
import com.webtest.test.Common;
//循环点击
/*@Listeners(WebTestListener.class)*/
public class clickTest {
	WebDriverEngine wde = null;
	@Test(priority = 4)
	public void try_test() throws Exception {
		wde = new WebDriverEngine(Common.ff_login());
		wde = InOA.inoa(wde);
		for(int i=30;i>0;i--) {
			wde.click("xpath=/html/body/nav[1]/ul/li[3]/a");//公告
		}
	}
	@AfterSuite
	public void close() {
		this.wde.driver.quit();
	}
}
