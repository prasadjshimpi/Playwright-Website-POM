package com.loginext.website.components.home;

public class SignUpCardData {
	private String company;
	private String title;
	private String companyDesc;
	private String button1_text;
	private String button2_text;
	private String image_text;
	private String image_link;

	public SignUpCardData(String company, String title, String companyDesc, String button1_text, String button2_text,
			String image_text, String image_link) {
		this.company = company;
		this.title = title;
		this.companyDesc = companyDesc;
		this.button1_text = button1_text;
		this.button2_text = button2_text;
		this.image_text = image_text;
		this.image_link = image_link;
	}

	public String getCompany() {
		return company;
	}

	public String getTitle() {
		return title;
	}

	public String getCompanyDesc() {
		return companyDesc;
	}

	public String getButton1_text() {
		return button1_text;
	}

	public String getButton2_text() {
		return button2_text;
	}

	public String getImage_text() {
		return image_text;
	}

	public String getImage_link() {
		return image_link;
	}

}
