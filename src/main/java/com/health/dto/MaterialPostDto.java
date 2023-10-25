package com.health.dto;

public class MaterialPostDto {
	private int mpKey;
	private int materialNo;
	private int postNo;
	
	public MaterialPostDto() {
		
	}
	public MaterialPostDto(int mpKey, int materialNo, int postNo) {
		super();
		this.mpKey = mpKey;
		this.materialNo = materialNo;
		this.postNo = postNo;
	}
	public int getMpKey() {
		return mpKey;
	}
	public void setMpKey(int mpKey) {
		this.mpKey = mpKey;
	}
	public int getMaterialNo() {
		return materialNo;
	}
	public void setMaterialNo(int materialNo) {
		this.materialNo = materialNo;
	}
	public int getPostNo() {
		return postNo;
	}
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}
	
	
}
