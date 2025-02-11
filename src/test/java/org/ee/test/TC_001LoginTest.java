package org.ee.test;

import java.util.Properties;

import org.ee.pages.LoginPage;
import org.ee.seleniumbase.Base;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.PropertiesReader;
import utils.ReadExcel;

public class TC_001LoginTest extends Base {

	@Test(dataProvider = "getExcelSheetData", dataProviderClass = ReadExcel.class)
	private void loginTest(String username, String password) {

		LoginPage login = new LoginPage(driver, wait);
		login.enterUserName(PropertiesReader.getInstancePropertyReader().getUsername())
				.enterPassword(PropertiesReader.getInstancePropertyReader().getPassword()).clickLogin();
		demo.createTest("Login with valid credentials", "pass");

		Assert.assertEquals(driver.getCurrentUrl(), "https://test-manage.eateasy.ae/users/employee_log");

	}

}
