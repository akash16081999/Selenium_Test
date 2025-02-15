package org.ee.test;

import org.seleniumbase.Base;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.ReadExcel;

public class TC_001LoginTest extends Base {

	@Test(dataProvider = "getValidLoginExcelSheetData", dataProviderClass = ReadExcel.class)
	private void loginTestWithValidData(String username, String password) {
		
		System.out.println(Thread.currentThread().getId());

		pagemanager.getInstanceLoginPage().enterUserEmail(username);

		pagemanager.getInstanceLoginPage().enterPassword(password);

		pagemanager.getInstanceLoginPage().clickLogin();

		Assert.assertEquals(getDriver().getCurrentUrl(),
				assertmanager.getLoginPageAssertionInstance().getSucessFullLoginAssert());

	}

	@Test(dataProvider = "invalidData", dataProviderClass = ReadExcel.class)
	private void loginTesWithInvalidData(String username, String password) {
		System.out.println(Thread.currentThread().getId());

		pagemanager.getInstanceLoginPage().enterUserEmail(username);

		pagemanager.getInstanceLoginPage().enterPassword(password).clickLogin();

		Assert.assertEquals(getDriver().getCurrentUrl(),
				assertmanager.getLoginPageAssertionInstance().getUnsucessfullLoginAssert());

	}

}
