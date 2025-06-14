package com.loginext.website.factory;

import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserType.LaunchOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Properties;

public class PlaywrightFactory {

	Playwright playwright;
	Browser browser;
	BrowserContext browserContext;
	Page page;
	Properties prop;

	private static ThreadLocal<Browser> tlBrowser = new ThreadLocal<>();
	private static ThreadLocal<BrowserContext> tlBrowserContext = new ThreadLocal<>();
	private static ThreadLocal<Page> tlPage = new ThreadLocal<>();
	private static ThreadLocal<Playwright> tlPlaywright = new ThreadLocal<>();

	public static Playwright getPlaywright() {
		return tlPlaywright.get();
	}

	public static Browser getBrowser() {
		return tlBrowser.get();
	}

	public static BrowserContext getBrowserContext() {
		return tlBrowserContext.get();
	}

	public static Page getPage() {
		return tlPage.get();
	}

	public Page initBrowser(Properties prop) {

		String browserName = prop.getProperty("browser").trim();
		System.out.println("browser name is : " + browserName);

		// playwright = Playwright.create();
		tlPlaywright.set(Playwright.create());

		switch (browserName.toLowerCase()) {
		case "chromium":
			tlBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000)));
			break;
		case "firefox":
			tlBrowser.set(getPlaywright().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false)));
			break;
		case "safari":
			tlBrowser.set(getPlaywright().webkit().launch(new BrowserType.LaunchOptions().setHeadless(false)));
			break;
		case "chrome":
			tlBrowser.set(
					getPlaywright().chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false)));
			break;
		case "edge":
			tlBrowser.set(
					getPlaywright().chromium().launch(new LaunchOptions().setChannel("msedge").setHeadless(false)));
			break;

		default:
			System.out.println("please pass the right browser name......");
			break;
		}

//		tlBrowserContext.set(getBrowser().newContext());
		tlBrowserContext.set(getBrowser().newContext(new Browser.NewContextOptions().setViewportSize(1440, 675)));

		// Start tracing before creating / navigating a page.
		getBrowserContext().tracing()
				.start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true).setSources(true));

		tlPage.set(getBrowserContext().newPage());
		getPage().navigate(prop.getProperty("url").trim());
		return getPage();

	}

	public void tearDown() {
		try {
			if (getPage() != null) {
				getPage().close();
				tlPage.remove();
			}
			if (getBrowserContext() != null) {
				// Stop tracing and export it
				getBrowserContext().tracing().stop(new Tracing.StopOptions().setPath(Paths.get(
						System.getProperty("user.dir") + "/tracing/" + System.currentTimeMillis() + "_trace.zip")));
				getBrowserContext().close();
				tlBrowserContext.remove();
			}
			if (getBrowser() != null) {
				getBrowser().close();
				tlBrowser.remove();
			}
			if (getPlaywright() != null) {
				getPlaywright().close();
				tlPlaywright.remove();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * this method is used to initialize the properties from config file
	 */
	public Properties init_prop() {

		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			prop = new Properties();
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;

	}

	/**
	 * take screenshot
	 * 
	 */

	public static String takeScreenshot() {
		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		byte[] buffer = getPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
		String base64Path = Base64.getEncoder().encodeToString(buffer);

		return base64Path;
	}

}
