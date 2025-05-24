package com.loginext.website.pages.home;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.loginext.website.components.home.AwardData;
import com.loginext.website.components.home.IndustryWeServeData;
import com.loginext.website.components.home.ReviewData;
import com.loginext.website.components.home.SignUpCardData;
import com.loginext.website.components.home.WhyLoginextCardData;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitForSelectorState;

public class HomePage extends BasePage {
	public HomePage(Page page) {
		super(page);
		this.page = page;
	}

	private Page page;
	private String logo = ".logo__desktop";
	private String navigationMenu = ".navigation-menu";
	private String login = "a[data-auto-id='login']";
	private String signup = "a[data-auto-id='sign-up']";
	private String signupClose = "[data-auto-id='sign_up_popup_close']";
	private String scheduledemo = "a[data-auto-id='schedule-a-demo']";

	private String homeSection1Title1 = "[data-auto-id='home_section_1_title_1']";
	private String homeSection1Title2 = "[data-auto-id='home_section_1_title_2']";
	private String homeSection1Desc = "[data-auto-id='home_section_1_desc']";
	private String homeSectionScheduleDemo = "[data-auto-id='home_section_1_schedule_a_demo']";
	private String homeSectionSignUp = "[data-auto-id='home_section_1_sign_up']";

	private String homeSection2Desc = "[data-auto-id='home_section_2_title']";
	private String homeSection2brandsList = ".loginext-empower-brands__brand-list";
	private String homeSection2brands = ".loginext-empower-brands__brand-list-item img";

	private String homeSection3 = "[data-auto-id='home_section_3']";

	private String homeSection4 = "[data-auto-id='home_Section_4']";
	private String homeSection4reviewRatings = ".review-rating li";

	private String homeSection5 = "[data-auto-id='home_section_5']";

	private String homeSection6 = "[data-auto-id='home_Section_6']";
	private String homeSection6Video = "[data-auto-id='home_section_6_video'] source";
	private String homeSection6Title = "[data-auto-id='home_section_6_title']";
	private String homeSection6Desc1 = "[data-auto-id='home_section_6_desc1']";
	private String homeSection6Desc2 = "[data-auto-id='home_section_6_desc2']";
	private String homeSection6VideoTitleText = "[data-auto-id='home_Section_6'] p[class*='text text--s']";
	private String homeSection6VideoButton = "[data-auto-id='home_section_6_video_button']";

	private String homeSection7Title = "[data-auto-id='home_section_7_title']";
	private String homeSection7WhyLoginextCards = ".why-loginext__cards a";

	private String homeSection8Title = "h2[data-auto-id='home_section_8_title']";
	private String homeSection8IndustriesWeServe = "[data-auto-id='home_section_8']";

	private String homeSection8FoodBeverageBox1Title = "[data-auto-id='home_section_8_feature_title_large-home-slider-food--beverage-restaurant-supplies-and-distribution']";
	private String homeSection8FoodBeverageBox2Title = "[data-auto-id='home_section_8_feature_title_large-home-slider-food--beverage-on-demand-pickup-allocation--dispatch']";
	private String homeSection8FoodBeverageBox3Title = "[data-auto-id='home_section_8_feature_title_large-home-slider-food--beverage-delivery-associate-vehicle-management']";
	private String homeSection8FoodBeverageBox4Title = "[data-auto-id='home_section_8_feature_title_large-home-slider-food--beverage-live-order-tracking-and-alerts']";
	private String homeSection8FoodBeverageBox5Title = "[data-auto-id='home_section_8_feature_title_large-home-slider-food--beverage-multiple-payment-options']";
	private String homeSection8FoodBeverageBox6Title = "[data-auto-id='home_section_8_feature_title_large-home-slider-food--beverage-fast-home-delivery-with-customer-feedback']";

	private String homeSection8CourierExpressParcelBox1Title = "[data-auto-id='home_section_8_feature_title_-parcel-first-mile-pickup']";
	private String homeSection8CourierExpressParcelBox2Title = "[data-auto-id='home_section_8_feature_title_-parcel-on-demand-same-day-delivery']";
	private String homeSection8CourierExpressParcelBox3Title = "[data-auto-id='home_section_8_feature_title_-parcel-middle-mile-management']";
	private String homeSection8CourierExpressParcelBox4Title = "[data-auto-id='home_section_8_feature_title_-parcel-multiple-pickup-and-delivery-optimization']";
	private String homeSection8CourierExpressParcelBox5Title = "[data-auto-id='home_section_8_feature_title_-parcel-special-handling-white-glove-delivery']";
	private String homeSection8CourierExpressParcelBox6Title = "[data-auto-id='home_section_8_feature_title_-parcel-last-final-mile-delivery']";

	private String homeSection8ConsumerPackagedGoodsBox1Title = "[data-auto-id='home_section_8_feature_title_large-home-slider-consumer-packaged-goods-primary-distribution-capacity-optimization']";
	private String homeSection8ConsumerPackagedGoodsBox2Title = "[data-auto-id='home_section_8_feature_title_large-home-slider-consumer-packaged-goods-warehouse-to-store-movement']";
	private String homeSection8ConsumerPackagedGoodsBox3Title = "[data-auto-id='home_section_8_feature_title_large-home-slider-consumer-packaged-goods-delivery-associate-vehicle-management']";
	private String homeSection8ConsumerPackagedGoodsBox4Title = "[data-auto-id='home_section_8_feature_title_large-home-slider-consumer-packaged-goods-shipment-and-unit-level-tracking']";
	private String homeSection8ConsumerPackagedGoodsBox5Title = "[data-auto-id='home_section_8_feature_title_large-home-slider-consumer-packaged-goods-sales-schedule-and-journey-optimization']";
	private String homeSection8ConsumerPackagedGoodsBox6Title = "[data-auto-id='home_section_8_feature_title_large-home-slider-consumer-packaged-goods-temperature-controlled-transport']";

	private String homeSection8RetailEcommerceBox1Title = "[data-auto-id='home_section_8_feature_title_large-home-slider-consumer-packaged-goods-primary-distribution-capacity-optimization']";
	private String homeSection8RetailEcommerceBox2Title = "[data-auto-id='home_section_8_feature_title_large-home-slider-retail--e-commerce-warehouse-to-store-movement']";
	private String homeSection8RetailEcommerceBox3Title = "[data-auto-id='home_section_8_feature_title_large-home-slider-retail--e-commerce-store-to-customer-movement']";
	private String homeSection8RetailEcommerceBox4Title = "[data-auto-id='home_section_8_feature_title_large-home-slider-retail--e-commerce-same-day-next-day-delivery']";
	private String homeSection8RetailEcommerceBox5Title = "[data-auto-id='home_section_8_feature_title_large-home-slider-retail--e-commerce-omnichannel-distribution']";
	private String homeSection8RetailEcommerceBox6Title = "[data-auto-id='home_section_8_feature_title_large-home-slider-retail--e-commerce-end-to-end-package-tracking']";

	private String homeSection8TransportationLogisticsBox1Title = "[data-auto-id='home_section_8_feature_title_large-home-slider-logistics--transportation-hub-load-balancing']";
	private String homeSection8TransportationLogisticsBox2Title = "[data-auto-id='home_section_8_feature_title_large-home-slider-logistics--transportation-ftl-and-ltl-capacity-optimization']";
	private String homeSection8TransportationLogisticsBox3Title = "[data-auto-id='home_section_8_feature_title_large-home-slider-logistics--transportation-rate-and-contract-management']";
	private String homeSection8TransportationLogisticsBox4Title = "[data-auto-id='home_section_8_feature_title_large-home-slider-logistics--transportation-driver-behavior-management']";
	private String homeSection8TransportationLogisticsBox5Title = "[data-auto-id='home_section_8_feature_title_large-home-slider-logistics--transportation-middle-mile-management']";
	private String homeSection8TransportationLogisticsBox6Title = "[data-auto-id='home_section_8_feature_title_large-home-slider-logistics--transportation-cold-chain-logistics-management-previousnext']";

	private String homeSection9 = "[data-auto-id='home_section_9']";
	private String homeSection9Title = "[data-auto-id='home_section_9_title']";

	private String homeSection9Desc = "[data-auto-id='home_section_9_desc']";
	private String homeSection9Button = "[data-auto-id='home_section_9_check-it-out']";

	private String homeSection9CardmainImageText = "[data-auto-id='home_section_9_loginext_logo']";

	private String homeSection9Card1Image = "[data-auto-id='home_section_9_link_CRM']";

	private String homeSection9Card1Image1 = "[data-auto-id='home_section_9_link_salesforce']";
	private String homeSection9Card1Image2 = "[data-auto-id='home_section_9_link_zoho']";
	private String homeSection9Card1Image3 = "[data-auto-id='home_section_9_link_microsoft-dynamics']";

	private String homeSection9Card2Image = "[data-auto-id='home_section_9_link_SMS']";

	private String homeSection9Card2Image1 = "[data-auto-id='home_section_9_link_twilio']";
	private String homeSection9Card2Image2 = "[data-auto-id='home_section_9_link_solutions-infini']";

	private String homeSection9Card3Image = "[data-auto-id='home_section_9_link_OMS']";

	private String homeSection9Card3Image1 = "[data-auto-id='home_section_9_link_magento']";
	private String homeSection9Card3Image2 = "[data-auto-id='home_section_9_link_shopify']";
	private String homeSection9Card3Image3 = "[data-auto-id='home_section_9_link_capillary-martjack']";
	private String homeSection9Card3Image4 = "[data-auto-id='home_section_9_link_ibm-watson-commerce']";
	private String homeSection9Card3Image5 = "[data-auto-id='home_section_9_link_sap-hybris']";

	private String homeSection9Card4Image = "[data-auto-id='home_section_9_link_CLOUD']";
	private String homeSection9Card4Image1 = "[data-auto-id='home_section_9_link_amazon']";
	private String homeSection9Card4Image2 = "[data-auto-id='home_section_9_link_alibaba']";
	private String homeSection9Card4Image3 = "[data-auto-id='home_section_9_link_microsoft-azure']";
	private String homeSection9Card4Image4 = "[data-auto-id='home_section_9_link_ibm-cloud']";

	private String homeSection9Card5Image = "[data-auto-id='home_section_9_link_ERP']";
	private String homeSection9Card5Image1 = "[data-auto-id='home_section_9_link_oracle']";

	private String homeSection9Card6Image = "[data-auto-id='home_section_9_link_HARDWARE']";
	private String homeSection9Card6Image1 = "[data-auto-id='home_section_9_link_concox']";
	private String homeSection9Card6Image2 = "[data-auto-id='home_section_9_link_trimble']";

	private String homeSection9Card7Image = "[data-auto-id='home_section_9_link_WMS']";
	private String homeSection9Card7Image1 = "[data-auto-id='home_section_9_link_grey-orange']";
	private String homeSection9Card7Image2 = "[data-auto-id='home_section_9_link_jda-warehouse']";

	private String homeSection9Card8Image = "[data-auto-id='home_section_9_link_PAYMENT']";

	private String homeSection9Card8Image1 = "[data-auto-id='home_section_9_link_paytm']";
	private String homeSection9Card8Image2 = "[data-auto-id='home_section_9_link_m-swipe']";
	private String homeSection9Card8Image3 = "[data-auto-id='home_section_9_link_mosambee']";
	private String homeSection9Card8Image4 = "[data-auto-id='home_section_9_link_momoe']";
	private String homeSection9Card8Image5 = "[data-auto-id='home_section_9_link_midtrans']";

	private String homeSection9Card9Image = "[data-auto-id='home_section_9_link_TMS']";
	private String homeSection9Card9Image1 = "[data-auto-id='home_section_9_link_sap']";
	private String homeSection9Card9Image2 = "[data-auto-id='home_section_9_link_otm']";

	private String homeSection9Card10Image = "[data-auto-id='home_section_9_link_MAP']";
	private String homeSection9Card10Image1 = "[data-auto-id='home_section_9_link_google']";
	private String homeSection9Card10Image2 = "[data-auto-id='home_section_9_link_here-map']";
	private String homeSection9Card10Image3 = "[data-auto-id='home_section_9_link_osm']";

	private String homeSection9Card11Image = "[data-auto-id='home_section_9_link_CARRIERS']";
	private String homeSection9Card11Image1 = "[data-auto-id='home_section_9_link_pando-go']";
	private String homeSection9Card11Image2 = "[data-auto-id='home_section_9_link_grab']";
	private String homeSection9Card11Image3 = "[data-auto-id='home_section_9_link_dhl']";
	private String homeSection9Card11Image4 = "[data-auto-id='home_section_9_link_fedex']";
	private String homeSection9Card11Image5 = "[data-auto-id='home_section_9_link_order-in']";
	private String homeSection9Card11Image6 = "[data-auto-id='home_section_9_link_uber-eats']";

	private String homeSection9Card12Image = "[data-auto-id='home_section_9_link_EMAIL']";
	private String homeSection9Card12Image1 = "[data-auto-id='home_section_9_link_send-grid']";

	private String homeSection10Button1Title = "[data-auto-id='home_section_10_schedule_a_demo']";
	private String homeSection10Button2Title = "[data-auto-id='home_section_10_sign_up']";

	private String homeSection11 = "[data-auto-id='home_section_11']";
	private String homeSection11awardReferences = "[data-auto-id='home_section_11'] a";

	private String signUpCards = ".sign-up-popup__content .platform-card";

	private String loginextMileStartFreeTrial = "[data-auto-id='sign_up_popup_card_product_mile_start_free_trial']";
	private String loginextReverseStartFreeTrial = "[data-auto-id='sign_up_popup_card_product_reverse_start_free_trial']";
	private String loginextOnDemandStartFreeTrial = "[data-auto-id='sign_up_popup_card_product_on_demand_start_free_trial']";
	private String loginextHaulStartFreeTrial = "[data-auto-id='sign_up_popup_card_product_haul_start_free_trial']";

	private String loginextMilePricing = "[data-auto-id='sign_up_popup_card_product_mile_pricing']";
	private String loginextReversePricing = "[data-auto-id='sign_up_popup_card_product_reverse_pricing']";
	private String loginextOnDemandPricing = "[data-auto-id='sign_up_popup_card_product_on_demand_pricing']";
	private String loginextHaulPricing = "[data-auto-id='sign_up_popup_card_product_haul_pricing']";

	private String footerPlatform = "[data-auto-id='footer_products']";
	private String footerLoginextMile = "[data-auto-id='footer_products_mile']";
	private String footerLoginextReverse = "[data-auto-id='footer_products_reverse']";
	private String footerLoginextOnDemand = "[data-auto-id='footer_products_on_demand']";
	private String footerLoginextHaul = "[data-auto-id='footer_products_haul']";
	private String footerLoginextDriverApp = "[data-auto-id='footer_products_driver_app']";

	private String footerIndustries = "[data-auto-id='footer_industries']";
	private String footerCEP = "[data-auto-id='footer_courier_express_and_parcel']";
	private String footerRE = "[data-auto-id='footer_retail_and_e_commerce']";
	private String footerCPG = "[data-auto-id='footer_consumer_packaged_goods']";
	private String footerFB = "[data-auto-id='footer_food_and_beverage']";
	private String footerTL = "[data-auto-id='footer_transportation_and_logistics']";

	private String footerUsecase = "[data-auto-id='footer_usecase']";
	private String footerPickup = "[data-auto-id='footer_use_case_pickup']";
	private String footerDelivery = "[data-auto-id='footer_use_case_delivery']";
	private String footerPickupDelivery = "[data-auto-id='footer_use_case_pickup_and_delivery']";
	private String footerLineHaul = "[data-auto-id='footer_use_case_line_haul']";
	private String footerEndToEnd = "[data-auto-id='footer_use_case_end_to_end']";

	private String footerResources = "[data-auto-id='footer_resource']";
	private String footerCaseStudies = "[data-auto-id='footer_resource_case_study']";
	private String footerWhitePapers = "[data-auto-id='footer_resource_white_paper']";
	private String footerInfographics = "[data-auto-id='footer_resource_infographics']";
	private String footerCarbonEmissionCalculator = "[data-auto-id='footer_resource_carbon_emission_calculator']";

	private String footerJoinUs = "[data-auto-id='footer_join-us']";
	private String footerCompanyCulture = "[data-auto-id='footer_join_us_company_culture']";
	private String footerInterviewProcess = "[data-auto-id='footer_join_us_interview_process']";
	private String footerJobRoles = "[data-auto-id='footer_join_us_job_role']";

	private String footerCompany = "[data-auto-id='footer_company']";
	private String footerAboutUs = "[data-auto-id='footer_company_about_us']";
	private String footerContactUs = "[data-auto-id='footer_company_contact_us']";
	private String footerNewsMedia = "[data-auto-id='footer_company_news_media']";
	private String footerSiteMap = "[data-auto-id='footer_site_map']";

	private String footerSupport = "[data-auto-id='footer_support']";
	private String footerAPI_Integrations = "[data-auto-id='footer_api-integration']";
	private String footerTrust = "[data-auto-id='footer_trust']";
	private String footerCustomerLogin = "[data-auto-id='footer_customer-login']";
	private String footerEULA = "[data-auto-id='footer_end-user-license-agreement']";
	private String footerFeatureGallery = "[data-auto-id='footer_feature-gallery']";
	private String footerSecurity = "[data-auto-id='footer_security']";

	private String footerDistinctiveBenefits = "[data-auto-id='footer_distinctive-benefits']";
	private String footerLTODM = "[data-auto-id='footer_live-tracking-of-delivery-movement']";
	private String footerERO = "[data-auto-id='footer_efficient-route-optimization']";
	private String footerAPAD = "[data-auto-id='footer_automated-pickups-and-delivery']";
	private String footerDSP = "[data-auto-id='footer_delivery-schedule-planning']";

	private String footerSpotlightContent = "[data-auto-id='footer_spotlight-content']";
	private String footerEYDPS = "[data-auto-id='footer_elevate-your-deliveries-with-proven-strategies']";
	private String footerRYLTE = "[data-auto-id='footer_revolutionize-your-logistics-with-tms-excellence']";
	private String footerTLUG = "[data-auto-id='footer_transform-logistics-with-the-ultimate-guide']";
	private String footerTUGLMDS = "[data-auto-id='footer_the-ultimate-gGuide-tto-last-mile-delivery-solutions']";

	private String footerFacebook = "[data-auto-id='facebook']";
	private String footerTwitter = "[data-auto-id='twitter']";
	private String footerLinkedin = "[data-auto-id='linkedIn']";
	private String footerInstagram = "[data-auto-id='instagram']";
	private String footerYoutube = "[data-auto-id='youtube']";

	private String footerGooglePlay = "[data-auto-id='undefined_google_play_store']";
	private String footerAppstore = "[data-auto-id='undefined_apple_app_store']";

	public String getHomePageTitle() {
		return page.title();
	}

	public String getHomePageURL() {
		return page.url();
	}

	public String getSection1Title1Text() {
		return getText(homeSection1Title1);
	}

	public String getSection1Title2Text() {
		return getText(homeSection1Title2);
	}

	public String getSection1DescText() {
		return getText(homeSection1Desc);
	}

	public String getSection6VideoLink() {
		page.locator(homeSection6Video).evaluate("element => element.scrollIntoView()");
		return page.locator(homeSection6Video).getAttribute("src");
	}

	public String getSection6TitleText() {
		return getText(homeSection6Title);
	}

	public String getSection6Desc1Text() {
		return getText(homeSection6Desc1);
	}

	public String getSection6Desc2Text() {
		return getText(homeSection6Desc2);
	}

	public String getSection6VideoTitleText() {
		return getText(homeSection6VideoTitleText);
	}

	public String getSection6VideoButtonTitleText() {
		return page.locator(homeSection6VideoButton).getAttribute("title");
	}

	public String getSection7TitleText() {
		page.locator(homeSection7Title).evaluate("element => element.scrollIntoView()");
		return getText(homeSection7Title);
	}

	public String getSection8TitleText() {
		page.locator(homeSection8Title).evaluate("element => element.scrollIntoView()");
		return getText(homeSection8Title);
	}

	public String getHomeSection9Title() {
		page.locator(homeSection9).evaluate("element => element.scrollIntoView()");
		return getText(homeSection9Title);
	}

	public String getHomeSection9Desc() {
		return getText(homeSection9Desc);
	}

	public String getHomeSection9ButtonText() {
		return getText(homeSection9Button);
	}

	public String getHomeSection9ButtonLink() {
		page.locator(homeSection9Button).evaluate("element => element.scrollIntoView()");
		return getLinkRef(homeSection9Button);
	}

	public String getHomeSection9CardmainImageText() {
		return page.locator(homeSection9CardmainImageText).getAttribute("alt");
	}

	public String getHomeSection9Card1ImageText() {
		page.locator(homeSection9Card1Image).evaluate("element => element.scrollIntoView()");
		page.locator(homeSection9Card1Image).hover();
		return getText(homeSection9Card1Image);
	}

	public String getHomeSection9Card1ImageLink() {
		return getLinkRef(homeSection9Card1Image);
	}

	public String getHomeSection9Card1Image1Text() {
		return getText(homeSection9Card1Image1);
	}

	public String getHomeSection9Card1Image1Link() {
		return getLinkRef(homeSection9Card1Image1);
	}

	public String getHomeSection9Card1Image2Text() {
		return getText(homeSection9Card1Image2);
	}

	public String getHomeSection9Card1Image2Link() {
		return getLinkRef(homeSection9Card1Image2);
	}

	public String getHomeSection9Card1Image3Text() {
		return getText(homeSection9Card1Image3);
	}

	public String getHomeSection9Card1Image3Link() {
		return getLinkRef(homeSection9Card1Image3);
	}

	public String getHomeSection9Card2ImageText() {
		page.locator(homeSection9Card2Image).evaluate("element => element.scrollIntoView()");
		page.locator(homeSection9Card2Image).hover();
		return getText(homeSection9Card2Image);
	}

	public String getHomeSection9Card2ImageLink() {
		return getLinkRef(homeSection9Card2Image);
	}

	public String getHomeSection9Card2Image1Text() {
		return getText(homeSection9Card2Image1);
	}

	public String getHomeSection9Card2Image1Link() {
		return getLinkRef(homeSection9Card2Image1);
	}

	public String getHomeSection9Card2Image2Text() {
		return getText(homeSection9Card2Image2);
	}

	public String getHomeSection9Card2Image2Link() {
		return getLinkRef(homeSection9Card2Image2);
	}

	public String getHomeSection9Card3ImageText() {
		page.locator(homeSection9Card3Image).evaluate("element => element.scrollIntoView()");
		page.locator(homeSection9Card3Image).hover();
		return getText(homeSection9Card3Image);
	}

	public String getHomeSection9Card3ImageLink() {
		return getLinkRef(homeSection9Card3Image);
	}

	public String getHomeSection9Card3Image1Text() {
		return getText(homeSection9Card3Image1);
	}

	public String getHomeSection9Card3Image1Link() {
		return getLinkRef(homeSection9Card3Image1);
	}

	public String getHomeSection9Card3Image2Text() {
		return getText(homeSection9Card3Image2);
	}

	public String getHomeSection9Card3Image2Link() {
		return getLinkRef(homeSection9Card3Image2);
	}

	public String getHomeSection9Card3Image3Text() {
		return getText(homeSection9Card3Image3);
	}

	public String getHomeSection9Card3Image3Link() {
		return getLinkRef(homeSection9Card3Image3);
	}

	public String getHomeSection9Card3Image4Text() {
		return getText(homeSection9Card3Image4);
	}

	public String getHomeSection9Card3Image4Link() {
		return getLinkRef(homeSection9Card3Image4);
	}

	public String getHomeSection9Card3Image5Text() {
		return getText(homeSection9Card3Image5);
	}

	public String getHomeSection9Card3Image5Link() {
		return getLinkRef(homeSection9Card3Image5);
	}

	public String getHomeSection9Card4ImageText() {
		page.locator(homeSection9Card4Image).evaluate("element => element.scrollIntoView()");
		page.locator(homeSection9Card4Image).hover();
		return getText(homeSection9Card4Image);
	}

	public String getHomeSection9Card4ImageLink() {
		return getLinkRef(homeSection9Card4Image);
	}

	public String getHomeSection9Card4Image1Text() {
		return getText(homeSection9Card4Image1);
	}

	public String getHomeSection9Card4Image1Link() {
		return getLinkRef(homeSection9Card4Image1);
	}

	public String getHomeSection9Card4Image2Text() {
		return getText(homeSection9Card4Image2);
	}

	public String getHomeSection9Card4Image2Link() {
		return getLinkRef(homeSection9Card4Image2);
	}

	public String getHomeSection9Card4Image3Text() {
		return getText(homeSection9Card4Image3);
	}

	public String getHomeSection9Card4Image3Link() {
		return getLinkRef(homeSection9Card4Image3);
	}

	public String getHomeSection9Card4Image4Text() {
		return getText(homeSection9Card4Image4);
	}

	public String getHomeSection9Card4Image4Link() {
		return getLinkRef(homeSection9Card4Image4);
	}

	public String getHomeSection9Card5ImageText() {
//		page.locator(homeSection9Card5Image).evaluate("element => element.scrollIntoView()");
//		page.locator(homeSection9Card5Image).hover();
		return getText(homeSection9Card5Image);
	}

	public String getHomeSection9Card5ImageLink() {
		return getLinkRef(homeSection9Card5Image);
	}

	public String getHomeSection9Card5Image1Text() {
		return getText(homeSection9Card5Image1);
	}

	public String getHomeSection9Card5Image1Link() {
		return getLinkRef(homeSection9Card5Image1);
	}

	public String getHomeSection9Card6ImageText() {
//		page.locator(homeSection9Card6Image).evaluate("element => element.scrollIntoView()");
		page.locator(homeSection9Card6Image).hover();
		return getText(homeSection9Card6Image);
	}

	public String getHomeSection9Card6ImageLink() {
		return getLinkRef(homeSection9Card6Image);
	}

	public String getHomeSection9Card6Image1Text() {
		return getText(homeSection9Card6Image1);
	}

	public String getHomeSection9Card6Image1Link() {
		return getLinkRef(homeSection9Card6Image1);
	}

	public String getHomeSection9Card6Image2Text() {
		return getText(homeSection9Card6Image2);
	}

	public String getHomeSection9Card6Image2Link() {
		return getLinkRef(homeSection9Card6Image2);
	}

	public String getHomeSection9Card7ImageText() {
		page.locator(homeSection9Card7Image).evaluate("element => element.scrollIntoView()");
		page.locator(homeSection9Card7Image).hover();
		return getText(homeSection9Card7Image);
	}

	public String getHomeSection9Card7ImageLink() {
		return getLinkRef(homeSection9Card7Image);
	}

	public String getHomeSection9Card7Image1Text() {
		return getText(homeSection9Card7Image1);
	}

	public String getHomeSection9Card7Image1Link() {
		return getLinkRef(homeSection9Card7Image1);
	}

	public String getHomeSection9Card7Image2Text() {
		return getText(homeSection9Card7Image2);
	}

	public String getHomeSection9Card7Image2Link() {
		return getLinkRef(homeSection9Card7Image2);
	}

	public String getHomeSection9Card8ImageText() {
		page.locator(homeSection9Card8Image).evaluate("element => element.scrollIntoView()");
		page.locator(homeSection9Card8Image).hover();
		return getText(homeSection9Card8Image);
	}

	public String getHomeSection9Card8ImageLink() {
		return getLinkRef(homeSection9Card8Image);
	}

	public String getHomeSection9Card8Image1Text() {
		return getText(homeSection9Card8Image1);
	}

	public String getHomeSection9Card8Image1Link() {
		return getLinkRef(homeSection9Card8Image1);
	}

	public String getHomeSection9Card8Image2Text() {
		return getText(homeSection9Card8Image2);
	}

	public String getHomeSection9Card8Image2Link() {
		return getLinkRef(homeSection9Card8Image2);
	}

	public String getHomeSection9Card8Image3Text() {
		return getText(homeSection9Card8Image3);
	}

	public String getHomeSection9Card8Image3Link() {
		return getLinkRef(homeSection9Card8Image3);
	}

	public String getHomeSection9Card8Image4Text() {
		return getText(homeSection9Card8Image4);
	}

	public String getHomeSection9Card8Image4Link() {
		return getLinkRef(homeSection9Card8Image4);
	}

	public String getHomeSection9Card8Image5Text() {
		return getText(homeSection9Card8Image5);
	}

	public String getHomeSection9Card8Image5Link() {
		return getLinkRef(homeSection9Card8Image5);
	}

	public String getHomeSection9Card9ImageText() {
		page.locator(homeSection9Card9Image).evaluate("element => element.scrollIntoView()");
		page.locator(homeSection9Card9Image).hover();
		return getText(homeSection9Card9Image);
	}

	public String getHomeSection9Card9ImageLink() {
		return getLinkRef(homeSection9Card9Image);
	}

	public String getHomeSection9Card9Image1Text() {
		return getText(homeSection9Card9Image1);
	}

	public String getHomeSection9Card9Image1Link() {
		return getLinkRef(homeSection9Card9Image1);
	}

	public String getHomeSection9Card9Image2Text() {
		return getText(homeSection9Card9Image2);
	}

	public String getHomeSection9Card9Image2Link() {
		return getLinkRef(homeSection9Card9Image2);
	}

	public String getHomeSection9Card10ImageText() {
		page.locator(homeSection9Card10Image).evaluate("element => element.scrollIntoView()");
		page.locator(homeSection9Card10Image).hover();
		return getText(homeSection9Card10Image);
	}

	public String getHomeSection9Card10ImageLink() {
		return getLinkRef(homeSection9Card10Image);
	}

	public String getHomeSection9Card10Image1Text() {
		return getText(homeSection9Card10Image1);
	}

	public String getHomeSection9Card10Image1Link() {
		return getLinkRef(homeSection9Card10Image1);
	}

	public String getHomeSection9Card10Image2Text() {
		return getText(homeSection9Card10Image2);
	}

	public String getHomeSection9Card10Image2Link() {
		return getLinkRef(homeSection9Card10Image2);
	}

	public String getHomeSection9Card10Image3Text() {
		return getText(homeSection9Card10Image3);
	}

	public String getHomeSection9Card10Image3Link() {
		return getLinkRef(homeSection9Card10Image3);
	}

	public String getHomeSection9Card11ImageText() {
		page.locator(homeSection9Card11Image).evaluate("element => element.scrollIntoView()");
		page.locator(homeSection9Card11Image).hover();
		return getText(homeSection9Card11Image);
	}

	public String getHomeSection9Card11ImageLink() {
		return getLinkRef(homeSection9Card11Image);
	}

	public String getHomeSection9Card11Image1Text() {
		return getText(homeSection9Card11Image1);
	}

	public String getHomeSection9Card11Image1Link() {
		return getLinkRef(homeSection9Card11Image1);
	}

	public String getHomeSection9Card11Image2Text() {
		return getText(homeSection9Card11Image2);
	}

	public String getHomeSection9Card11Image2Link() {
		return getLinkRef(homeSection9Card11Image2);
	}

	public String getHomeSection9Card11Image3Text() {
		return getText(homeSection9Card11Image3);
	}

	public String getHomeSection9Card11Image3Link() {
		return getLinkRef(homeSection9Card11Image3);
	}

	public String getHomeSection9Card11Image4Text() {
		return getText(homeSection9Card11Image4);
	}

	public String getHomeSection9Card11Image4Link() {
		return getLinkRef(homeSection9Card11Image4);
	}

	public String getHomeSection9Card11Image5Text() {
		return getText(homeSection9Card11Image5);
	}

	public String getHomeSection9Card11Image5Link() {
		return getLinkRef(homeSection9Card11Image5);
	}

	public String getHomeSection9Card11Image6Text() {
		return getText(homeSection9Card11Image6);
	}

	public String getHomeSection9Card11Image6Link() {
		return getLinkRef(homeSection9Card11Image6);
	}

	public String getHomeSection9Card12ImageText() {
		page.locator(homeSection9Card12Image).evaluate("element => element.scrollIntoView()");
		page.locator(homeSection9Card12Image).hover();
		return getText(homeSection9Card12Image);
	}

	public String getHomeSection9Card12ImageLink() {
		return getLinkRef(homeSection9Card12Image);
	}

	public String getHomeSection9Card12Image1Text() {
		return getText(homeSection9Card12Image1);
	}

	public String getHomeSection9Card12Image1Link() {
		return getLinkRef(homeSection9Card12Image1);
	}

	public String getHomeSection10Button1Text() {
		return getText(homeSection10Button1Title);
	}

	public String getHomeSection10Button1Link() {
		return getLinkRef(homeSection10Button1Title);
	}

	public String getHomeSection10Button2Text() {
		return getText(homeSection10Button2Title);
	}

	public String getHomeSection10Button2Link() {
		return getLinkRef(homeSection10Button2Title);
	}

	public boolean isLoginVisible() {
		return isVisible(login);
	}

	public boolean isLogoVisible() {
		return isVisible(logo);
	}

	public boolean isNavigationMenuVisible() {
		return isVisible(navigationMenu);
	}

	public boolean isLoginLinkVisible() {
		return isVisible(login);
	}

	public boolean isSignupLinkVisible() {
		page.locator(signup).waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		return isVisible(signup);
	}

	public boolean isScheduleDemoLinkVisible() {
		return isVisible(scheduledemo);
	}

	public boolean isHomeSection1Title1Visible() {
		return isVisible(homeSection1Title1);
	}

	public boolean isHomeSection1Title2Visible() {
		return isVisible(homeSection1Title2);
	}

	public boolean isHomeSection1DescVisible() {
		return isVisible(homeSection1Desc);
	}

	public boolean isHomeSection1ScheduleDemoButtonVisible() {
		return isVisible(homeSectionScheduleDemo);
	}

	public boolean isHomeSection1SignUpButtonVisible() {
		return isVisible(homeSectionSignUp);
	}

	public boolean isHomeSection2TitleVisible() {
		scrollTo(homeSection2Desc);
		return isVisible(homeSection2Desc);
	}

	public boolean isHomeSection2BrandListVisible() {
		page.locator(homeSection2brandsList).evaluate("element => element.scrollIntoView()");
		return isVisible(homeSection2brandsList);
	}

	public boolean isHomeSection3Visible() {
		return isVisible(homeSection3);
	}

	public boolean isHomeSection4Visible() {
		return isVisible(homeSection4);
	}

	public boolean isHomeSection5Visible() {
		return isVisible(homeSection5);
	}

	public boolean isHomeSection6Visible() {
		return isVisible(homeSection6);
	}

	public String getSection2TitleText() {
		Locator element = page.locator(homeSection2Desc);
		element.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		element.scrollIntoViewIfNeeded();
		return getText(homeSection2Desc);
	}

	public List<String> getSection2BrandAltTexts() {
		Locator brandsList = page.locator(homeSection2brandsList);
		brandsList.evaluate("element => element.scrollIntoView()");

		Locator brandElements = page.locator(homeSection2brands);
		int count = brandElements.count();

		List<String> brandAltTexts = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			String altText = brandElements.nth(i).getAttribute("alt");
			brandAltTexts.add(altText);
		}
		return brandAltTexts;
	}

	public List<ReviewData> getSection4Reviews() {
		Locator reviewRatings = page.locator(homeSection4reviewRatings);
		int count = reviewRatings.count();

		List<ReviewData> reviews = new ArrayList<>();

		for (int i = 0; i < count; i++) {
			Locator item = reviewRatings.nth(i);
			String link = item.locator("//a").getAttribute("href");
			String header = item.locator("//p").textContent();
			String profile = item.locator("//span[contains(@class,'text text--xs')]").textContent();

			reviews.add(new ReviewData(link, header, profile));
		}
		return reviews;
	}

	public List<ReviewData> getSection5Reviews() {
		Locator reviewRatings = page.locator("[data-auto-id='home_section_5']");
		int count = reviewRatings.count();

		List<ReviewData> reviews = new ArrayList<>();

		for (int i = 0; i < count; i++) {
			Locator item = reviewRatings.nth(i);
			String link = item.locator("a").getAttribute("href");
			String profile = item.locator("span[class*='text text--l']").textContent();

			reviews.add(new ReviewData(link, null, profile));
		}
		return reviews;
	}

	public List<WhyLoginextCardData> getSection7WhyLoginextCards() {
		Locator whyLoginextcards = page.locator(homeSection7WhyLoginextCards);
		int count = whyLoginextcards.count();

		List<WhyLoginextCardData> whyLoginextcardlist = new ArrayList<>();

		for (int i = 0; i < count; i++) {
			Locator item = whyLoginextcards.nth(i);
			String link = item.getAttribute("href");
			String title = item.locator("h1").textContent();
			String description = item.locator("p").textContent();

			whyLoginextcardlist.add(new WhyLoginextCardData(link, title, description));
		}
		return whyLoginextcardlist;
	}

	public List<IndustryWeServeData> getSection8IndustriesWeServe() {
		List<IndustryWeServeData> industriesWeServeList = new ArrayList<>();

		Locator mainLocator = page.locator(homeSection8IndustriesWeServe);
		page.locator(homeSection8IndustriesWeServe).evaluate("element => element.scrollIntoView()");

		page.locator("[class='tabs tabs--tab-slider__industries']").evaluate("element => element.scrollIntoView()");
		Locator industriesWeServeTabs = mainLocator.locator("[class='tabs tabs--tab-slider__industries'] button");

		int tabsCount = industriesWeServeTabs.count();
		String tabTitle = null, imageText, imageTitle, imageDescription;
		String imageButton1Text, imageButton1Link, imageButton2Text, imageButton2Link;
		String tabBox1Title = null, tabBox2Title = null, tabBox3Title = null, tabBox4Title = null, tabBox5Title = null,
				tabBox6Title = null;

		for (int i = 0; i < tabsCount; i++) {
			Locator item = industriesWeServeTabs.nth(i);
			item.click();
			item.click();

			if (item.getAttribute("class").contains("active")) {
				tabTitle = item.textContent();
			}

			Locator tabData = page.locator("[class='tab-slider__industries-carousel']");
			tabData.evaluate("element => element.scrollIntoView()");

			imageText = tabData.locator("img").getAttribute("alt");
			imageTitle = tabData.locator("h1[data-auto-id='home_section_8_title']").textContent();
			imageDescription = tabData.locator("h1[data-auto-id='home_section_8_desc']").textContent();

			imageButton1Text = tabData.locator("a[class*='secondary']").textContent();
			imageButton1Link = tabData.locator("a[class*='secondary']").getAttribute("href");
			imageButton2Text = tabData.locator("a[class*='primary']").textContent();
			imageButton2Link = tabData.locator("a[class*='primary']").getAttribute("href");

			switch (tabTitle.toUpperCase()) {
			case "FOOD AND BEVERAGE":
				tabBox1Title = tabData.locator(homeSection8FoodBeverageBox1Title).textContent();
				tabBox2Title = tabData.locator(homeSection8FoodBeverageBox2Title).textContent();
				tabBox3Title = tabData.locator(homeSection8FoodBeverageBox3Title).textContent();
				tabBox4Title = tabData.locator(homeSection8FoodBeverageBox4Title).textContent();
				tabBox5Title = tabData.locator(homeSection8FoodBeverageBox5Title).textContent();
				tabBox6Title = tabData.locator(homeSection8FoodBeverageBox6Title).textContent();
				break;

			case "COURIER, EXPRESS AND PARCEL":
				tabBox1Title = tabData.locator(homeSection8CourierExpressParcelBox1Title).textContent();
				tabBox2Title = tabData.locator(homeSection8CourierExpressParcelBox2Title).textContent();
				tabBox3Title = tabData.locator(homeSection8CourierExpressParcelBox3Title).textContent();
				tabBox4Title = tabData.locator(homeSection8CourierExpressParcelBox4Title).textContent();
				tabBox5Title = tabData.locator(homeSection8CourierExpressParcelBox5Title).textContent();
				tabBox6Title = tabData.locator(homeSection8CourierExpressParcelBox6Title).textContent();
				break;
			case "CONSUMER PACKAGED GOODS":
				tabBox1Title = tabData.locator(homeSection8ConsumerPackagedGoodsBox1Title).textContent();
				tabBox2Title = tabData.locator(homeSection8ConsumerPackagedGoodsBox2Title).textContent();
				tabBox3Title = tabData.locator(homeSection8ConsumerPackagedGoodsBox3Title).textContent();
				tabBox4Title = tabData.locator(homeSection8ConsumerPackagedGoodsBox4Title).textContent();
				tabBox5Title = tabData.locator(homeSection8ConsumerPackagedGoodsBox5Title).textContent();
				tabBox6Title = tabData.locator(homeSection8ConsumerPackagedGoodsBox6Title).textContent();
				break;
			case "RETAIL AND ECOMMERCE":
				tabBox1Title = tabData.locator(homeSection8RetailEcommerceBox1Title).textContent();
				tabBox2Title = tabData.locator(homeSection8RetailEcommerceBox2Title).textContent();
				tabBox3Title = tabData.locator(homeSection8RetailEcommerceBox3Title).textContent();
				tabBox4Title = tabData.locator(homeSection8RetailEcommerceBox4Title).textContent();
				tabBox5Title = tabData.locator(homeSection8RetailEcommerceBox5Title).textContent();
				tabBox6Title = tabData.locator(homeSection8RetailEcommerceBox6Title).textContent();
				break;
			case "TRANSPORTATION AND LOGISTICS":
				tabBox1Title = tabData.locator(homeSection8TransportationLogisticsBox1Title).textContent();
				tabBox2Title = tabData.locator(homeSection8TransportationLogisticsBox2Title).textContent();
				tabBox3Title = tabData.locator(homeSection8TransportationLogisticsBox3Title).textContent();
				tabBox4Title = tabData.locator(homeSection8TransportationLogisticsBox4Title).textContent();
				tabBox5Title = tabData.locator(homeSection8TransportationLogisticsBox5Title).textContent();
				tabBox6Title = tabData.locator(homeSection8TransportationLogisticsBox6Title).textContent();
				break;
			}

			industriesWeServeList.add(new IndustryWeServeData(tabTitle, imageText, imageTitle, imageDescription,
					imageButton1Text, imageButton1Link, imageButton2Text, imageButton2Link, tabBox1Title, tabBox2Title,
					tabBox3Title, tabBox4Title, tabBox5Title, tabBox6Title));
		}
		return industriesWeServeList;
	}

	public List<AwardData> getSection11Awards() {
		page.locator(homeSection11).evaluate("element => element.scrollIntoView()");

		Locator awardReferences = page.locator(homeSection11awardReferences);
		int count = awardReferences.count();

		List<AwardData> awards = new ArrayList<>();

		for (int i = 0; i < count; i++) {
			Locator item = awardReferences.nth(i);
			String link = item.getAttribute("href");
			String text = item.getAttribute("aria-label");

			awards.add(new AwardData(link, text));
		}
		return awards;
	}

	public Page clickLoginLinkAndReturnNewTab() {
		return page.waitForPopup(() -> page.locator(login).click());
	}

	public boolean clickSignupAndVerifyPopupCloseButton() {
		page.locator(signup).waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		page.click(signup);

		Locator signUpPageCards = page.locator(signUpCards);

		int expectedCount = 4;
		int timeoutMs = 5000;
		int intervalMs = 200;
		int elapsed = 0;

		while (signUpPageCards.count() < expectedCount && elapsed < timeoutMs) {
			page.waitForTimeout(intervalMs);
			elapsed += intervalMs;
		}

		page.locator(signupClose).waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		return isVisible(signupClose);
	}

	public void clickSignupClose() {
		page.click(signupClose);
	}

	public List<SignUpCardData> getSignUpCards() {
		Locator signUpPageCards = page.locator(signUpCards);
		int count = signUpPageCards.count();

		List<SignUpCardData> signUpCards = new ArrayList<>();

		for (int i = 0; i < count; i++) {
			Locator item = signUpPageCards.nth(i);
			String company = item.locator(".platform-card__company").textContent();
			String title = item.locator(".platform-card__title").textContent();
			String companyDesc = item.locator("p").textContent();
			String button1_text = item.locator("button[class*='primary']").textContent();
			String button2_text = item.locator("button[class*='default']").textContent();
			String image_text = item.locator(".platform-card__image").getAttribute("alt");
			String image_link = item.locator(".platform-card__image").getAttribute("src");

			signUpCards.add(new SignUpCardData(company, title, companyDesc, button1_text, button2_text, image_text,
					image_link));
		}
		return signUpCards;
	}

	public String clickRedirectButton(String buttonLocator, String expectedUrl) {
		page.click(buttonLocator);
		page.waitForURL(expectedUrl);
		return page.url();
	}

	public String clickMileStartFreeTrial(String expectedUrl) {
		return clickRedirectButton(loginextMileStartFreeTrial, expectedUrl);
	}

	public String clickMilePricing(String expectedUrl) {
		return clickRedirectButton(loginextMilePricing, expectedUrl);
	}

	public String clickReverseStartFreeTrial(String expectedUrl) {
		return clickRedirectButton(loginextReverseStartFreeTrial, expectedUrl);
	}

	public String clickReversePricing(String expectedUrl) {
		return clickRedirectButton(loginextReversePricing, expectedUrl);
	}

	public String clickOnDemandStartFreeTrial(String expectedUrl) {
		return clickRedirectButton(loginextOnDemandStartFreeTrial, expectedUrl);
	}

	public String clickOnDemandPricing(String expectedUrl) {
		return clickRedirectButton(loginextOnDemandPricing, expectedUrl);
	}

	public String clickHaulStartFreeTrial(String expectedUrl) {
		return clickRedirectButton(loginextHaulStartFreeTrial, expectedUrl);
	}

	public String clickHaulPricing(String expectedUrl) {
		return clickRedirectButton(loginextHaulPricing, expectedUrl);
	}

	public void navigationFooterMenu() {
	      page.locator("#products").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("platform")).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("LogiNext Mile").setExact(true)).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("LogiNext Reverse").setExact(true)).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("LogiNext On-Demand").setExact(true)).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("LogiNext Haul").setExact(true)).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("LogiNext Driver app").setExact(true)).click();
	      page.locator("#industries").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Courier, Express and Parcel")).click();
	      page.locator("#industries").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Retail and eCommerce")).click();
	      page.locator("#industries").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Consumer Packaged Goods")).click();
	      page.locator("#industries").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Food and Beverage")).click();
	      page.locator("#industries").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Transportation and Logistics")).click();
	      page.locator("#usecase").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Pickup").setExact(true)).click();
	      page.locator("#usecase").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Delivery").setExact(true)).click();
	      page.locator("#usecase").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Pickup and Delivery")).click();
	      page.locator("#usecase").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Line Haul")).click();
	      page.locator("#usecase").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("End to End")).click();
	      page.locator("#resource").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Case Studies")).click();
//	      page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText(Pattern.compile("^resources$"))).click();
//	      page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Use cases$"))).click();
	      page.locator("#resource").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("White Papers")).click();
	      page.locator("#resource").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Infographics")).click();
	      page.locator("#resource").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Carbon Emission Calculator")).click();
//	      page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText(Pattern.compile("^join us$"))).click();
	      page.locator("#join-us").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Company Culture")).click();
	      page.locator("#join-us").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Interview Process")).click();
	      page.locator("#join-us").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Job Roles")).click();
//	      page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText(Pattern.compile("^company$"))).click();
	      page.locator("#company").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("About Us")).click();
	      page.locator("#company").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Contact Us")).click();
	      page.locator("#company").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("News and Media")).click();
	      page.locator("#company").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Site Map")).click();
	      page.locator("#support").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("API & Integrations")).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Customer Login")).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Trust")).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("End User License Agreement")).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Feature Gallery")).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Security")).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Live Tracking of Delivery")).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Efficient Route Optimization")).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Automated Pickups and Delivery")).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Delivery Schedule Planning")).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Elevate Your Deliveries with")).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Revolutionize Your Logistics")).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Transform Logistics with the")).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("The Ultimate Guide to Last")).click();
		
	}
	

}
