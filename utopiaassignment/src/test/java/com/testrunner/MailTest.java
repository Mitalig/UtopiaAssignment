package com.testrunner;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pageobjects.HomePage;
import com.pageobjects.SearchResultPage;
import com.setup.GenericMethods;
import com.setup.Log;
import com.setup.WebSetup;

public class MailTest extends WebSetup {

	HomePage lp;
	SearchResultPage mp;
	public static String url;

	@BeforeClass
	@Parameters({ "Browser" })
	public void beforeSetup(String browser) throws Exception {

		GenericMethods.setUpLog4j();
		Log.info("Setting up the browser");

		WebSetup.setBrowser(browser);

	}

	@Test(priority = 1)
	public void homePageTest() throws Exception {
		url = GenericMethods.readProperties("url");
		lp = new HomePage(getDriver());
		lp.navigateToHomePage(url);
		lp.checkWhetherOnHomepage();
		mp=lp.searchJourney();
	}

	@Test(priority = 2)
	public void searchPageTest() {


		mp.verifyFlightDetails();
	}

	@AfterClass
	@Parameters({ "Browser" })

	public void shutDown(String browser) throws IOException {

		WebSetup.shutBrowser(browser);
	}

}
