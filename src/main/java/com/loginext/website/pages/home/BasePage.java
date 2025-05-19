package com.loginext.website.pages.home;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

public abstract class BasePage {
	protected Page page;

	public BasePage(Page page) {
		this.page = page;
	}

	public boolean isVisible(String selector) {
		return page.isVisible(selector);
	}

	public String getText(String locator) {
		return page.locator(locator).innerText();
	}

	public String getLinkRef(String locator) {
		return page.locator(locator).getAttribute("href");
	}

	
	public void scrollTo(String selector) {
		Locator element = page.locator(selector);
		element.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		element.scrollIntoViewIfNeeded();
	}

}
