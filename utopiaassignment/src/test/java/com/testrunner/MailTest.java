package com.testrunner;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pageobjects.LoginPage;
import com.pageobjects.MailPage;
import com.setup.GenericMethods;
import com.setup.Log;
import com.setup.WebSetup;

public class MailTest extends WebSetup {

	LoginPage lp;
	MailPage mp;
	public static String url;

	@BeforeClass
	@Parameters({ "Browser" })
	public void beforeSetup(String browser) throws Exception {

		GenericMethods.setUpLog4j();
		Log.info("Setting up the browser");

		WebSetup.setBrowser(browser);

	}

	@Test(priority = 1)
	public void signOutTest() {
		Log.info("Starting up the SignOutTest");
		url = GenericMethods.readProperties("url");
		lp = new LoginPage(getDriver());
		lp.navigateToLoginPage(url);

		mp = lp.loginIntoWebSite(GenericMethods.readProperties("userName"), GenericMethods.readProperties("password"));
	}

	@Test(priority = 2)
	public void SendEmailTest() {

		Log.info("Starting up the Send Email Test");

		mp.composeButton();
		mp.sendMail(GenericMethods.readProperties("userName"), "Hello Utopia", "Happy New Year");
	}

	@AfterClass
	@Parameters({ "Browser" })

	public void shutDown(String browser) throws IOException {

		WebSetup.shutBrowser(browser);
	}

}
