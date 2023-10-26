package com.health.dto;

public class ReplyDto {
	private int replyNo;
	private int commentNo2;
	private int userNo;
	private String content;
	private String regDate;
	private String deletedDate;
	private int commentNo;
	
	
	public ReplyDto() {
		
	};
	
	
	public ReplyDto(int replyNo, int commentNo2, int userNo, String content, String regDate, String deletedDate,
			int commentNo) {
		super();
		this.replyNo = replyNo;
		this.commentNo2 = commentNo2;
		this.userNo = userNo;
		this.content = content;
		this.regDate = regDate;
		this.deletedDate = deletedDate;
		this.commentNo = commentNo;
	}


	public int getReplyNo() {
		return replyNo;
	}


	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}


	public int getCommentNo2() {
		return commentNo2;
	}


	public void setCommentNo2(int commentNo2) {
		this.commentNo2 = commentNo2;
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


	public int getCommentNo() {
		return commentNo;
	}


	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}
	
	
	
	
}
