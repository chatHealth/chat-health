package com.health.dto;

public class SymptomDto {
	private int sympNo;
	private String symptomName;

	public SymptomDto() {
		
	}

	public SymptomDto(int sympNo, String symptomName) {
		super();
		this.sympNo = sympNo;
		this.symptomName = symptomName;
	}

	public int getSympNo() {
		return sympNo;
	}

	public void setSympNo(int sympNo) {
		this.sympNo = sympNo;
	}

	public String getSymptomName() {
		return symptomName;
	}

	public void setSymptomName(String symptomName) {
		this.symptomName = symptomName;
	}

}
