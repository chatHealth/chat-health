package com.health.dto;

public class MaterialDto {
	private int materialNo;
	private String materialName;
	private String highLimit;
	private String lowLimit;
	private String unit;
	private String recognition;
	private String caution;
	private String functions;
	
	public MaterialDto() {
		
	}

	public MaterialDto(int materialNo, String materialName, String highLimit, String lowLimit, String unit,
			String recognition, String caution, String functions) {
		super();
		this.materialNo = materialNo;
		this.materialName = materialName;
		this.highLimit = highLimit;
		this.lowLimit = lowLimit;
		this.unit = unit;
		this.recognition = recognition;
		this.caution = caution;
		this.functions = functions;
	}

	public int getMaterialNo() {
		return materialNo;
	}

	public void setMaterialNo(int materialNo) {
		this.materialNo = materialNo;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public String getHighLimit() {
		return highLimit;
	}

	public void setHighLimit(String highLimit) {
		this.highLimit = highLimit;
	}

	public String getLowLimit() {
		return lowLimit;
	}

	public void setLowLimit(String lowLimit) {
		this.lowLimit = lowLimit;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getRecognition() {
		return recognition;
	}

	public void setRecognition(String recognition) {
		this.recognition = recognition;
	}

	public String getCaution() {
		return caution;
	}

	public void setCaution(String caution) {
		this.caution = caution;
	}

	public String getFunctions() {
		return functions;
	}

	public void setFunctions(String functions) {
		this.functions = functions;
	}
	
	
	
}
