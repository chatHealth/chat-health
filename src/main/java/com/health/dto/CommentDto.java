package com.health.dto;

public class CommentDto {
	private int commentNo;
	private int reviewNo;
	private int userNo;
	private String content;
	private String regDate;
	private String deletedDate;
	
	
	
	public CommentDto() {
		
	};
	
	
	public CommentDto(int commentNo, int reviewNo, int userNo, String content, String regDate, String deletedDate) {
		super();
		this.commentNo = commentNo;
		this.reviewNo = reviewNo;
		this.userNo = userNo;
		this.content = content;
		this.regDate = regDate;
		this.deletedDate = deletedDate;
	}


	public int getCommentNo() {
		return commentNo;
	}


	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
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
