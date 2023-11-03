package com.health.dto;

public class ReviewDateDto {
	private int reviewNo;
	private int userNo;
	private int postNo;
	private String title;
	private String content;
	private String regDate;
	private String deletedDate;
	private String nickName;
	
	
	
	
	
	
	public ReviewDateDto() {
		super();
	}
	@Override
	public String toString() {
		return "ReviewDateDto [reviewNo=" + reviewNo + ", userNo=" + userNo + ", postNo=" + postNo + ", title=" + title
				+ ", content=" + content + ", regDate=" + regDate + ", deletedDate=" + deletedDate + ", nickName="
				+ nickName + ", helpfulCntl=" + helpfulCntl + "]";
	}
	public ReviewDateDto(int reviewNo, int userNo, int postNo, String title, String content, String regDate,
			String deletedDate, String nickName, int helpfulCntl) {
		super();
		this.reviewNo = reviewNo;
		this.userNo = userNo;
		this.postNo = postNo;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.deletedDate = deletedDate;
		this.nickName = nickName;
		this.helpfulCntl = helpfulCntl;
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
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getHelpfulCntl() {
		return helpfulCntl;
	}
	public void setHelpfulCntl(int helpfulCntl) {
		this.helpfulCntl = helpfulCntl;
	}
	private int helpfulCntl;
}
