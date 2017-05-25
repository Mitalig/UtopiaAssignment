package com.pageobjects;

import org.openqa.selenium.WebDriver;
import com.setup.ConstantLocators;
import com.setup.GenericMethods;


public class SearchResultPage {

	WebDriver driver;

	public SearchResultPage(WebDriver driver) {

		this.driver = driver;

	}

	public SearchResultPage verifyFlightDetails() {

		GenericMethods.click(driver, ConstantLocators.flightDetailsOptions);
		GenericMethods.click(driver, ConstantLocators.fareSMR);
		String baseFare=GenericMethods.getElementText(driver, ConstantLocators.baseFare);
        System.out.println("The base fare of the flight is "+baseFare);
		String fareRule=GenericMethods.getElementText(driver, ConstantLocators.fareDetails);
        System.out.println("The flight details are "+fareRule);
		GenericMethods.click(driver, ConstantLocators.crossButton);

		return this;
	}

	

}
