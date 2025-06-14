package com.loginext.website.tests;

import com.loginext.website.base.BaseTest;
import com.loginext.website.components.home.*;
import com.loginext.website.constants.HomePageConstants;
import com.loginext.website.constants.HomePageConstants.*;
import com.microsoft.playwright.Page;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.util.List;

public class HomePageTest extends BaseTest {

	final boolean enableAllTest = false;
	final boolean enableSignupTest = false;

	@Test
	public void verifyHomePageTitle_ShouldMatchExpectedTitle() {
		Assert.assertEquals(homePage.getHomePageTitle(), HomePageConstants.HOME_PAGE_TITLE);
	}

	@Test
	public void verifyHomePageUrl_ShouldMatchExpectedUrl() {
		verifyPageURL(homePage.getPageURL(), prop.getProperty("url") + File.separator);
	}

	@Test(priority = 1, enabled = enableAllTest)
	public void verifyPageStructure() {
		SoftAssert softAssert = new SoftAssert();

		softAssert.assertTrue(homePage.isLogoVisible(), "Logo does not exist!");
		softAssert.assertTrue(homePage.isNavigationMenuVisible(), "Navigation menu does not exist!");
		softAssert.assertTrue(homePage.isLoginLinkVisible(), "Login link does not exist!");
		softAssert.assertTrue(homePage.isSignupLinkVisible(), "Signup link does not exist!");
		softAssert.assertTrue(homePage.isScheduleDemoLinkVisible(), "Schedule Demo link does not exist!");

//		softAssert.assertTrue(homePage.isHomeSection1Title1Visible(), "Section 1 title 1 not visible!");
//		softAssert.assertTrue(homePage.isHomeSection1Title2Visible(), "Section 1 title 2 not visible!");
//		softAssert.assertTrue(homePage.isHomeSection1DescVisible(), "Section 1 description not visible!");
		softAssert.assertTrue(homePage.isHomeSection1ScheduleDemoButtonVisible(), "Section 1 Schedule Demo button missing!");
		softAssert.assertTrue(homePage.isHomeSection1SignUpButtonVisible(), "Section 1 Signup button missing!");

		softAssert.assertTrue(homePage.isHomeSection2TitleVisible(), "Section 2 title not visible!");
		softAssert.assertTrue(homePage.isHomeSection2BrandListVisible(), "Section 2 brand list not visible!");

		softAssert.assertTrue(homePage.isHomeSection3Visible(), "Section 3 not visible!");
		softAssert.assertTrue(homePage.isHomeSection4Visible(), "Section 4 not visible!");
		softAssert.assertTrue(homePage.isHomeSection5Visible(), "Section 5 not visible!");

		softAssert.assertAll();
	}

	@Test(priority = 2, enabled = false)
	public void verifyHomePageSection1_Content() {
		Assert.assertEquals(homePage.getSection1Title1Text(), HomePageConstants.HOME_PAGE_SECTION_1_TITLE_1);
		Assert.assertEquals(homePage.getSection1Title2Text(), HomePageConstants.HOME_PAGE_SECTION_1_TITLE_2);
		Assert.assertEquals(homePage.getSection1DescText(), HomePageConstants.HOME_PAGE_SECTION_1_DESC);
	}

	@Test(priority = 3, enabled = enableAllTest)
	public void verifyHomePageSection2_Content() {
		Assert.assertEquals(homePage.getSection2TitleText(), HomePageConstants.HOME_PAGE_SECTION_2_TITLE_1);

		List<String> actualBrandNames = homePage.getSection2BrandAltTexts();
		String[] expectedBrandNames = HomePageConstants.HOME_PAGE_SECTION_2_BRANDS;

		SoftAssert softAssert = new SoftAssert();
		for (int i = 0; i < expectedBrandNames.length; i++) {
			softAssert.assertEquals(actualBrandNames.get(i), expectedBrandNames[i], "Brand : " + (i + 1) + " is not matched!");
		}
		softAssert.assertAll();
	}

	@Test(priority = 4, enabled = enableAllTest)
	public void verifyHomePageSection4_Content() {
		List<ReviewData> actualReviews = homePage.getSection4Reviews();
		Review[] expectedReviews = HomePageConstants.HOME_PAGE_SECTION_4_REVIEWS;

		SoftAssert softAssert = new SoftAssert();
		for (int i = 0; i < expectedReviews.length; i++) {
			Review expected = expectedReviews[i];
			ReviewData actual = actualReviews.get(i);

			softAssert.assertEquals(actual.getLink(), expected.link(), "Review link mismatch at " + (i + 1));
			softAssert.assertEquals(actual.getHeader(), expected.header(), "Review header mismatch at " + (i + 1));
			softAssert.assertEquals(actual.getProfile(), expected.profile(), "Review profile mismatch at " + (i + 1));
		}
		softAssert.assertAll();
	}

	@Test(priority = 5, enabled = enableAllTest)
	public void verifyHomePageSection5_Content() {
		List<ReviewData> section5Reviews = homePage.getSection5Reviews();

		SoftAssert softAssert = new SoftAssert();
		for (int i = 0; i < section5Reviews.size(); i++) {
			ReviewData review = section5Reviews.get(i);
			softAssert.assertEquals(review.getLink(), HomePageConstants.HOME_PAGE_SECTION_5_LINK, "Section 5 link mismatch at " + (i + 1));
			softAssert.assertEquals(review.getProfile(), HomePageConstants.HOME_PAGE_SECTION_5_LINK_DESC, "Section 5 profile text mismatch at " + (i + 1));
		}
		softAssert.assertAll();
	}

	@Test(priority = 6, enabled = enableAllTest)
	public void verifyHomePageSection6_Content() {
		Assert.assertEquals(homePage.getSection6VideoLink(), HomePageConstants.HOME_PAGE_SECTION_6_VIDEO_LINK);
		Assert.assertEquals(homePage.getSection6TitleText(), HomePageConstants.HOME_PAGE_SECTION_6_TITLE);
		Assert.assertEquals(homePage.getSection6Desc1Text(), HomePageConstants.HOME_PAGE_SECTION_6_DESC_1);
		Assert.assertEquals(homePage.getSection6Desc2Text(), HomePageConstants.HOME_PAGE_SECTION_6_DESC_2);
		Assert.assertEquals(homePage.getSection6VideoTitleText(), HomePageConstants.HOME_PAGE_SECTION_6_VIDEO_TITLE);
		Assert.assertEquals(homePage.getSection6VideoButtonTitleText(), HomePageConstants.HOME_PAGE_SECTION_6_VIDEO_BUTTON_TITLE);
	}

	@Test(priority = 7, enabled = enableAllTest)
	public void verifyHomePageSection7_Content() {
		Assert.assertEquals(homePage.getSection7TitleText(), HomePageConstants.HOME_PAGE_SECTION_7_TITLE);

		List<WhyLoginextCardData> actualWhyLoginextCards = homePage.getSection7WhyLoginextCards();
		WhyLoginextCard[] expectedWhyLoginextCardDatas = HomePageConstants.HOME_PAGE_SECTION_7_WHY_LOGINEXT_CARDS;

		SoftAssert softAssert = new SoftAssert();
		for (int i = 0; i < expectedWhyLoginextCardDatas.length; i++) {
			WhyLoginextCard expected = expectedWhyLoginextCardDatas[i];
			WhyLoginextCardData actual = actualWhyLoginextCards.get(i);

			softAssert.assertEquals(actual.getLink(), expected.link(), "Why Loginext Card link mismatch at " + (i + 1));
			softAssert.assertEquals(actual.getTitle(), expected.title(), "Why Loginext Card title mismatch at " + (i + 1));
			softAssert.assertEquals(actual.getDescription(), expected.description(), "Why Loginext Card description mismatch at " + (i + 1));
		}
		softAssert.assertAll();
	}

	@Test(priority = 8, enabled = enableAllTest)
	public void verifyHomePageSection8_Content() {
		Assert.assertEquals(homePage.getSection8TitleText(), HomePageConstants.HOME_PAGE_SECTION_8_TITLE);

		List<IndustryWeServeData> actualIndustryWeServe = homePage.getSection8IndustriesWeServe();
		IndustryWeServe[] expectedIndustryWeServe = HomePageConstants.HOME_PAGE_SECTION_8_INDUSTRIES_WE_SERVE;

		SoftAssert softAssert = new SoftAssert();
		for (int i = 0; i < expectedIndustryWeServe.length; i++) {
			IndustryWeServe expected = expectedIndustryWeServe[i];
			IndustryWeServeData actual = actualIndustryWeServe.get(i);

			softAssert.assertEquals(actual.getTabTitle(), expected.tabTitle(), "Industry We Serve Card tab title mismatch at " + (i + 1));
			softAssert.assertEquals(actual.getImageText(), expected.imageText(), "Industry We Serve Card tab image text mismatch at " + (i + 1));
			softAssert.assertEquals(actual.getImageTitle(), expected.imageTitle(), "Industry We Serve Card tab image title mismatch at " + (i + 1));
			softAssert.assertEquals(actual.getImageDescription(), expected.imageDescription(), "Industry We Serve Card tab image description mismatch at " + (i + 1));

			softAssert.assertEquals(actual.getTabButton1Text(), expected.tabButton1Text(), "Industry We Serve Card tab button 1 text mismatch at " + (i + 1));
			softAssert.assertEquals(actual.getTabButton1Link(), expected.tabButton1Link(), "Industry We Serve Card tab button 1 link mismatch at " + (i + 1));

			softAssert.assertEquals(actual.getTabButton2Text(), expected.tabButton2Text(), "Industry We Serve Card tab button 2 text mismatch at " + (i + 1));
			softAssert.assertEquals(actual.getTabButton2Link(), expected.tabButton2Link(), "Industry We Serve Card tab button 2 link mismatch at " + (i + 1));

			softAssert.assertEquals(actual.getTabBox1Title(), expected.tabBox1Title(), "Industry We Serve Card tab box 1 title mismatch at " + (i + 1));
			softAssert.assertEquals(actual.getTabBox2Title(), expected.tabBox2Title(), "Industry We Serve Card tab box 2 title mismatch at " + (i + 1));
			softAssert.assertEquals(actual.getTabBox3Title(), expected.tabBox3Title(), "Industry We Serve Card tab box 3 title mismatch at " + (i + 1));
			softAssert.assertEquals(actual.getTabBox4Title(), expected.tabBox4Title(), "Industry We Serve Card tab box 4 title mismatch at " + (i + 1));
			softAssert.assertEquals(actual.getTabBox5Title(), expected.tabBox5Title(), "Industry We Serve Card tab box 5 title mismatch at " + (i + 1));
			softAssert.assertEquals(actual.getTabBox6Title(), expected.tabBox6Title(), "Industry We Serve Card tab box 6 title mismatch at " + (i + 1));

		}
		softAssert.assertAll();
	}

	@Test(priority = 9, enabled = enableAllTest)
	public void verifyHomePageSection9_Content() {
		SoftAssert softAssert = new SoftAssert();

		softAssert.assertEquals(homePage.getHomeSection9Title(), HomePageConstants.HOME_PAGE_SECTION_9_TITLE);
		softAssert.assertEquals(homePage.getHomeSection9Desc(), HomePageConstants.HOME_PAGE_SECTION_9_DESC);
		softAssert.assertEquals(homePage.getHomeSection9ButtonText(), HomePageConstants.HOME_PAGE_SECTION_9_BUTTON_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9ButtonLink(), HomePageConstants.HOME_PAGE_SECTION_9_BUTTON_LINK);

		softAssert.assertEquals(homePage.getHomeSection9CardmainImageText(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_Main_IMAGE_TEXT);

		softAssert.assertEquals(homePage.getHomeSection9Card1ImageText(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_1_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card1ImageLink(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_1_IMAGE_LINK);

		softAssert.assertEquals(homePage.getHomeSection9Card1Image1Text(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_1_1_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card1Image1Link(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_1_1_IMAGE_LINK);
		softAssert.assertEquals(homePage.getHomeSection9Card1Image2Text(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_1_2_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card1Image2Link(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_1_2_IMAGE_LINK);
		softAssert.assertEquals(homePage.getHomeSection9Card1Image3Text(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_1_3_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card1Image3Link(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_1_3_IMAGE_LINK);

		softAssert.assertEquals(homePage.getHomeSection9Card7ImageText(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_7_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card7ImageLink(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_7_IMAGE_LINK);

		softAssert.assertEquals(homePage.getHomeSection9Card7Image1Text(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_7_1_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card7Image1Link(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_7_1_IMAGE_LINK);
		softAssert.assertEquals(homePage.getHomeSection9Card7Image2Text(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_7_2_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card7Image2Link(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_7_2_IMAGE_LINK);

		softAssert.assertEquals(homePage.getHomeSection9Card3ImageText(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_3_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card3ImageLink(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_3_IMAGE_LINK);

		softAssert.assertEquals(homePage.getHomeSection9Card2ImageText(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_2_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card2ImageLink(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_2_IMAGE_LINK);

		softAssert.assertEquals(homePage.getHomeSection9Card2Image1Text(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_2_1_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card2Image1Link(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_2_1_IMAGE_LINK);
		softAssert.assertEquals(homePage.getHomeSection9Card2Image2Text(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_2_2_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card2Image2Link(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_2_2_IMAGE_LINK);

		softAssert.assertEquals(homePage.getHomeSection9Card5ImageText(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_5_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card5ImageLink(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_5_IMAGE_LINK);

		softAssert.assertEquals(homePage.getHomeSection9Card5Image1Text(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_5_1_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card5Image1Link(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_5_1_IMAGE_LINK);

		softAssert.assertEquals(homePage.getHomeSection9Card6ImageText(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_6_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card6ImageLink(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_6_IMAGE_LINK);

		softAssert.assertEquals(homePage.getHomeSection9Card6Image1Text(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_6_1_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card6Image1Link(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_6_1_IMAGE_LINK);
		softAssert.assertEquals(homePage.getHomeSection9Card6Image2Text(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_6_2_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card6Image2Link(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_6_2_IMAGE_LINK);

		softAssert.assertEquals(homePage.getHomeSection9Card8ImageText(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_8_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card8ImageLink(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_8_IMAGE_LINK);

		softAssert.assertEquals(homePage.getHomeSection9Card8Image1Text(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_8_1_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card8Image1Link(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_8_1_IMAGE_LINK);
		softAssert.assertEquals(homePage.getHomeSection9Card8Image2Text(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_8_2_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card8Image2Link(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_8_2_IMAGE_LINK);
		softAssert.assertEquals(homePage.getHomeSection9Card8Image3Text(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_8_3_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card8Image3Link(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_8_3_IMAGE_LINK);
		softAssert.assertEquals(homePage.getHomeSection9Card8Image4Text(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_8_4_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card8Image4Link(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_8_4_IMAGE_LINK);
		softAssert.assertEquals(homePage.getHomeSection9Card8Image5Text(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_8_5_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card8Image5Link(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_8_5_IMAGE_LINK);

		softAssert.assertEquals(homePage.getHomeSection9Card3Image1Text(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_3_1_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card3Image1Link(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_3_1_IMAGE_LINK);
		softAssert.assertEquals(homePage.getHomeSection9Card3Image2Text(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_3_2_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card3Image2Link(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_3_2_IMAGE_LINK);
		softAssert.assertEquals(homePage.getHomeSection9Card3Image3Text(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_3_3_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card3Image3Link(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_3_3_IMAGE_LINK);
		softAssert.assertEquals(homePage.getHomeSection9Card3Image4Text(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_3_4_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card3Image4Link(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_3_4_IMAGE_LINK);
		softAssert.assertEquals(homePage.getHomeSection9Card3Image5Text(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_3_5_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card3Image5Link(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_3_5_IMAGE_LINK);

		softAssert.assertEquals(homePage.getHomeSection9Card4Image4Text(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_4_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card4Image4Link(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_4_IMAGE_LINK);

		softAssert.assertEquals(homePage.getHomeSection9Card4Image1Text(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_4_1_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card4Image1Link(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_4_1_IMAGE_LINK);
		softAssert.assertEquals(homePage.getHomeSection9Card4Image2Text(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_4_2_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card4Image2Link(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_4_2_IMAGE_LINK);
		softAssert.assertEquals(homePage.getHomeSection9Card4Image3Text(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_4_3_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card4Image3Link(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_4_3_IMAGE_LINK);
		softAssert.assertEquals(homePage.getHomeSection9Card4Image4Text(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_4_4_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card4Image4Link(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_4_4_IMAGE_LINK);

		softAssert.assertEquals(homePage.getHomeSection9Card9ImageText(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_9_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card9ImageLink(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_9_IMAGE_LINK);

		softAssert.assertEquals(homePage.getHomeSection9Card9Image1Text(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_9_1_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card9Image1Link(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_9_1_IMAGE_LINK);
		softAssert.assertEquals(homePage.getHomeSection9Card9Image2Text(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_9_2_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card9Image2Link(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_9_2_IMAGE_LINK);

		softAssert.assertEquals(homePage.getHomeSection9Card10ImageText(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_10_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card10ImageLink(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_10_IMAGE_LINK);

		softAssert.assertEquals(homePage.getHomeSection9Card10Image1Text(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_10_1_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card10Image1Link(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_10_1_IMAGE_LINK);
		softAssert.assertEquals(homePage.getHomeSection9Card10Image2Text(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_10_2_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card10Image2Link(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_10_2_IMAGE_LINK);
		softAssert.assertEquals(homePage.getHomeSection9Card10Image3Text(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_10_3_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card10Image3Link(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_10_3_IMAGE_LINK);

		softAssert.assertEquals(homePage.getHomeSection9Card11ImageText(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_11_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card11ImageLink(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_11_IMAGE_LINK);

		softAssert.assertEquals(homePage.getHomeSection9Card11Image1Text(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_11_1_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card11Image1Link(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_11_1_IMAGE_LINK);
		softAssert.assertEquals(homePage.getHomeSection9Card11Image2Text(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_11_2_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card11Image2Link(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_11_2_IMAGE_LINK);
		softAssert.assertEquals(homePage.getHomeSection9Card11Image3Text(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_11_3_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card11Image3Link(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_11_3_IMAGE_LINK);
		softAssert.assertEquals(homePage.getHomeSection9Card11Image4Text(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_11_4_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card11Image4Link(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_11_4_IMAGE_LINK);

		softAssert.assertEquals(homePage.getHomeSection9Card11Image6Text(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_11_6_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card11Image6Link(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_11_6_IMAGE_LINK);

		softAssert.assertEquals(homePage.getHomeSection9Card11Image5Text(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_11_5_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card11Image5Link(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_11_5_IMAGE_LINK);

		softAssert.assertEquals(homePage.getHomeSection9Card12ImageText(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_12_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card12ImageLink(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_12_IMAGE_LINK);

		softAssert.assertEquals(homePage.getHomeSection9Card12Image1Text(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_12_1_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card12Image1Link(), HomePageConstants.HOME_PAGE_SECTION_9_CARD_12_1_IMAGE_LINK);

		softAssert.assertAll();
	}

	@Test(priority = 10, enabled = enableAllTest)
	public void verifyHomePageSection10_Content() {
		SoftAssert softAssert = new SoftAssert();

		softAssert.assertEquals(homePage.getHomeSection10Button1Text(), HomePageConstants.HOME_PAGE_SECTION_10_BUTTON_1_TITLE);
		softAssert.assertEquals(homePage.getHomeSection10Button2Text(), HomePageConstants.HOME_PAGE_SECTION_10_BUTTON_2_TITLE);
		softAssert.assertAll();
	}

	@Test(priority = 11, enabled = enableAllTest)
	public void verifyHomePageSection11_Content() {

		List<AwardData> actualAwards = homePage.getSection11Awards();
		Award[] expectedAwards = HomePageConstants.HOME_PAGE_SECTION_11_AWARDS;

		SoftAssert softAssert = new SoftAssert();
		for (int i = 0; i < expectedAwards.length; i++) {
			Award expected = expectedAwards[i];
			AwardData actual = actualAwards.get(i);

			softAssert.assertEquals(actual.getLink(), expected.link(), "Award link mismatch at " + (i + 1));
			softAssert.assertEquals(actual.getText(), expected.text(), "Award text mismatch at " + (i + 1));
		}
		softAssert.assertAll();
	}

	@Test(priority = 12, enabled = enableAllTest)
	public void verifyHomeLoginLink() {
		Page newTab = homePage.clickLoginLinkAndReturnNewTab(); // Opens new tab
		newTab.waitForLoadState();
		Assert.assertEquals(newTab.url(), "https://products.loginextsolutions.com/login", "Login link did not open correct URL");
		newTab.close(); // Close the new tab
	}

	@Test(priority = 13, enabled = enableSignupTest)
	public void verifySignUpPage_Content() {
		Assert.assertTrue(homePage.clickSignupAndVerifyPopupCloseButton(), "Close button did not appear in signup popup!");

		List<SignUpCardData> actualSignUpCards = homePage.getSignUpCards();
		SignUpCard[] expectedSignUpCards = HomePageConstants.SIGN_UP_CARDS;

		SoftAssert softAssert = new SoftAssert();
		for (int i = 0; i < expectedSignUpCards.length; i++) {
			SignUpCard expected = expectedSignUpCards[i];
			SignUpCardData actual = actualSignUpCards.get(i);

			softAssert.assertEquals(actual.getCompany(), expected.company(), "Sign up company mismatch at card " + (i + 1));
			softAssert.assertEquals(actual.getTitle(), expected.title(), "Sign up title mismatch at card " + (i + 1));
			softAssert.assertEquals(actual.getCompanyDesc(), expected.companyDesc(), "Sign up company descnmismatch at card " + (i + 1));
			softAssert.assertEquals(actual.getButton1_text(), expected.button1_text(), "Sign up button1 text mismatch at card " + (i + 1));
			softAssert.assertEquals(actual.getButton2_text(), expected.button2_text(), "Sign up button2 text mismatch at card " + (i + 1));
			softAssert.assertEquals(actual.getImage_text(), expected.image_text(), "Sign up image text mismatch at card " + (i + 1));
			softAssert.assertEquals(actual.getImage_link(), expected.image_link(), "Sign up image link mismatch at card " + (i + 1));
		}
		softAssert.assertAll();
		homePage.clickSignupClose();
	}

	@Test(priority = 14, enabled = enableSignupTest)
	public void verifySignUpPage_StartFreeTrial_Pricing_Buttons() throws InterruptedException {

		String signUpUrl = prop.getProperty("url") + "/pricing/signup";
		String pricingUrl = prop.getProperty("url") + "/pricing";

		Assert.assertTrue(homePage.clickSignupAndVerifyPopupCloseButton(), "Close button did not appear in signup popup!");
		Assert.assertEquals(homePage.clickMileStartFreeTrial(signUpUrl), signUpUrl, "Mile Start Free Trial Button not working !");

		Assert.assertTrue(homePage.clickSignupAndVerifyPopupCloseButton(), "Close button did not appear in signup popup!");
		Assert.assertEquals(homePage.clickMilePricing(pricingUrl), pricingUrl, "Mile Pricing Button not working !");

		Assert.assertTrue(homePage.clickSignupAndVerifyPopupCloseButton(), "Close button did not appear in signup popup!");
		Assert.assertEquals(homePage.clickReverseStartFreeTrial(signUpUrl), signUpUrl, "Reverse Start Free Trial Button not working !");

		Assert.assertTrue(homePage.clickSignupAndVerifyPopupCloseButton(), "Close button did not appear in signup popup!");
		Assert.assertEquals(homePage.clickReversePricing(pricingUrl), pricingUrl, "Reverse Pricing Button not working !");

		Assert.assertTrue(homePage.clickSignupAndVerifyPopupCloseButton(), "Close button did not appear in signup popup!");
		Assert.assertEquals(homePage.clickOnDemandStartFreeTrial(signUpUrl), signUpUrl, "On Demand Start Free Trial Button not working !");

		Assert.assertTrue(homePage.clickSignupAndVerifyPopupCloseButton(), "Close button did not appear in signup popup!");
		Assert.assertEquals(homePage.clickOnDemandPricing(pricingUrl), pricingUrl, "On Demand Pricing Button not working !");

		Assert.assertTrue(homePage.clickSignupAndVerifyPopupCloseButton(), "Close button did not appear in signup popup!");
		Assert.assertEquals(homePage.clickHaulStartFreeTrial(signUpUrl), signUpUrl, "Haul Start Free Trial Button not working !");

		Assert.assertTrue(homePage.clickSignupAndVerifyPopupCloseButton(), "Close button did not appear in signup popup!");
		Assert.assertEquals(homePage.clickHaulPricing(pricingUrl), pricingUrl, "Haul Pricing Button not working !");
	}

	@Test(priority = 15, enabled = enableAllTest)
	public void verifyFooterMenuNavigation() {
		String expectedUrl = prop.getProperty("url") + "/platform";
		String actualURL = homePage.navigateToFooter("products", "platform", expectedUrl);
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/platform/mile";
		actualURL = homePage.navigateToFooter("products", "LogiNext Mile", expectedUrl);
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/platform/reverse";
		actualURL = homePage.navigateToFooter("products", "LogiNext Reverse", expectedUrl);
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/platform/on-demand";
		actualURL = homePage.navigateToFooter("products", "LogiNext On-Demand", expectedUrl);
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/platform/haul";
		actualURL = homePage.navigateToFooter("products", "LogiNext Haul", expectedUrl);
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/platform/driver-app";
		actualURL = homePage.navigateToFooter("products", "LogiNext Driver app", expectedUrl);
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/industries/couriers-express-parcels";
		actualURL = homePage.navigateToFooter("industries", "Courier, Express and Parcel", expectedUrl);
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/industries/retail-and-ecommerce";
		actualURL = homePage.navigateToFooter("industries", "Retail and eCommerce", expectedUrl);
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/industries/consumer-package";
		actualURL = homePage.navigateToFooter("industries", "Consumer Packaged Goods", expectedUrl);
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/industries/food-and-beverages";
		actualURL = homePage.navigateToFooter("industries", "Food and Beverage", expectedUrl);
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/industries/transportation-software";
		actualURL = homePage.navigateToFooter("industries", "Transportation and Logistics", expectedUrl);
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/usecase/pickup";
		actualURL = homePage.navigateToFooter("usecase", "Pickup", expectedUrl);
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/usecase/delivery";
		actualURL = homePage.navigateToFooter("usecase", "Delivery", expectedUrl);
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/usecase/pickup-delivery";
		actualURL = homePage.navigateToFooter("usecase", "Pickup and Delivery", expectedUrl);
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/usecase/line-haul";
		actualURL = homePage.navigateToFooter("usecase", "Line Haul", expectedUrl);
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/usecase/end-to-end";
		actualURL = homePage.navigateToFooter("usecase", "End to End", expectedUrl);
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/resource/casestudy";
		actualURL = homePage.navigateToFooter("resource", "Case Studies", expectedUrl);
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/resource/whitepaper";
		actualURL = homePage.navigateToFooter("resource", "White Papers", expectedUrl);
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/resource/infographic";
		actualURL = homePage.navigateToFooter("resource", "Infographics", expectedUrl);
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/resource/carbonemission";
		actualURL = homePage.navigateToFooter("resource", "Carbon Emission Calculator", expectedUrl);
		verifyPageURL(actualURL, expectedUrl);

//		expectedUrl = prop.getProperty("url") + "/join-us/culture";
//		actualURL = homePage.navigateToFooter("join-us", "Company Culture", expectedUrl);
//		verifyPageURL(actualURL, expectedUrl);
//		homePage.navigateBack();

//		expectedUrl = prop.getProperty("url") + "/join-us/interview-process";
//		actualURL = homePage.navigateToFooter("join-us", "Interview Process", expectedUrl);
//		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = "https://loginext.hire.trakstar.com/";
		actualURL = homePage.navigateToFooter("join-us", "Job Roles", expectedUrl);
		verifyPageURL(actualURL, expectedUrl);
		homePage.navigateBack();

		expectedUrl = prop.getProperty("url") + "/company/aboutus";
		actualURL = homePage.navigateToFooter("company", "About Us", expectedUrl);
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/company/contact";
		actualURL = homePage.navigateToFooter("company", "Contact Us", expectedUrl);
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/company/newsmedia";
		actualURL = homePage.navigateToFooter("company", "News and Media", expectedUrl);
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/sitemap";
		actualURL = homePage.navigateToFooter("company", "Site Map", expectedUrl);
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/integration";
		actualURL = homePage.navigateToFooter("support", "API & Integrations", expectedUrl);
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/trust";
		actualURL = homePage.navigateToFooter("support", "Trust", expectedUrl);
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = "https://products.loginextsolutions.com/product/login.html";
		actualURL = homePage.navigateToFooter("support", "Customer Login", expectedUrl);
		verifyPageURL(actualURL, expectedUrl);
		homePage.navigateBack();

		expectedUrl = prop.getProperty("url") + "/end-user-license-agreement";
		actualURL = homePage.navigateToFooter("support", "End User License Agreement", expectedUrl);
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/feature";
		actualURL = homePage.navigateToFooter("support", "Feature Gallery", expectedUrl);
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/security";
		actualURL = homePage.navigateToFooter("support", "Security", expectedUrl);
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/sitemap";
		actualURL = homePage.navigateToFooter("company", "Site Map", expectedUrl);
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/platform/on-demand/live-track-ondemand-deliveries-drivers";
		actualURL = homePage.navigateToFooter("distinctive-benefits", "Live Tracking of Delivery Movement", expectedUrl);
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/platform/mile/route-planning-software";
		actualURL = homePage.navigateToFooter("distinctive-benefits", "Efficient Route Optimization", expectedUrl);
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/platform/reverse/multiple-pickups-drops-management-software";
		actualURL = homePage.navigateToFooter("distinctive-benefits", "Automated Pickups and Delivery", expectedUrl);
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/platform/mile/delivery-schedule-planning-software";
		actualURL = homePage.navigateToFooter("distinctive-benefits", "Delivery Schedule Planning", expectedUrl);
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/blog/what-is-delivery-management-software-how-to-improve-delivery-experience/";
		actualURL = homePage.navigateToFooter("spotlight-content", "Elevate Your Deliveries with Proven Strategies", expectedUrl);
		verifyPageURL(actualURL, expectedUrl);
		homePage.navigateBack();

		expectedUrl = prop.getProperty("url") + "/blog/best-transportation-management-software-guide/";
		actualURL = homePage.navigateToFooter("spotlight-content", "Revolutionize Your Logistics with TMS Excellence", expectedUrl);
		verifyPageURL(actualURL, expectedUrl);
		homePage.navigateBack();

		expectedUrl = prop.getProperty("url") + "/blog/the-ultimate-guide-to-logistics-management-software-everything-you-need-to-know/";
		actualURL = homePage.navigateToFooter("spotlight-content", "Transform Logistics with the Ultimate Guide", expectedUrl);
		verifyPageURL(actualURL, expectedUrl);
		homePage.navigateBack();

		expectedUrl = prop.getProperty("url") + "/blog/last-mile-delivery-software-importance-in-the-logistics-industry/";
		actualURL = homePage.navigateToFooter("spotlight-content", "The Ultimate Guide to Last Mile Delivery Solutions", expectedUrl);
		verifyPageURL(actualURL, expectedUrl);
		homePage.navigateBack();
	}

	@Test(priority = 16, enabled = true)
	public void verifyHeaderMenuNavigation() {
		String expectedUrl = prop.getProperty("url") + "/platform";
		String actualURL = homePage.navigate("products");
		;
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/platform/mile";
		actualURL = homePage.navigate("products > products_mile");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/platform/mile/route-planning-software";
		actualURL = homePage.navigate("products > products_mile > products_mile_route_planning");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/platform/mile/delivery-schedule-planning-software";
		actualURL = homePage.navigate("products > products_mile > products_mile_schedule_planning");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/platform/mile/live-delivery-tracking-software";
		actualURL = homePage.navigate("products > products_mile > products_mile_live_tracking");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/platform/mile/delivery-validation-with-electronic-proof-of-delivery";
		actualURL = homePage.navigate("products > products_mile > products_mile_delivery_validation");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/platform/reverse";
		actualURL = homePage.navigate("products > products_reverse");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/platform/reverse/route-planning-software";
		actualURL = homePage.navigate("products > products_reverse > products_reverse_route_planning");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/platform/reverse/multiple-pickups-drops-management-software";
		actualURL = homePage.navigate("products > products_reverse > products_reverse_pick_up_&_delivery_optimization");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/platform/reverse/delivery-schedule-planning-software";
		actualURL = homePage.navigate("products > products_reverse > products_reverse_schedule_planning");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/platform/reverse/live-delivery-tracking-software";
		actualURL = homePage.navigate("products > products_reverse > products_reverse_live_tracking");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/platform/on-demand";
		actualURL = homePage.navigate("products > products_on_demand");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/platform/on-demand/auto-order-sequencing-for-ondemand-deliveries";
		actualURL = homePage.navigate("products > products_on_demand > products_on_demand_order_sequencing");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/platform/on-demand/multiple-pickups-drops-management-software";
		actualURL = homePage.navigate("products > products_on_demand > products_on_demand_pickup_and_drop_optimization");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/platform/on-demand/live-track-ondemand-deliveries-drivers";
		actualURL = homePage.navigate("products > products_on_demand > products_on_demand_live_tracking");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/platform/on-demand/application-for-delivery-validation-through-epod";
		actualURL = homePage.navigate("products > products_on_demand > products_on_demand_delivery_validation");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/platform/haul";
		actualURL = homePage.navigate("products > products_haul");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/platform/haul/intercity-longhaul-transport-fleet-route-planning-software";
		actualURL = homePage.navigate("products > products_haul > products_haul_route_planning");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/platform/haul/intercity-transort-vehicle-live-tracking-alerts";
		actualURL = homePage.navigate("products > products_haul > products_haul_tracking_and_alerts");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/platform/haul/intercity-longhaul-transport-driver-behaviour-analysis";
		actualURL = homePage.navigate("products > products_haul > products_haul_driver_behaviour_analysis");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/platform/haul/software-for-capacity-management-and-hub-load-balancing";
		actualURL = homePage.navigate("products > products_haul > products_haul_hub-load_balance");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/platform/driver-app";
		actualURL = homePage.navigate("products > products_driver_app");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/industries/couriers-express-parcels";
		actualURL = homePage.navigate("industries > courier_express_and_parcel");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/industries/couriers-express-parcels/first-mile-pickup-optimization-software";
		actualURL = homePage.navigate("industries > courier_express_and_parcel > courier_express_and_parcel_first_mile_pickup_and_optimization");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/industries/couriers-express-parcels/sameday-ondemand-delivery-optimization-software";
		actualURL = homePage.navigate("industries > courier_express_and_parcel > courier_express_and_parcel_on-demand_/_same_day_delivery");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/industries/couriers-express-parcels/hub-to-hub-middle-mile-optimization-software";
		actualURL = homePage.navigate("industries > courier_express_and_parcel > courier_express_and_parcel_middle_mile_movement_optimization");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/industries/couriers-express-parcels/multiple-pickups-drops-management-software";
		actualURL = homePage.navigate("industries > courier_express_and_parcel > courier_express_and_parcel_multiple_pickup_and_delivery_optimization");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/industries/couriers-express-parcels/special-material-handling-white-glove-delivery-optimization";
		actualURL = homePage.navigate("industries > courier_express_and_parcel > courier_express_and_parcel_special_handling_/_white_glove_delivery");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/industries/couriers-express-parcels/final-mile-delivery-optimization-software";
		actualURL = homePage.navigate("industries > courier_express_and_parcel > courier_express_and_parcel_last_/_final_mile_delivery");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/industries/retail-and-ecommerce";
		actualURL = homePage.navigate("industries > retail_and_e_commerce");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/industries/retail-and-ecommerce/capacity-optimization-software-for-primary-distribution";
		actualURL = homePage.navigate("industries > retail_and_e_commerce > retail_and_e_commerce_primary_distribution_-_capacity_optimization");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/industries/retail-and-ecommerce/route-planning-for-secondary-distribution";
		actualURL = homePage.navigate("industries > retail_and_e_commerce > retail_and_e_commerce_warehouse_to_store_movement");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/industries/retail-and-ecommerce/final-mile-delivery-optimization-software";
		actualURL = homePage.navigate("industries > retail_and_e_commerce > retail_and_e_commerce_store_to_customer_movement");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/industries/retail-and-ecommerce/best-software-for-next-day-or-same-day-delivery-management";
		actualURL = homePage.navigate("industries > retail_and_e_commerce > retail_and_e_commerce_same_day/next_day_delivery");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/industries/retail-and-ecommerce/omnichannel-distribution-management-software";
		actualURL = homePage.navigate("industries > retail_and_e_commerce > retail_and_e_commerce_omnichannel_distribution");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/industries/retail-and-ecommerce/live-track-ondemand-deliveries-drivers";
		actualURL = homePage.navigate("industries > retail_and_e_commerce > retail_and_e_commerce_end-to-end_order_tracking");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/industries/consumer-package";
		actualURL = homePage.navigate("industries > consumer_packaged_goods");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/industries/consumer-package/capacity-optimization-software-for-primary-distribution";
		actualURL = homePage.navigate("industries > consumer_packaged_goods > consumer_packaged_goods_primary_distribution_-_capacity_optimization");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/industries/consumer-package/route-planning-for-secondary-distribution";
		actualURL = homePage.navigate("industries > consumer_packaged_goods > consumer_packaged_goods_warehouse_to_store_movement");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/industries/consumer-package/logistics-software-for-driver-and-vehicle-management";
		actualURL = homePage.navigate("industries > consumer_packaged_goods > consumer_packaged_goods_delivery_associate/vehicle_management");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/industries/consumer-package/live-delivery-tracking-software";
		actualURL = homePage.navigate("industries > consumer_packaged_goods > consumer_packaged_goods_shipment_and_unit_level_tracking");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/industries/consumer-package/sales-schedule-and-journey-planning-software";
		actualURL = homePage.navigate("industries > consumer_packaged_goods > consumer_packaged_goods_sales_schedule_and_journey_optimization");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/industries/consumer-package/cold-chain-logistics-management-software";
		actualURL = homePage.navigate("industries > consumer_packaged_goods > consumer_packaged_goods_temperature_controlled_transport");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/industries/food-and-beverages";
		actualURL = homePage.navigate("industries > food_and_beverage");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/industries/food-and-beverages/software-for-restaurant-supplies-and-distribution";
		actualURL = homePage.navigate("industries > food_and_beverage > food_and_beverage_restaurant_supplies_and_distribution");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/industries/food-and-beverages/multiple-pickups-drops-management-software";
		actualURL = homePage.navigate("industries > food_and_beverage > food_and_beverage_on-demand_pickup_allocation_&_dispatch");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/industries/food-and-beverages/logistics-software-for-driver-and-vehicle-management";
		actualURL = homePage.navigate("industries > food_and_beverage > food_and_beverage_delivery_associate/vehicle_management");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/industries/food-and-beverages/live-track-ondemand-deliveries-drivers";
		actualURL = homePage.navigate("industries > food_and_beverage > food_and_beverage_live_order_tracking_and_alerts");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/industries/food-and-beverages/delivery-application-with-multiple-payment-options-for-cod";
		actualURL = homePage.navigate("industries > food_and_beverage > food_and_beverage_multiple_payment_options");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/industries/food-and-beverages/application-for-delivery-validation-through-epod";
		actualURL = homePage.navigate("industries > food_and_beverage > food_and_beverage_fast_home_delivery_with_customer_feedback");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/industries/transportation-software";
		actualURL = homePage.navigate("industries > transportation_and_logistics");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/industries/transportation-software/software-for-capacity-management-and-hub-load-balancing";
		actualURL = homePage.navigate("industries > transportation_and_logistics > transportation_and_logistics_hub-load_balancing");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/industries/transportation-software/ftl-and-ltl-capacity-optimization";
		actualURL = homePage.navigate("industries > transportation_and_logistics > transportation_and_logistics_ftl_and_ltl_capacity_optimization");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/industries/transportation-software/intercity-longhaul-transport-driver-behaviour-analysis";
		actualURL = homePage.navigate("industries > transportation_and_logistics > transportation_and_logistics_driver_behavior_management");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/industries/transportation-software/hub-to-hub-middle-mile-optimization-software";
		actualURL = homePage.navigate("industries > transportation_and_logistics > transportation_and_logistics_middle_mile_management");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "/industries/transportation-software/cold-chain-logistics-management-software";
		actualURL = homePage.navigate("industries > transportation_and_logistics > transportation_and_logistics_cold_chain_logistics");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "usecase/pickup";
		actualURL = homePage.navigate("usecase > use_case_pickup");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "usecase/delivery";
		actualURL = homePage.navigate("usecase > use_case_delivery");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "usecase/pickup-delivery";
		actualURL = homePage.navigate("usecase > use_case_pickup_and_delivery");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "usecase/line-haul";
		actualURL = homePage.navigate("usecase > use_case_line_haul");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "usecase/end-to-end";
		actualURL = homePage.navigate("usecase > use_case_end_to_end");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "https://loginextsolutions.com/blog";
		actualURL = homePage.navigate("blog");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "resource/casestudy";
		actualURL = homePage.navigate("resource > resource_case_study");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "https://info.loginextsolutions.com/quick-service-restaurant-case-study-for-on-demand-delivery-management";
		actualURL = homePage.navigate("resource > resource_case_study > resource_case_study_card_1");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "https://info.loginextsolutions.com/logistics-distribution-optimization-consumer-packaged-goods";
		actualURL = homePage.navigate("resource > resource_case_study > resource_case_study_card_2");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "resource/whitepaper";
		actualURL = homePage.navigate("resource > resource_white_paper");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "http://info.loginextsolutions.com/white-paper-field-service-management-future-trends";
		actualURL = homePage.navigate("resource > resource_white_paper > resource_white_paper_card_1");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "http://info.loginextsolutions.com/white-paper-fmcg-distribution-management-system-and-future-of-distribution";
		actualURL = homePage.navigate("resource > resource_white_paper > resource_white_paper_card_2");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "resource/infographic";
		actualURL = homePage.navigate("resource > resource_infographics");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "https://2704626.fs1.hubspotusercontent-na1.net/hubfs/2704626/Infographics/LastMile_Infographic_March2022.pdf";
		actualURL = homePage.navigate("resource > resource_infographics > resource_infographics_card_1");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "https://2704626.fs1.hubspotusercontent-na1.net/hubfs/2704626/Infographics/(Infographic)%205%20key%20supply%20chain%20trends.pdf";
		actualURL = homePage.navigate("resource > resource_infographics > resource_infographics_card_2");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "resource/carbonemission";
		actualURL = homePage.navigate("resource > resource_carbon_emission_calculator");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "resource/carbonemission";
		actualURL = homePage.navigate("resource > resource_carbon_emission_calculator > resource_carbon_emission_calculator_card_1");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "join-us/culture";
		actualURL = homePage.navigate("join-us > join_us_company_culture");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "join-us/interview-process";
		actualURL = homePage.navigate("join-us > join_us_interview_process");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = "https://loginext.hire.trakstar.com/";
		actualURL = homePage.navigate("join-us > join_us_job_role");
		verifyPageURL(actualURL, expectedUrl);
		homePage.navigateBack();

		expectedUrl = prop.getProperty("url") + "company/aboutus";
		actualURL = homePage.navigate("company > company_about_us");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "company/aboutus";
		actualURL = homePage.navigate("company > company_about_us > company_about_us_card_1");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url");
		actualURL = homePage.navigate("company > company_about_us > company_about_us_card_2");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "company/contact";
		actualURL = homePage.navigate("company > company_contact_us");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "company/newsmedia";
		actualURL = homePage.navigate("company > company_news_media");
		verifyPageURL(actualURL, expectedUrl);

		expectedUrl = prop.getProperty("url") + "company/newsmedia";
		actualURL = homePage.navigate("company > company_news_media > company_news_media_card_1");
		verifyPageURL(actualURL, expectedUrl);

	}

}
