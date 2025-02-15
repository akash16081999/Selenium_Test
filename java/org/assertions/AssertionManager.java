package org.assertions;

import org.openqa.selenium.WebDriver;

public class AssertionManager {

	LoginPageAssertion lpa;

	public LoginPageAssertion getLoginPageAssertionInstance() {
		return lpa;

	}

	public AssertionManager(WebDriver driver) {
		lpa = new LoginPageAssertion(driver);

	}

}
