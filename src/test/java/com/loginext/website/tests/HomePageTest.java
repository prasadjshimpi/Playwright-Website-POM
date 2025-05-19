package com.loginext.website.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.loginext.website.base.BaseTest;
import com.loginext.website.components.home.AwardData;
import com.loginext.website.components.home.IndustryWeServeData;
import com.loginext.website.components.home.ReviewData;
import com.loginext.website.components.home.SignUpCardData;
import com.loginext.website.components.home.WhyLoginextCardData;
import com.loginext.website.constants.HomePageConstants;
import com.loginext.website.constants.HomePageConstants.Award;
import com.loginext.website.constants.HomePageConstants.IndustryWeServe;
import com.loginext.website.constants.HomePageConstants.Review;
import com.loginext.website.constants.HomePageConstants.SignUpCard;
import com.loginext.website.constants.HomePageConstants.WhyLoginextCard;
import com.microsoft.playwright.Page;

public class HomePageTest extends BaseTest {

	final boolean enableAllTest = false;

	@Test
	public void verifyHomePageTitle_ShouldMatchExpectedTitle() {
		Assert.assertEquals(homePage.getHomePageTitle(), HomePageConstants.HOME_PAGE_TITLE);
	}

	@Test
	public void verifyHomePageUrl_ShouldMatchExpectedUrl() {
		Assert.assertEquals(homePage.getHomePageURL(), prop.getProperty("url"));
	}

	@Test(priority = 1, enabled = enableAllTest)
	public void verifyPageStructure() {
		SoftAssert softAssert = new SoftAssert();

		softAssert.assertTrue(homePage.isLogoVisible(), "Logo does not exist!");
		softAssert.assertTrue(homePage.isNavigationMenuVisible(), "Navigation menu does not exist!");
		softAssert.assertTrue(homePage.isLoginLinkVisible(), "Login link does not exist!");
		softAssert.assertTrue(homePage.isSignupLinkVisible(), "Signup link does not exist!");
		softAssert.assertTrue(homePage.isScheduleDemoLinkVisible(), "Schedule Demo link does not exist!");

		softAssert.assertTrue(homePage.isHomeSection1Title1Visible(), "Section 1 title 1 not visible!");
		softAssert.assertTrue(homePage.isHomeSection1Title2Visible(), "Section 1 title 2 not visible!");
		softAssert.assertTrue(homePage.isHomeSection1DescVisible(), "Section 1 description not visible!");
		softAssert.assertTrue(homePage.isHomeSection1ScheduleDemoButtonVisible(),
				"Section 1 Schedule Demo button missing!");
		softAssert.assertTrue(homePage.isHomeSection1SignUpButtonVisible(), "Section 1 Signup button missing!");

		softAssert.assertTrue(homePage.isHomeSection2TitleVisible(), "Section 2 title not visible!");
		softAssert.assertTrue(homePage.isHomeSection2BrandListVisible(), "Section 2 brand list not visible!");

		softAssert.assertTrue(homePage.isHomeSection3Visible(), "Section 3 not visible!");
		softAssert.assertTrue(homePage.isHomeSection4Visible(), "Section 4 not visible!");
		softAssert.assertTrue(homePage.isHomeSection5Visible(), "Section 5 not visible!");

		softAssert.assertAll();
	}

	@Test(priority = 2, enabled = enableAllTest)
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
			softAssert.assertEquals(actualBrandNames.get(i), expectedBrandNames[i],
					"Brand : " + (i + 1) + " is not matched!");
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
			softAssert.assertEquals(review.getLink(), HomePageConstants.HOME_PAGE_SECTION_5_LINK,
					"Section 5 link mismatch at " + (i + 1));
			softAssert.assertEquals(review.getProfile(), HomePageConstants.HOME_PAGE_SECTION_5_LINK_DESC,
					"Section 5 profile text mismatch at " + (i + 1));
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
		Assert.assertEquals(homePage.getSection6VideoButtonTitleText(),
				HomePageConstants.HOME_PAGE_SECTION_6_VIDEO_BUTTON_TITLE);
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
			softAssert.assertEquals(actual.getTitle(), expected.title(),
					"Why Loginext Card title mismatch at " + (i + 1));
			softAssert.assertEquals(actual.getDescription(), expected.description(),
					"Why Loginext Card description mismatch at " + (i + 1));
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

			softAssert.assertEquals(actual.getTabTitle(), expected.tabTitle(),
					"Industry We Serve Card tab title mismatch at " + (i + 1));
			softAssert.assertEquals(actual.getImageText(), expected.imageText(),
					"Industry We Serve Card tab image text mismatch at " + (i + 1));
			softAssert.assertEquals(actual.getImageTitle(), expected.imageTitle(),
					"Industry We Serve Card tab image title mismatch at " + (i + 1));
			softAssert.assertEquals(actual.getImageDescription(), expected.imageDescription(),
					"Industry We Serve Card tab image description mismatch at " + (i + 1));

			softAssert.assertEquals(actual.getTabButton1Text(), expected.tabButton1Text(),
					"Industry We Serve Card tab button 1 text mismatch at " + (i + 1));
			softAssert.assertEquals(actual.getTabButton1Link(), expected.tabButton1Link(),
					"Industry We Serve Card tab button 1 link mismatch at " + (i + 1));

			softAssert.assertEquals(actual.getTabButton2Text(), expected.tabButton2Text(),
					"Industry We Serve Card tab button 2 text mismatch at " + (i + 1));
			softAssert.assertEquals(actual.getTabButton2Link(), expected.tabButton2Link(),
					"Industry We Serve Card tab button 2 link mismatch at " + (i + 1));

			softAssert.assertEquals(actual.getTabBox1Title(), expected.tabBox1Title(),
					"Industry We Serve Card tab box 1 title mismatch at " + (i + 1));
			softAssert.assertEquals(actual.getTabBox2Title(), expected.tabBox2Title(),
					"Industry We Serve Card tab box 2 title mismatch at " + (i + 1));
			softAssert.assertEquals(actual.getTabBox3Title(), expected.tabBox3Title(),
					"Industry We Serve Card tab box 3 title mismatch at " + (i + 1));
			softAssert.assertEquals(actual.getTabBox4Title(), expected.tabBox4Title(),
					"Industry We Serve Card tab box 4 title mismatch at " + (i + 1));
			softAssert.assertEquals(actual.getTabBox5Title(), expected.tabBox5Title(),
					"Industry We Serve Card tab box 5 title mismatch at " + (i + 1));
			softAssert.assertEquals(actual.getTabBox6Title(), expected.tabBox6Title(),
					"Industry We Serve Card tab box 6 title mismatch at " + (i + 1));

		}
		softAssert.assertAll();
	}

	@Test(priority = 9, enabled = enableAllTest)
	public void verifyHomePageSection9_Content() {
		SoftAssert softAssert = new SoftAssert();

		softAssert.assertEquals(homePage.getHomeSection9Title(), HomePageConstants.HOME_PAGE_SECTION_9_TITLE);
		softAssert.assertEquals(homePage.getHomeSection9Desc(), HomePageConstants.HOME_PAGE_SECTION_9_DESC);
		softAssert.assertEquals(homePage.getHomeSection9ButtonText(),
				HomePageConstants.HOME_PAGE_SECTION_9_BUTTON_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9ButtonLink(),
				HomePageConstants.HOME_PAGE_SECTION_9_BUTTON_LINK);

		softAssert.assertEquals(homePage.getHomeSection9CardmainImageText(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_Main_IMAGE_TEXT);

		softAssert.assertEquals(homePage.getHomeSection9Card1ImageText(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_1_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card1ImageLink(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_1_IMAGE_LINK);

		softAssert.assertEquals(homePage.getHomeSection9Card1Image1Text(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_1_1_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card1Image1Link(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_1_1_IMAGE_LINK);
		softAssert.assertEquals(homePage.getHomeSection9Card1Image2Text(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_1_2_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card1Image2Link(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_1_2_IMAGE_LINK);
		softAssert.assertEquals(homePage.getHomeSection9Card1Image3Text(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_1_3_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card1Image3Link(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_1_3_IMAGE_LINK);

		softAssert.assertEquals(homePage.getHomeSection9Card7ImageText(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_7_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card7ImageLink(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_7_IMAGE_LINK);

		softAssert.assertEquals(homePage.getHomeSection9Card7Image1Text(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_7_1_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card7Image1Link(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_7_1_IMAGE_LINK);
		softAssert.assertEquals(homePage.getHomeSection9Card7Image2Text(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_7_2_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card7Image2Link(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_7_2_IMAGE_LINK);

		softAssert.assertEquals(homePage.getHomeSection9Card3ImageText(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_3_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card3ImageLink(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_3_IMAGE_LINK);

		softAssert.assertEquals(homePage.getHomeSection9Card2ImageText(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_2_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card2ImageLink(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_2_IMAGE_LINK);

		softAssert.assertEquals(homePage.getHomeSection9Card2Image1Text(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_2_1_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card2Image1Link(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_2_1_IMAGE_LINK);
		softAssert.assertEquals(homePage.getHomeSection9Card2Image2Text(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_2_2_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card2Image2Link(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_2_2_IMAGE_LINK);

		softAssert.assertEquals(homePage.getHomeSection9Card5ImageText(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_5_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card5ImageLink(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_5_IMAGE_LINK);

		softAssert.assertEquals(homePage.getHomeSection9Card5Image1Text(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_5_1_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card5Image1Link(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_5_1_IMAGE_LINK);

		softAssert.assertEquals(homePage.getHomeSection9Card6ImageText(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_6_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card6ImageLink(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_6_IMAGE_LINK);

		softAssert.assertEquals(homePage.getHomeSection9Card6Image1Text(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_6_1_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card6Image1Link(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_6_1_IMAGE_LINK);
		softAssert.assertEquals(homePage.getHomeSection9Card6Image2Text(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_6_2_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card6Image2Link(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_6_2_IMAGE_LINK);

		softAssert.assertEquals(homePage.getHomeSection9Card8ImageText(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_8_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card8ImageLink(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_8_IMAGE_LINK);

		softAssert.assertEquals(homePage.getHomeSection9Card8Image1Text(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_8_1_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card8Image1Link(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_8_1_IMAGE_LINK);
		softAssert.assertEquals(homePage.getHomeSection9Card8Image2Text(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_8_2_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card8Image2Link(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_8_2_IMAGE_LINK);
		softAssert.assertEquals(homePage.getHomeSection9Card8Image3Text(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_8_3_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card8Image3Link(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_8_3_IMAGE_LINK);
		softAssert.assertEquals(homePage.getHomeSection9Card8Image4Text(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_8_4_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card8Image4Link(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_8_4_IMAGE_LINK);
		softAssert.assertEquals(homePage.getHomeSection9Card8Image5Text(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_8_5_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card8Image5Link(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_8_5_IMAGE_LINK);

		softAssert.assertEquals(homePage.getHomeSection9Card3Image1Text(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_3_1_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card3Image1Link(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_3_1_IMAGE_LINK);
		softAssert.assertEquals(homePage.getHomeSection9Card3Image2Text(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_3_2_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card3Image2Link(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_3_2_IMAGE_LINK);
		softAssert.assertEquals(homePage.getHomeSection9Card3Image3Text(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_3_3_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card3Image3Link(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_3_3_IMAGE_LINK);
		softAssert.assertEquals(homePage.getHomeSection9Card3Image4Text(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_3_4_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card3Image4Link(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_3_4_IMAGE_LINK);
		softAssert.assertEquals(homePage.getHomeSection9Card3Image5Text(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_3_5_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card3Image5Link(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_3_5_IMAGE_LINK);

		softAssert.assertEquals(homePage.getHomeSection9Card4Image4Text(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_4_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card4Image4Link(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_4_IMAGE_LINK);

		softAssert.assertEquals(homePage.getHomeSection9Card4Image1Text(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_4_1_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card4Image1Link(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_4_1_IMAGE_LINK);
		softAssert.assertEquals(homePage.getHomeSection9Card4Image2Text(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_4_2_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card4Image2Link(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_4_2_IMAGE_LINK);
		softAssert.assertEquals(homePage.getHomeSection9Card4Image3Text(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_4_3_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card4Image3Link(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_4_3_IMAGE_LINK);
		softAssert.assertEquals(homePage.getHomeSection9Card4Image4Text(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_4_4_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card4Image4Link(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_4_4_IMAGE_LINK);

		softAssert.assertEquals(homePage.getHomeSection9Card9ImageText(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_9_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card9ImageLink(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_9_IMAGE_LINK);

		softAssert.assertEquals(homePage.getHomeSection9Card9Image1Text(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_9_1_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card9Image1Link(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_9_1_IMAGE_LINK);
		softAssert.assertEquals(homePage.getHomeSection9Card9Image2Text(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_9_2_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card9Image2Link(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_9_2_IMAGE_LINK);

		softAssert.assertEquals(homePage.getHomeSection9Card10ImageText(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_10_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card10ImageLink(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_10_IMAGE_LINK);

		softAssert.assertEquals(homePage.getHomeSection9Card10Image1Text(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_10_1_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card10Image1Link(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_10_1_IMAGE_LINK);
		softAssert.assertEquals(homePage.getHomeSection9Card10Image2Text(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_10_2_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card10Image2Link(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_10_2_IMAGE_LINK);
		softAssert.assertEquals(homePage.getHomeSection9Card10Image3Text(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_10_3_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card10Image3Link(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_10_3_IMAGE_LINK);

		softAssert.assertEquals(homePage.getHomeSection9Card11ImageText(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_11_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card11ImageLink(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_11_IMAGE_LINK);

		softAssert.assertEquals(homePage.getHomeSection9Card11Image1Text(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_11_1_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card11Image1Link(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_11_1_IMAGE_LINK);
		softAssert.assertEquals(homePage.getHomeSection9Card11Image2Text(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_11_2_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card11Image2Link(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_11_2_IMAGE_LINK);
		softAssert.assertEquals(homePage.getHomeSection9Card11Image3Text(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_11_3_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card11Image3Link(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_11_3_IMAGE_LINK);
		softAssert.assertEquals(homePage.getHomeSection9Card11Image4Text(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_11_4_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card11Image4Link(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_11_4_IMAGE_LINK);

		softAssert.assertEquals(homePage.getHomeSection9Card11Image6Text(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_11_6_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card11Image6Link(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_11_6_IMAGE_LINK);

		softAssert.assertEquals(homePage.getHomeSection9Card11Image5Text(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_11_5_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card11Image5Link(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_11_5_IMAGE_LINK);

		softAssert.assertEquals(homePage.getHomeSection9Card12ImageText(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_12_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card12ImageLink(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_12_IMAGE_LINK);

		softAssert.assertEquals(homePage.getHomeSection9Card12Image1Text(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_12_1_IMAGE_TEXT);
		softAssert.assertEquals(homePage.getHomeSection9Card12Image1Link(),
				HomePageConstants.HOME_PAGE_SECTION_9_CARD_12_1_IMAGE_LINK);

		softAssert.assertAll();
	}

	@Test(priority = 10, enabled = enableAllTest)
	public void verifyHomePageSection10_Content() {
		SoftAssert softAssert = new SoftAssert();

		softAssert.assertEquals(homePage.getHomeSection10Button1Text(),
				HomePageConstants.HOME_PAGE_SECTION_10_BUTTON_1_TITLE);
		softAssert.assertEquals(homePage.getHomeSection10Button2Text(),
				HomePageConstants.HOME_PAGE_SECTION_10_BUTTON_2_TITLE);
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
		Assert.assertEquals(newTab.url(), "https://products.loginextsolutions.com/login",
				"Login link did not open correct URL");
		newTab.close(); // Close the new tab
	}

	@Test(priority = 13, enabled = enableAllTest)
	public void verifySignUpPage_Content() {
		Assert.assertTrue(homePage.clickSignupAndVerifyPopupCloseButton(),
				"Close button did not appear in signup popup!");

		List<SignUpCardData> actualSignUpCards = homePage.getSignUpCards();
		SignUpCard[] expectedSignUpCards = HomePageConstants.SIGN_UP_CARDS;

		SoftAssert softAssert = new SoftAssert();
		for (int i = 0; i < expectedSignUpCards.length; i++) {
			SignUpCard expected = expectedSignUpCards[i];
			SignUpCardData actual = actualSignUpCards.get(i);

			softAssert.assertEquals(actual.getCompany(), expected.company(),
					"Sign up company mismatch at card " + (i + 1));
			softAssert.assertEquals(actual.getTitle(), expected.title(), "Sign up title mismatch at card " + (i + 1));
			softAssert.assertEquals(actual.getCompanyDesc(), expected.companyDesc(),
					"Sign up company descnmismatch at card " + (i + 1));
			softAssert.assertEquals(actual.getButton1_text(), expected.button1_text(),
					"Sign up button1 text mismatch at card " + (i + 1));
			softAssert.assertEquals(actual.getButton2_text(), expected.button2_text(),
					"Sign up button2 text mismatch at card " + (i + 1));
			softAssert.assertEquals(actual.getImage_text(), expected.image_text(),
					"Sign up image text mismatch at card " + (i + 1));
			softAssert.assertEquals(actual.getImage_link(), expected.image_link(),
					"Sign up image link mismatch at card " + (i + 1));
		}
		softAssert.assertAll();
		homePage.clickSignupClose();
	}

	@Test(priority = 14, enabled = true)
	public void verifySignUpMilePage_StartFreeTrial_Pricing_Buttons() throws InterruptedException {

		String signUpUrl = prop.getProperty("url") + "pricing/signup";
		String pricingUrl = prop.getProperty("url") + "pricing";

		Assert.assertTrue(homePage.clickSignupAndVerifyPopupCloseButton(),
				"Close button did not appear in signup popup!");
		Assert.assertEquals(homePage.clickMileStartFreeTrial(signUpUrl), signUpUrl,
				"Mile Start Free Trial Button not working !");

		Assert.assertTrue(homePage.clickSignupAndVerifyPopupCloseButton(),
				"Close button did not appear in signup popup!");
		Assert.assertEquals(homePage.clickMilePricing(pricingUrl), pricingUrl, "Mile Pricing Button not working !");

		Assert.assertTrue(homePage.clickSignupAndVerifyPopupCloseButton(),
				"Close button did not appear in signup popup!");
		Assert.assertEquals(homePage.clickReverseStartFreeTrial(signUpUrl), signUpUrl,
				"Reverse Start Free Trial Button not working !");

		Assert.assertTrue(homePage.clickSignupAndVerifyPopupCloseButton(),
				"Close button did not appear in signup popup!");
		Assert.assertEquals(homePage.clickReversePricing(pricingUrl), pricingUrl,
				"Reverse Pricing Button not working !");

		Assert.assertTrue(homePage.clickSignupAndVerifyPopupCloseButton(),
				"Close button did not appear in signup popup!");
		Assert.assertEquals(homePage.clickOnDemandStartFreeTrial(signUpUrl), signUpUrl,
				"On Demand Start Free Trial Button not working !");

		Assert.assertTrue(homePage.clickSignupAndVerifyPopupCloseButton(),
				"Close button did not appear in signup popup!");
		Assert.assertEquals(homePage.clickOnDemandPricing(pricingUrl), pricingUrl,
				"On Demand Pricing Button not working !");

		Assert.assertTrue(homePage.clickSignupAndVerifyPopupCloseButton(),
				"Close button did not appear in signup popup!");
		Assert.assertEquals(homePage.clickHaulStartFreeTrial(signUpUrl), signUpUrl,
				"Haul Start Free Trial Button not working !");

		Assert.assertTrue(homePage.clickSignupAndVerifyPopupCloseButton(),
				"Close button did not appear in signup popup!");
		Assert.assertEquals(homePage.clickHaulPricing(pricingUrl), pricingUrl, "Haul Pricing Button not working !");
	}

	@Test(priority = 15, enabled = true)
	public void verfiyHeaderMenuNavigation() {

	}
}
