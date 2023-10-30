package com.health.dto;

public class UserLikeDto {
	private int likeKey;
	private int userNo;
	private int postNo;
	
	
	
	
	public UserLikeDto() {
	
	}

	public UserLikeDto(int likeKey, int userNo, int postNo) {
		super();
		this.likeKey = likeKey;
		this.userNo = userNo;
		this.postNo = postNo;
	}

	public int getLikeKey() {
		return likeKey;
	}

	public void setLikeKey(int likeKey) {
		this.likeKey = likeKey;
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
	
	
	
	
}
