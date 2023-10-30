package com.health.dto;

public class HelpfulDto {

	private int helpKey;
	private int reviewNo;

	
	public HelpfulDto() {
		
	}
	public HelpfulDto(int helpKey, int reviewNo) {
		super();
		this.helpKey = helpKey;
		this.reviewNo = reviewNo;
	}
	public int getHelpKey() {
		return helpKey;
	}
	public void setHelpKey(int helpKey) {
		this.helpKey = helpKey;
	}
	public int getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}
	
	
	
}
