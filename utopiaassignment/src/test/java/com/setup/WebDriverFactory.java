package com.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

	static WebDriver create(String browser) throws IllegalAccessException {

		try {
			WebDriver driver;

			switch (browser) {
			case "Firefox":

				driver = new FirefoxDriver();

				break;

			case "Chrome":

				driver = new ChromeDriver();
				driver.manage().window().maximize();

				break;

			default:
				throw new IllegalAccessException();

			}

			return driver;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;

	}
}
