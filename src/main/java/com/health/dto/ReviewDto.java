package com.health.dto;

public class ReviewDto {
	private int reviewNo;
	private int userNo;
	private int postNo;
	private String title;
	private String content;
	private String regDate;
	private String deletedDate;
	
	
	
	public ReviewDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ReviewDto [reviewNo=" + reviewNo + ", userNo=" + userNo + ", postNo=" + postNo + ", title=" + title
				+ ", content=" + content + ", regDate=" + regDate  + ", deletedDate="
				+ deletedDate + "]";
	}
	public ReviewDto(int reviewNo, int userNo, int postNo, String title, String content, String regDate,
			String deletedDate) {
		super();
		this.reviewNo = reviewNo;
		this.userNo = userNo;
		this.postNo = postNo;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.deletedDate = deletedDate;
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
	public String getDeletedDate() {
		return deletedDate;
	}
	public void setDeletedDate(String deletedDate) {
		this.deletedDate = deletedDate;
	}

	
	
	
	
}
