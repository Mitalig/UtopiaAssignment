package com.pageobjects;

import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.WebDriver;
import com.setup.ConstantLocators;
import com.setup.GenericMethods;
import com.setup.Log;

import static org.hamcrest.MatcherAssert.assertThat;

public class MailPage {

	WebDriver driver;

	public MailPage(WebDriver driver) {

		this.driver = driver;

	}

	public MailPage composeButton() {

		Log.info("Checking whether Compose button is present");
		assertThat(GenericMethods.getElementText(driver, ConstantLocators.composeButton), is("COMPOSE"));

		return this;
	}

	public MailPage sendMail(String email, String Subject, String body) {

		Log.info("Clicking on Compose button");
		GenericMethods.click(driver, ConstantLocators.composeButton);
		GenericMethods.click(driver, ConstantLocators.recepientField);
		Log.info("Entering Email id");
		GenericMethods.input(driver, ConstantLocators.recepientField, email);
		GenericMethods.click(driver, ConstantLocators.inbox);
		GenericMethods.click(driver, ConstantLocators.subjectField);
		Log.info("Entering Subject");
		GenericMethods.input(driver, ConstantLocators.subjectField, Subject);
		GenericMethods.waitFor(5000);
		GenericMethods.click(driver, ConstantLocators.bodyTextBox);
		Log.info("Entering Message");
		GenericMethods.input(driver, ConstantLocators.bodyTextBox, body);
		Log.info("Clicking on Send Button");
		GenericMethods.click(driver, ConstantLocators.sendButton);
		GenericMethods.click(driver, ConstantLocators.viewMessage);
		Log.info("Checking whether email is send");
		assertThat(GenericMethods.getElementText(driver, ConstantLocators.emailPresent), is("Hello Utopia"));

		return this;

	}

}
