package com.health.dto;

public class MaterialPostNoDto {
	private int postNo;
	private String materialName;
	
	
	
	
	public MaterialPostNoDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "MaterialPost [postNo=" + postNo + ", materialName=" + materialName + "]";
	}
	public MaterialPostNoDto(int postNo, String materialName) {
		super();
		this.postNo = postNo;
		this.materialName = materialName;
	}
	public int getPostNo() {
		return postNo;
	}
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}
	public String getMaterialName() {
		return materialName;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	
	
	
	
	
	
	
	
	
	
	
}