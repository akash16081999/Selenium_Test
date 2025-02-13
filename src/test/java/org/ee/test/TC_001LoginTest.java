package org.ee.test;

import org.assertions.AssertionManager;
import org.assertions.LoginPageAssertion;
import org.seleniumbase.Base;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.ReadExcel;

public class TC_001LoginTest extends Base {

	@Test(dataProvider = "getValidLoginExcelSheetData", dataProviderClass = ReadExcel.class)
	private void loginTestWithValidData(String username, String password) {

		pagemanager.getInstanceLoginPage().enterUserEmail(username);

		pagemanager.getInstanceLoginPage().enterPassword(password);

		pagemanager.getInstanceLoginPage().clickLogin();

		Assert.assertEquals(getDriver().getCurrentUrl(),
				assertmanager.getLoginPageAssertionInstance().getSucessFullLoginAssert());

	}

	@Test(dataProvider = "invalidData", dataProviderClass = ReadExcel.class,enabled = false)
	private void loginTesWithInvalidData(String username, String password) {

		pagemanager.getInstanceLoginPage().enterUserEmail(username);

		pagemanager.getInstanceLoginPage().enterPassword(password).clickLogin();

		Assert.assertEquals(getDriver().getCurrentUrl(),
				assertmanager.getLoginPageAssertionInstance().getUnsucessfullLoginAssert());

		// Assert.assertEquals(driver.getCurrentUrl(),
		// "https://test-manage.eateasy.ae/users/employee_log");

	}

}
