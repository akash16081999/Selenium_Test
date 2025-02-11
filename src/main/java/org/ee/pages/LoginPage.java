package org.ee.pages;

import org.ee.seleniumbase.Base;
import org.ee.seleniumbase.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends Base {

	// public WebDriver driver;

	/* Login page locators */

	public LoginPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		
	}

	public LoginPage enterUserName(String user_name) {

		element(Locators.name, "username").sendKeys(user_name);
		// driver.findElement(By.name("username")).sendKeys(user_name);
		return this;

	}

	public LoginPage enterPassword(String password) {
		element(Locators.name, "password").sendKeys(password);

		// driver.findElement(By.name("password")).sendKeys(password);
		return this;

	}

	public Dashboard clickLogin() {

		click(element(Locators.classname, "submit"));
		// driver.findElement(By.className("submit")).click();
		return new Dashboard();
	}

	public LoginPage checkRememberMe() {
		driver.findElement(By.id("rememberme")).click();
		return this;
	}

	public void logintoDashboard(String user_name, String password) {
		enterPassword(user_name);
		enterUserName(user_name);
		clickLogin();
	}

}
