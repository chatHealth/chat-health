package com.health.dto;

public class ReplyDto {
	private int replyNo;
	private int commentNo;
	private int userNo;
	private String content;
	private String regDate;
	private String deletedDate;
	
	
	public ReplyDto() {
		
	};
	
	
	public ReplyDto(int replyNo, int commentNo, int userNo, String content, String regDate, String deletedDate) {
		super();
		this.replyNo = replyNo;
		this.commentNo = commentNo;
		this.userNo = userNo;
		this.content = content;
		this.regDate = regDate;
		this.deletedDate = deletedDate;
	}


	public int getReplyNo() {
		return replyNo;
	}


	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}


	public int getcommentNo() {
		return commentNo;
	}


	public void setcommentNo(int commentNo) {
		this.commentNo = commentNo;
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
