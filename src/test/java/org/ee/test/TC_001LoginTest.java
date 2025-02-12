package org.ee.test;

import java.util.Properties;

import org.ee.pages.LoginPage;
import org.ee.seleniumbase.Base;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.PropertiesReader;
import utils.ReadExcel;

public class TC_001LoginTest extends Base {

	@Test(dataProvider = "getValidLoginExcelSheetData", dataProviderClass = ReadExcel.class)
	private void loginTestWithValidData(String username, String password) {

		LoginPage login = new LoginPage(driver, wait);
		login.enterUserName(PropertiesReader.getInstancePropertyReader().getUsername());
		demo.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), "pass");
		login.enterPassword(PropertiesReader.getInstancePropertyReader().getPassword()).clickLogin();
		

		Assert.assertEquals(driver.getCurrentUrl(), "https://test-manage.eateasy.ae/users/employee_log");

	}
	
	@Test(dataProvider = "getInValidLoginExcelSheetData", dataProviderClass = ReadExcel.class)
	private void loginTesWithInvalidData(String username, String password) {

		LoginPage login = new LoginPage(driver, wait);
		login.enterUserName(username);
		demo.createTest(new Object() {}.getClass().getEnclosingMethod().getName(), "fail");
		login.enterPassword(password).clickLogin();
		

		Assert.assertEquals(driver.getCurrentUrl(), "https://test-manage.eateasy.ae/users/employee_log");

	}
	
	

}
