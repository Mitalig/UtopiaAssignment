package com.pageobjects;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.setup.ConstantLocators;
import com.setup.GenericMethods;
import com.setup.Log;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage navigateToLoginPage(String url) {

		Log.info("Navigating to Url " + url);
		GenericMethods.navigate(driver, url);

		return this;
	}

	public MailPage loginIntoWebSite(String userName, String password) {
		Log.info("Entering Email Id");
		GenericMethods.input(driver, ConstantLocators.emailField, userName);
		Log.info("Clicking on Next button");
		GenericMethods.click(driver, ConstantLocators.nextButton);
		Log.info("Entering Password");
		GenericMethods.input(driver, ConstantLocators.passwordField, password);
		Log.info("Clicking on SignIn button");
		GenericMethods.click(driver, ConstantLocators.signInButton);
		Log.info("Clicking on Circular button");
		GenericMethods.click(driver, ConstantLocators.circularButton);
		Log.info("Checking whether Sign out button is present");
		assertThat(GenericMethods.getElementText(driver, ConstantLocators.signOutButton), is("Sign out"));
		GenericMethods.click(driver, ConstantLocators.circularButton);

		return new MailPage(driver);
	}

}
