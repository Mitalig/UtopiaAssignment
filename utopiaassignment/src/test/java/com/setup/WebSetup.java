package com.setup;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

public class WebSetup {

	public static ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();

	public static void setBrowser(String browser) throws Exception {

		if (browser.equalsIgnoreCase("Firefox")) {
			WebDriver driver = new WebDriverFactory().create(browser);
			setWebDriver(driver);

		} else if (browser.equalsIgnoreCase("Chrome")) {

			System.setProperty("webdriver.chrome.driver", "resources/Log4jConfiguration/chromedriver");
			WebDriver driver = new WebDriverFactory().create(browser);

			setWebDriver(driver);

		}

	}

	public static void setWebDriver(WebDriver driver) {
		dr.set(driver);
	}

	public static WebDriver getDriver()

	{
		return dr.get();
	}

	public static void shutBrowser(String browser) {
		WebDriver driver = getDriver();

		driver.quit();

	}

}
