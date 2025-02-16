package org.seleniumbase;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface ReusableComponents {

	/**
	 * this will launch the browser by default on the chrome brower.
	 * 
	 * @param url
	 * 
	 */

	void setUpChrome(String url);

	/**
	 * This will launch the the website of the given browser.
	 * 
	 * @param Browsername
	 * @param url
	 */

	void setUp(String Browsername);

	/**
	 * This will close the current window
	 */

	void close();

	/**
	 * this will close the whole driver instance.
	 */
	void quite();

	/**
	 * findType is element finds by etc... example->id,class,xpath. ElemValue param
	 * to pass the elemnt value.
	 * 
	 * @param findType
	 * @param elemValue
	 * @return
	 */

	WebElement element(Locators findType, String elemValue);

	/**
	 * pass url link to open the specific site.
	 * 
	 * @param urlLink
	 * @return
	 */

	
	void getUrl();
	
	WebDriver switchToWindow(int index);

	void url(String urlLink);

	WebDriver switchToFrameByIndex(int index);

	WebDriver switchToFrameByString(String framename);

	WebDriver switchToFrameByElement(WebElement ele);

	Alert switchToAlert();

	void click(WebElement elem);

	void sendkeys(WebElement elem, String data);

}
