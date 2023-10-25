package com.health.dto;

public class SymptomPostDto {
	private int spKey;
	private int postNo;
	private int sympNo;
	
	
	public SymptomPostDto() {
		
	}
	public SymptomPostDto(int spKey, int postNo, int sympNo) {
		super();
		this.spKey = spKey;
		this.postNo = postNo;
		this.sympNo = sympNo;
	}
	public int getSpKey() {
		return spKey;
	}
	public void setSpKey(int spKey) {
		this.spKey = spKey;
	}
	public int getPostNo() {
		return postNo;
	}
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}
	public int getsympNo() {
		return sympNo;
	}
	public void setsympNo(int sympNo) {
		this.sympNo = sympNo;
	}
	
	
}
