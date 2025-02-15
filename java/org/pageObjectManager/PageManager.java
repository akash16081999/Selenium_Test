package org.pageObjectManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pages.LoginPage;

public class PageManager {

	private LoginPage loginpage;

	public PageManager(WebDriver driver, WebDriverWait wait) {

		loginpage = new LoginPage(driver, wait);

	}

	public LoginPage getInstanceLoginPage() {

		return loginpage;
	}

}
