package com.loginext.website.components.home;

public class ReviewData {
	private String link;
	private String header;
	private String profile;

	public ReviewData(String link, String header, String profile) {
		this.link = link;
		this.header = header;
		this.profile = profile;
	}

	public String getLink() {
		return link;
	}

	public String getHeader() {
		return header;
	}

	public String getProfile() {
		return profile;
	}
}
