package com.setup;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericMethods {

	private static Properties prop;

	public static void navigate(WebDriver driver, String url) {

		System.out.println(url);
		driver.navigate().to(url);

	}

	public static String readProperties(String Constant) {
		try {
			prop = new Properties();
			FileReader fr;

			fr = new FileReader(
					"/Users/ashwin/work/learning/UtopiaAssignment/utopiaassignment/resources/Constants.properties");
			prop.load(fr);
			String constantValue = prop.getProperty(Constant);

			return constantValue;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			Log.info("Failed to read properties file " + e.getMessage());

		}
		return null;

	}

	public static void click(WebDriver driver, String sLocator) {
		waitToClickMethod(driver, sLocator);
		driver.findElement(By.xpath(sLocator)).click();
	}

	public static void input(WebDriver driver, String sLocator, String inputValue) {
		waitMethod(driver, sLocator);
		driver.findElement(By.xpath(sLocator)).sendKeys(inputValue);
	}

	public static String getElementText(WebDriver driver, String sLocator) {
		waitMethod(driver, sLocator);
		String elementText = driver.findElement(By.xpath(sLocator)).getText();
		return elementText;
	}

	public static void waitMethod(WebDriver driver, String sLocators) {

		WebDriverWait wait = new WebDriverWait(driver, 260);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sLocators)));

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sLocators)));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(sLocators)));

	}

	public static void waitVisibilityMethod(WebDriver driver, String sLocators) {

		WebDriverWait wait = new WebDriverWait(driver, 260);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sLocators)));

		// wait.until (ExpectedConditions.presenceOfElementLocated (By.xpath
		// (sLocators)));

	}

	public static void waitToClickMethod(WebDriver driver, String sLocators) {

		WebDriverWait wait = new WebDriverWait(driver, 260);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sLocators)));

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sLocators)));

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(sLocators)));

	}

	public static void waitFor(int time) {

		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}


	public static void setUpLog4j() throws Exception {

		Properties po1 = new Properties();
		FileInputStream configStream1 = new FileInputStream(
				"/Users/ashwin/work/learning/UtopiaAssignment/utopiaassignment/resources/Log4jConfiguration/log4j.properties");
		po1.load(configStream1);
		PropertyConfigurator.configure(
				"/Users/ashwin/work/learning/UtopiaAssignment/utopiaassignment/resources/Log4jConfiguration/log4j.properties");
	}

}
