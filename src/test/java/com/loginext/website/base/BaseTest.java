package com.loginext.website.base;

import com.loginext.website.factory.PlaywrightFactory;
import com.loginext.website.pages.home.HomePage;
import com.microsoft.playwright.Page;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.Properties;

public class BaseTest {

	PlaywrightFactory pf;
	Page page;
	protected Properties prop;

	protected HomePage homePage;

	@Parameters({ "browser" })
	@BeforeTest
	public void setup(@Optional("chromium") String browserName) {
		pf = new PlaywrightFactory();

		prop = pf.init_prop();

		if (browserName != null) {
			prop.setProperty("browser", browserName);
		}

		page = pf.initBrowser(prop);
		homePage = new HomePage(page);
	}

	@AfterTest
	public void tearDown() {
		pf.tearDown();

//		page.context().browser().close();
//		
//		// Stop tracing and export it into a zip archive.
//		page.context().tracing().stop(new Tracing.StopOptions()
//		  .setPath(Paths.get("trace.zip")));
	}

}
