package com.health.dto;

public class HitDto {

	private int hitKey;
	private int postNo;
	private String id;
	
	
	
	public HitDto() {

	}
	
	public HitDto(int hitKey, int postNo, String id) {
		super();
		this.hitKey = hitKey;
		this.postNo = postNo;
		this.id = id;
	}

	public int getHitKey() {
		return hitKey;
	}

	public void setHitKey(int hitKey) {
		this.hitKey = hitKey;
	}

	public int getPostNo() {
		return postNo;
	}

	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
