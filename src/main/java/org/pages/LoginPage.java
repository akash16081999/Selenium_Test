package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.seleniumbase.Base;
import org.seleniumbase.Locators;

public class LoginPage extends Base {

	// public WebDriver driver;

	/* Login page locators */

	public LoginPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		
	}

	public LoginPage enterUserEmail(String user_name) {

		element(Locators.name, "email").sendKeys(user_name);
		// driver.findElement(By.name("username")).sendKeys(user_name);
		return this;

	}

	public LoginPage enterPassword(String password) {
		element(Locators.name, "password").sendKeys(password);

		// driver.findElement(By.name("password")).sendKeys(password);
		return this;

	}

	public Dashboard clickLogin() {

		click(element(Locators.xpath, "//input[@type='submit']"));
		  
		
		
		// driver.findElement(By.className("submit")).click();
		return new Dashboard();
	}

	public LoginPage checkRememberMe() {
		driver.findElement(By.id("rememberme")).click();
		return this;
	}

	public void logintoDashboard(String user_name, String password) {
		enterPassword(user_name);
		enterUserEmail(user_name);
		clickLogin();
	}

}
