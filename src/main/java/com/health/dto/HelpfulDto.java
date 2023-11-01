package com.health.dto;

public class HelpfulDto {

	private int helpKey;
	private int reviewNo;
	private int userNo;
	
	public HelpfulDto() {
		
	}
	

	public HelpfulDto(int helpKey, int reviewNo, int userNo) {
		super();
		this.helpKey = helpKey;
		this.reviewNo = reviewNo;
		this.userNo = userNo;
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

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	
	
	
}
