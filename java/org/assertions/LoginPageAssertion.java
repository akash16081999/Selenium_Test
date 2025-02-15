package org.assertions;

import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.seleniumbase.SeleniumBase;

public class LoginPageAssertion extends SeleniumBase {

	WebDriver driver;

	public LoginPageAssertion(WebDriver driver) {
		this.driver = driver;
	}

	public String getSucessFullLoginAssert() {

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
			wait.until(ExpectedConditions
					.urlToBe("https://naveenautomationlabs.com/opencart/index.php?route=account/account"));

		} catch (TimeoutException e) {

			for (int i = 1; i <= 9; i++) {

				try {
					wait.until(ExpectedConditions
							.urlToBe("https://naveenautomationlabs.com/opencart/index.php?route=account/account"));
					break;

				} catch (Exception f) {

				}

			}

		}

		return "https://naveenautomationlabs.com/opencart/index.php?route=account/account";

	}

	public String getUnsucessfullLoginAssert() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(
				ExpectedConditions.urlToBe("https://naveenautomationlabs.com/opencart/index.php?route=account/login"));

		return driver.getCurrentUrl();
	}

}
