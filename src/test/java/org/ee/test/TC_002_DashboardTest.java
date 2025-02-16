package org.ee.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.seleniumbase.Base;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.ReadExcel;

public class TC_002_DashboardTest extends Base {

	@Test(dataProvider = "getValidLoginExcelSheetData", dataProviderClass = ReadExcel.class)
	private void loginTestWithValidData(String username, String password) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(driver.hashCode()+" valid login");

		pagemanager.getInstanceLoginPage().enterUserEmail(username);

		pagemanager.getInstanceLoginPage().enterPassword(password);

		pagemanager.getInstanceLoginPage().clickLogin();

		Assert.assertEquals(getDriver().getCurrentUrl(),
				assertmanager.getLoginPageAssertionInstance().getSucessFullLoginAssert());

	}

	@Test(dataProvider = "invalidData", dataProviderClass = ReadExcel.class/* ,enabled = false */)
	private void loginTesWithInvalidData(String username, String password) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(driver.hashCode()+" invalid login");

		pagemanager.getInstanceLoginPage().enterUserEmail(username);

		pagemanager.getInstanceLoginPage().enterPassword(password).clickLogin();

		Assert.assertEquals(getDriver().getCurrentUrl(),
				assertmanager.getLoginPageAssertionInstance().getUnsucessfullLoginAssert());

	}


}
