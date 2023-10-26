package com.health.dto;

public class IdCheckDto {
	private String memberId;
	private String enterId;
	
	public IdCheckDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public IdCheckDto(String memberId, String enterId) {
		super();
		this.memberId = memberId;
		this.enterId = enterId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getEnterId() {
		return enterId;
	}
	public void setEnterId(String enterId) {
		this.enterId = enterId;
	}
}
