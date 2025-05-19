package com.loginext.website.constants;

public class HomePageConstants {
	public static final String HOME_PAGE_TITLE = "Streamline Deliveries with AI Logistics Software | LogiNext";
	public static final String HOME_PAGE_SECTION_1_TITLE_1 = "Deliver Smart.";
	public static final String HOME_PAGE_SECTION_1_TITLE_2 = "Deliver Fast.";
	public static final String HOME_PAGE_SECTION_1_DESC = "Automate your operations to deliver a satisfying customer experience, each time.";

	public static final String HOME_PAGE_SECTION_2_TITLE_1 = "LogiNext Empowers Brands";

	public static final String[] HOME_PAGE_SECTION_2_BRANDS = { "cargo-expreso", "singapore-post", "toyata",
			"mgm-bosco", "malta-post", "lion-parcel", "seven-eleven", "target", "lotus", "marko", "dmart", "nestle",
			"unilever", "pg", "heineken", "coca-cola", "true-value", "danone",  "kfc", "starbucks",
			"burger-king", "pizza-hut", "taco-bell", "baskin-robbin", "papa-johns", "dunkin-donuts", "agility",
			"apl-logistics", "lf-logistics", "mahindra-logistics", "rsa-global" };

	public static final String HOME_PAGE_SECTION_3_IMG_1_TEXT = "Gartner Insights";

	public record Review(String link, String header, String profile) {
	}

	public static final Review[] HOME_PAGE_SECTION_4_REVIEWS = { new Review(
			"https://www.gartner.com/reviews/market/vehicle-routing-and-scheduling-and-last-mile-technologies/vendor/loginext/product/loginext-mile/review/view/4009344",
			"Great Transportation Automation Platform",
			"Senior Domain Solutions Architect, 5B+ USD Transportation Services Firm"),
			new Review(
					"https://www.gartner.com/reviews/market/vehicle-routing-and-scheduling-and-last-mile-technologies/vendor/loginext/product/loginext-mile/review/view/3765630",
					"Most Extensive Logistics Automation Platform", "Chief Supply Chain Officer, 2B+ USD Retail Firm"),
			new Review(
					"https://www.gartner.com/reviews/market/vehicle-routing-and-scheduling-and-last-mile-technologies/vendor/loginext/product/loginext-mile/review/view/3779188",
					"Best Last Mile Logistics Optimization", "IT Manager, Global Fast Food Restaurant Chain"),
			new Review(
					"https://www.gartner.com/reviews/market/vehicle-routing-and-scheduling-and-last-mile-technologies/vendor/loginext/product/loginext-mile/review/view/3773106",
					"Best At Delivery Management & Route Planning",
					"Operations Head, North American Grocery Delivery Firm") };

	public static final String HOME_PAGE_SECTION_5_LINK = "https://www.gartner.com/reviews/market/vehicle-routing-and-scheduling-and-last-mile-technologies";
	public static final String HOME_PAGE_SECTION_5_LINK_DESC = "Top Rated In Vehicle Routing and Scheduling and Last-Mile Technologies";

	public static final String HOME_PAGE_SECTION_6_VIDEO_LINK = "/automated-order-life-cycle-video.mp4";
	public static final String HOME_PAGE_SECTION_6_TITLE = "Automate Your Order Lifecycle";
	public static final String HOME_PAGE_SECTION_6_DESC_1 = "Your customers expect faster deliveries, your operations manager deserves real time visibility across the supply chain, and your delivery drivers need a way to deliver shipments efficiently.";
	public static final String HOME_PAGE_SECTION_6_DESC_2 = "LogiNext empowers you to meet your customer expectations, gain visibility across all stages of pick-up and delivery, to stay ahead of your competition, and deliver a great customer experience.";
	public static final String HOME_PAGE_SECTION_6_VIDEO_TITLE = "Watch the video";
	public static final String HOME_PAGE_SECTION_6_VIDEO_BUTTON_TITLE = "play";

	public static final String HOME_PAGE_SECTION_7_TITLE = "Why Loginext?";

	public record WhyLoginextCard(String link, String title, String description) {
	}

	public static final WhyLoginextCard[] HOME_PAGE_SECTION_7_WHY_LOGINEXT_CARDS = {

			new WhyLoginextCard("/route-planning-software", "Comprehensive Route Planning and Dispatch Scheduling",
					"Traditional methods of dispatch scheduling and routing cannot support \n"
							+ "                      today’s customer expectations or your business growth aspirations. \n"
							+ "                          You need the best routing software to improve delivery times and reduce operational delays while efficiently managing your fleet and driver resources."),

			new WhyLoginextCard("/application-for-delivery-validation-through-ePOD", "The Best Customer Experience",
					"Customers’ expectations from brands have evolved significantly. \n"
							+ "                      They expect real time notifications and updates on their orders along with flexibility in terms of \n"
							+ "                      choosing a preferred delivery time window. Achieve competitive advantage by providing a comprehensive range of delivery options and precise ETA communication."),

			new WhyLoginextCard("/live-delivery-tracking-software", "Easy Real Time Tracking of Order Lifecycle",
					"Operations teams cannot deliver on your brand experience unless they have real time visibility across all aspects of the order lifecycle. \n"
							+ "                      Empower them with a flexible and comprehensive platform \n"
							+ "                        to meet your customer SLAs and your business KPIs.") };

	public record IndustryWeServe(String tabTitle, String imageText, String imageTitle, String imageDescription,
			String tabButton1Text, String tabButton1Link, String tabButton2Text, String tabButton2Link,
			String tabBox1Title, String tabBox2Title, String tabBox3Title, String tabBox4Title, String tabBox5Title,
			String tabBox6Title) {
	}

	public static final IndustryWeServe[] HOME_PAGE_SECTION_8_INDUSTRIES_WE_SERVE = { new IndustryWeServe(
			"FOOD AND BEVERAGE", "FOOD AND BEVERAGE", "FOOD AND BEVERAGE",
			"Fast deliveries with live order tracking are moving millennials and everyone else towards home deliveries of groceries and food leveraged by efficient route planning, \n"
					+ "            order sequencing, and auto-pickup and delivery allocation.",
			"Learn More", "/industries/food-and-beverages", "Download Case Study",
			"https://info.loginextsolutions.com/hubfs/Case_Studies_2022/CaseStudy_Delivery%20Driver%20Performance.pdf",

			"Restaurant Supplies & Distribution", "On-Demand Pickup Allocation & Dispatch",
			"Delivery Associate / Vehicle Management", "Live Order Tracking & Alerts", "Multiple Payment Options",
			"Fast Home Delivery with Customer Feedback"),
			new IndustryWeServe("COURIER, EXPRESS AND PARCEL", "COURIER, EXPRESS AND PARCEL",
					"COURIER, EXPRESS AND PARCEL",
					"Fast deliveries with live order tracking are moving millennials and everyone else towards home deliveries of groceries and food leveraged by efficient route planning, \n"
							+ "    order sequencing, and auto-pickup and delivery allocation.",
					"Learn More", "/industries/couriers-express-parcels", "Download Case Study",
					"https://info.loginextsolutions.com/hubfs/Case_Studies/CS_LN+CargoExpreso.pdf", "First Mile Pickup",
					"On-Demand / Same Day Delivery", "Middle Mile Management", "Multiple Pickup Delivery Optimization",
					"Special Handling / White Glove Delivery", "Last/Final Mile Delivery"),
			new IndustryWeServe("CONSUMER PACKAGED GOODS", "CONSUMER PACKAGED GOODS", "CONSUMER PACKAGED GOODS",
					"Seamless logistics movement across primary and secondary distribution with machine-learning \n"
							+ "                  enabled route planning, SKU movement tracking, proper scan-in and scan-out mechanisms, and delivery validation.",
					"Learn More", "/industries/consumer-package", "Download Case Study",
					"https://info.loginextsolutions.com/hubfs/Case_Studies_2022/CaseStudy_Delivery%20Driver%20Performance.pdf",
					"Primary Distribution Capacity Optimization", "Warehouse to Store Movement",
					"Delivery Associate / Vehicle Management", "Shipment & Unit Level Tracking",
					"Sales Schedule & Journey Optimization", "Temperature Controlled Transport"),
			new IndustryWeServe("RETAIL AND eCOMMERCE", "RETAIL AND eCOMMERCE", "RETAIL AND eCOMMERCE",
					"Rapidly increasing market preferences require fast, even same-day shipments,\n"
							+ "                 enabled through efficient last mile delivery optimization between wholesalers, depots, retailers, and end-customers.",
					"Learn More", "/industries/retail-and-ecommerce", "Download Case Study",
					"https://info.loginextsolutions.com/hubfs/Case_Studies_2022/Case%20Study_Decathlon_Haul.pdf",

					"Primary Distribution Capacity Optimization", "Warehouse to Store Movement",
					"Store to Customer Movement", "Same Day / Next Day Delivery", "Omnichannel Distribution",
					"End-To-End Package Tracking"),
			new IndustryWeServe("TRANSPORTATION AND LOGISTICS", "TRANSPORTATION AND LOGISTICS",
					"TRANSPORTATION AND LOGISTICS",
					"High capacity and resource utilization is the key to create value in freight and transport management with \n"
							+ "                competitive rates, better route planning, driver behavior tracking, SLA compliance, and error-free invoicing.",
					"Learn More", "/industries/transportation-software", "Download Case Study",
					"https://info.loginextsolutions.com/hubfs/Case_Studies_2022/CSLite_LN+Trucking.pdf",

					"Hub-Load Balancing", "Warehouse to Store Movement", "Rate & Contract Management",
					"Driver Behavior Management", "Middle Mile Management", "Cold Chain Logistics Management")

	};

	public static final String HOME_PAGE_SECTION_8_TITLE = "Industries We Serve";

	public static final String HOME_PAGE_SECTION_9_TITLE = "Easy Integrations";
	public static final String HOME_PAGE_SECTION_9_DESC = "Seamless and almost-instant integration with all enterprise resource planning suites across the board such as warehousing, order planning, transport management, payments, mapping, and more.";
	public static final String HOME_PAGE_SECTION_9_BUTTON_TEXT = "CHECK IT OUT";
	public static final String HOME_PAGE_SECTION_9_BUTTON_LINK = "/integration";

	public static final String HOME_PAGE_SECTION_9_CARD_Main_IMAGE_TEXT = "LogiNext solutions";

	public static final String HOME_PAGE_SECTION_9_CARD_1_IMAGE_TEXT = "CRM";
	public static final String HOME_PAGE_SECTION_9_CARD_1_IMAGE_LINK = "/integration";

	public static final String HOME_PAGE_SECTION_9_CARD_1_1_IMAGE_TEXT = "Salesforce";
	public static final String HOME_PAGE_SECTION_9_CARD_1_1_IMAGE_LINK = "/integration/salesforce";
	public static final String HOME_PAGE_SECTION_9_CARD_1_2_IMAGE_TEXT = "Zoho";
	public static final String HOME_PAGE_SECTION_9_CARD_1_2_IMAGE_LINK = "/integration/zoho";
	public static final String HOME_PAGE_SECTION_9_CARD_1_3_IMAGE_TEXT = "Microsoft Dynamics";
	public static final String HOME_PAGE_SECTION_9_CARD_1_3_IMAGE_LINK = "/integration/microsoft-dynamics";

	public static final String HOME_PAGE_SECTION_9_CARD_2_IMAGE_TEXT = "SMS";
	public static final String HOME_PAGE_SECTION_9_CARD_2_IMAGE_LINK = "/integration";

	public static final String HOME_PAGE_SECTION_9_CARD_2_1_IMAGE_TEXT = "Twilio";
	public static final String HOME_PAGE_SECTION_9_CARD_2_1_IMAGE_LINK = "/integration/twilio";
	public static final String HOME_PAGE_SECTION_9_CARD_2_2_IMAGE_TEXT = "Solutions Infini";
	public static final String HOME_PAGE_SECTION_9_CARD_2_2_IMAGE_LINK = "/integration/solutions-infini";

	public static final String HOME_PAGE_SECTION_9_CARD_3_IMAGE_TEXT = "OMS";
	public static final String HOME_PAGE_SECTION_9_CARD_3_IMAGE_LINK = "/integration";

	public static final String HOME_PAGE_SECTION_9_CARD_3_1_IMAGE_TEXT = "Magento";
	public static final String HOME_PAGE_SECTION_9_CARD_3_1_IMAGE_LINK = "/integration/Magento";
	public static final String HOME_PAGE_SECTION_9_CARD_3_2_IMAGE_TEXT = "Shopify";
	public static final String HOME_PAGE_SECTION_9_CARD_3_2_IMAGE_LINK = "/integration/Shopify";
	public static final String HOME_PAGE_SECTION_9_CARD_3_3_IMAGE_TEXT = "Capillary Martjack";
	public static final String HOME_PAGE_SECTION_9_CARD_3_3_IMAGE_LINK = "/integration/Capillary-Martjack";
	public static final String HOME_PAGE_SECTION_9_CARD_3_4_IMAGE_TEXT = "IBM Watson Commerce";
	public static final String HOME_PAGE_SECTION_9_CARD_3_4_IMAGE_LINK = "/integration/IBM-Watson-Commerce";
	public static final String HOME_PAGE_SECTION_9_CARD_3_5_IMAGE_TEXT = "SAP Hybris";
	public static final String HOME_PAGE_SECTION_9_CARD_3_5_IMAGE_LINK = "/integration/SAP-Hybris";

	public static final String HOME_PAGE_SECTION_9_CARD_4_IMAGE_TEXT = "CLOUD";
	public static final String HOME_PAGE_SECTION_9_CARD_4_IMAGE_LINK = "/integration";

	public static final String HOME_PAGE_SECTION_9_CARD_4_1_IMAGE_TEXT = "Amazon web services";
	public static final String HOME_PAGE_SECTION_9_CARD_4_1_IMAGE_LINK = "/integration/amazon-web-services";
	public static final String HOME_PAGE_SECTION_9_CARD_4_2_IMAGE_TEXT = "Alibaba cloud";
	public static final String HOME_PAGE_SECTION_9_CARD_4_2_IMAGE_LINK = "/integration/alibaba-cloud";
	public static final String HOME_PAGE_SECTION_9_CARD_4_3_IMAGE_TEXT = "Microsoft azure";
	public static final String HOME_PAGE_SECTION_9_CARD_4_3_IMAGE_LINK = "/integration/microsoft-azure";
	public static final String HOME_PAGE_SECTION_9_CARD_4_4_IMAGE_TEXT = "IBM Cloud";
	public static final String HOME_PAGE_SECTION_9_CARD_4_4_IMAGE_LINK = "/integration/IBM-cloud";

	public static final String HOME_PAGE_SECTION_9_CARD_5_IMAGE_TEXT = "ERP";
	public static final String HOME_PAGE_SECTION_9_CARD_5_IMAGE_LINK = "/integration";

	public static final String HOME_PAGE_SECTION_9_CARD_5_1_IMAGE_TEXT = "Oracle";
	public static final String HOME_PAGE_SECTION_9_CARD_5_1_IMAGE_LINK = "/integration/oracle";

	public static final String HOME_PAGE_SECTION_9_CARD_6_IMAGE_TEXT = "HARDWARE";
	public static final String HOME_PAGE_SECTION_9_CARD_6_IMAGE_LINK = "/integration";

	public static final String HOME_PAGE_SECTION_9_CARD_6_1_IMAGE_TEXT = "Concox";
	public static final String HOME_PAGE_SECTION_9_CARD_6_1_IMAGE_LINK = "/integration/concox";
	public static final String HOME_PAGE_SECTION_9_CARD_6_2_IMAGE_TEXT = "Trimble";
	public static final String HOME_PAGE_SECTION_9_CARD_6_2_IMAGE_LINK = "/integration/trimble";

	public static final String HOME_PAGE_SECTION_9_CARD_7_IMAGE_TEXT = "WMS";
	public static final String HOME_PAGE_SECTION_9_CARD_7_IMAGE_LINK = "/integration";

	public static final String HOME_PAGE_SECTION_9_CARD_7_1_IMAGE_TEXT = "Grey Orange";
	public static final String HOME_PAGE_SECTION_9_CARD_7_1_IMAGE_LINK = "/integration/grey-orange";
	public static final String HOME_PAGE_SECTION_9_CARD_7_2_IMAGE_TEXT = "JDA Warehouse Management";
	public static final String HOME_PAGE_SECTION_9_CARD_7_2_IMAGE_LINK = "/integration/jda-warehoues-management";

	public static final String HOME_PAGE_SECTION_9_CARD_8_IMAGE_TEXT = "PAYMENT";
	public static final String HOME_PAGE_SECTION_9_CARD_8_IMAGE_LINK = "/integration";

	public static final String HOME_PAGE_SECTION_9_CARD_8_1_IMAGE_TEXT = "Paytm";
	public static final String HOME_PAGE_SECTION_9_CARD_8_1_IMAGE_LINK = "/integration/paytm";
	public static final String HOME_PAGE_SECTION_9_CARD_8_2_IMAGE_TEXT = "M Swipe";
	public static final String HOME_PAGE_SECTION_9_CARD_8_2_IMAGE_LINK = "/integration/mswipe";
	public static final String HOME_PAGE_SECTION_9_CARD_8_3_IMAGE_TEXT = "Mosambee";
	public static final String HOME_PAGE_SECTION_9_CARD_8_3_IMAGE_LINK = "/integration/mosambee";
	public static final String HOME_PAGE_SECTION_9_CARD_8_4_IMAGE_TEXT = "Momoe";
	public static final String HOME_PAGE_SECTION_9_CARD_8_4_IMAGE_LINK = "/integration/momoe";
	public static final String HOME_PAGE_SECTION_9_CARD_8_5_IMAGE_TEXT = "Midtrans";
	public static final String HOME_PAGE_SECTION_9_CARD_8_5_IMAGE_LINK = "/integration/midtrans";

	public static final String HOME_PAGE_SECTION_9_CARD_9_IMAGE_TEXT = "TMS";
	public static final String HOME_PAGE_SECTION_9_CARD_9_IMAGE_LINK = "/integration";

	public static final String HOME_PAGE_SECTION_9_CARD_9_1_IMAGE_TEXT = "SAP";
	public static final String HOME_PAGE_SECTION_9_CARD_9_1_IMAGE_LINK = "/integration/sap";
	public static final String HOME_PAGE_SECTION_9_CARD_9_2_IMAGE_TEXT = "Oracle Transportation Management (OTM)";
	public static final String HOME_PAGE_SECTION_9_CARD_9_2_IMAGE_LINK = "/integration/oracle-transportation-management";

	public static final String HOME_PAGE_SECTION_9_CARD_10_IMAGE_TEXT = "MAP";
	public static final String HOME_PAGE_SECTION_9_CARD_10_IMAGE_LINK = "/integration";

	public static final String HOME_PAGE_SECTION_9_CARD_10_1_IMAGE_TEXT = "Google";
	public static final String HOME_PAGE_SECTION_9_CARD_10_1_IMAGE_LINK = "/integration/google";
	public static final String HOME_PAGE_SECTION_9_CARD_10_2_IMAGE_TEXT = "Here Maps";
	public static final String HOME_PAGE_SECTION_9_CARD_10_2_IMAGE_LINK = "/integration/here-map";
	public static final String HOME_PAGE_SECTION_9_CARD_10_3_IMAGE_TEXT = "Open Street Map";
	public static final String HOME_PAGE_SECTION_9_CARD_10_3_IMAGE_LINK = "/integration/osm";

	public static final String HOME_PAGE_SECTION_9_CARD_11_IMAGE_TEXT = "CARRIERS";
	public static final String HOME_PAGE_SECTION_9_CARD_11_IMAGE_LINK = "/integration";

	public static final String HOME_PAGE_SECTION_9_CARD_11_1_IMAGE_TEXT = "Pando Go";
	public static final String HOME_PAGE_SECTION_9_CARD_11_1_IMAGE_LINK = "/integration/Pandago";
	public static final String HOME_PAGE_SECTION_9_CARD_11_2_IMAGE_TEXT = "Grab";
	public static final String HOME_PAGE_SECTION_9_CARD_11_2_IMAGE_LINK = "/integration/Grab";
	public static final String HOME_PAGE_SECTION_9_CARD_11_3_IMAGE_TEXT = "DHL";
	public static final String HOME_PAGE_SECTION_9_CARD_11_3_IMAGE_LINK = "/integration/DHL";
	public static final String HOME_PAGE_SECTION_9_CARD_11_4_IMAGE_TEXT = "FedEx";
	public static final String HOME_PAGE_SECTION_9_CARD_11_4_IMAGE_LINK = "/integration/FedEx";
	public static final String HOME_PAGE_SECTION_9_CARD_11_5_IMAGE_TEXT = "Order In";
	public static final String HOME_PAGE_SECTION_9_CARD_11_5_IMAGE_LINK = "/integration/Orderin";
	public static final String HOME_PAGE_SECTION_9_CARD_11_6_IMAGE_TEXT = "Uber Eats";
	public static final String HOME_PAGE_SECTION_9_CARD_11_6_IMAGE_LINK = "/integration/Uber-Eats";

	public static final String HOME_PAGE_SECTION_9_CARD_12_IMAGE_TEXT = "EMAIL";
	public static final String HOME_PAGE_SECTION_9_CARD_12_IMAGE_LINK = "/integration";

	public static final String HOME_PAGE_SECTION_9_CARD_12_1_IMAGE_TEXT = "SendGrid";
	public static final String HOME_PAGE_SECTION_9_CARD_12_1_IMAGE_LINK = "/integration/sendgrid";

	public static final String HOME_PAGE_SECTION_10_BUTTON_1_TITLE = "SCHEDULE A DEMO";
	public static final String HOME_PAGE_SECTION_10_BUTTON_2_TITLE = "SIGN UP";

	public record Award(String text, String link) {
	}

	public static final Award[] HOME_PAGE_SECTION_11_AWARDS = { new Award("deloitte",
			"https://www.loginextsolutions.com/blog/deloitte-inc-forbes-financial-times-statista-freightwaves-name-loginext-fastest-growing-tech-company/"),
			new Award("forbes",
					"https://www.forbesindia.com/article/30-under-30-2017/dhruvil-sanghvi-is-working-to-make-loginext-the-google-of-supplychain-logistics/45877/1"),
//			new Award("gartner", "awards__reference-item awards__reference-item--gartner"),
//			new Award("IBM", "awards__reference-item awards__reference-item--ibm"),
			new Award("gartner", "https://www.gartner.com/reviews/market/transportation-management-systems/vendor/loginext/product/loginext-mile") };

	public record SignUpCard(String company, String title, String companyDesc, String button1_text, String button2_text,
			String image_text, String image_link) {
	};

	public static final SignUpCard[] SIGN_UP_CARDS = { new SignUpCard("LOGINEXT", "mileTM",
			"Optimize and automate pick-up, planning, scheduling and routing for efficient delivery operations.",
			"Start Free Trial", "Pricing", "mile", "/_next/static/media/product-mile.da81cdc6.svg"),
			new SignUpCard("LOGINEXT", "reverseTM",
					"Reliably optimize reverse pickups including return-to-merchant (RTM) and return-to-origin (RTO) scenarios with the best reverse logistics solutions.",
					"Start Free Trial", "Pricing", "reverse", "/_next/static/media/product-reverse.8a6f58ee.svg"),
			new SignUpCard("LOGINEXT", "on-demandTM",
					"Faster and better on-time pickups and deliveries using our enhanced route planning and auto delivery allocation software.",
					"Start Free Trial", "Pricing", "on-demand", "/_next/static/media/product-on-demand.2870f7e5.svg"),
			new SignUpCard("LOGINEXT", "haulTM",
					"Get the best Transportation Optimization platform to gain end to end visibility over your logistical operations, avoid supply chain hiccups and lower overall transportation costs.",
					"Start Free Trial", "Pricing", "haul", "/_next/static/media/product-haul.f39905e9.svg") };

}
