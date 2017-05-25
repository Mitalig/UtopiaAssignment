package com.pageobjects;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.setup.ConstantLocators;
import com.setup.ExcelUtils;
import com.setup.GenericMethods;
import com.setup.Log;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public HomePage navigateToHomePage(String url) {

		Log.info("Navigating to Url " + url);
		GenericMethods.navigate(driver, url);

		return this;
	}

	public HomePage checkWhetherOnHomepage() {
		Log.info("Checking whether on Home pAGE");
		Assert.assertEquals(driver.findElement(By.xpath(ConstantLocators.yatraOption)).isDisplayed(), true);
		return this;

		//return new MailPage(driver);
	}
	
	public SearchResultPage searchJourney() throws Exception  {
		
		ExcelUtils.
		setExcelFile
		("/Users/ashwin/work/learning/UtopiaAssignment/utopiaassignment/resources/Log4jConfiguration/DataEngineWeb.xlsx");
		String origin=ExcelUtils.getCellData(0, 0, "Data");
		String destination=ExcelUtils.getCellData(0, 1, "Data");
		GenericMethods.input(driver, ConstantLocators.origin, origin);
        GenericMethods.click(driver, ConstantLocators.originOver);
		GenericMethods.input(driver, ConstantLocators.destination, destination);
        GenericMethods.click(driver, ConstantLocators.originOver);
        GenericMethods.click(driver, ConstantLocators.departureDate);
        GenericMethods.click(driver, ConstantLocators.departDate);
        GenericMethods.click(driver, ConstantLocators.searchButton);
		
        return new SearchResultPage(driver);
	}

}
