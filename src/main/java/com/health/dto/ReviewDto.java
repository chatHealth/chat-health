package com.health.dto;

public class ReviewDto {
	private int reviewNo;
	private int userNo;
	private int postNo;
	private String title;
	private String content;
	private String regDate;
	private String helpful;
	private String deletedDate;
	
	
	public ReviewDto() {
		
	};
	
	public ReviewDto(int reviewNo, int userNo, int postNo, String title, String content, String regDate, String helpful,
			String deletedDate) {
		super();
		this.reviewNo = reviewNo;
		this.userNo = userNo;
		this.postNo = postNo;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.helpful = helpful;
		this.deletedDate = deletedDate;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public int getuserNo() {
		return userNo;
	}

	public void setuserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getPostNo() {
		return postNo;
	}

	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getHelpful() {
		return helpful;
	}

	public void setHelpful(String helpful) {
		this.helpful = helpful;
	}

	public String getDeletedDate() {
		return deletedDate;
	}

	public void setDeletedDate(String deletedDate) {
		this.deletedDate = deletedDate;
	}

	
	
	
	
	
	
	
	
}
