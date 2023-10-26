package com.health.dto;

public class MemberDto {
	private int userNo;
	private String nickName;
	private String id;
	private String pw;
	private String name;
	private String birthDate;
	private String gender;
	private String email;
	private String address;
	private String addressDetail;
	private String joinDate;
	private String profile;
	private String deletedDate;
	private int grade;
	
	
	public MemberDto() {
		
	}


	public MemberDto(int userNo, String nickName, String id, String pw, String name, String birthDate, String gender,
			String email, String address, String addressDetail, String joinDate, String profile, String deletedDate,
			int grade) {
		super();
		this.userNo = userNo;
		this.nickName = nickName;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.birthDate = birthDate;
		this.gender = gender;
		this.email = email;
		this.address = address;
		this.addressDetail = addressDetail;
		this.joinDate = joinDate;
		this.profile = profile;
		this.deletedDate = deletedDate;
		this.grade = grade;
	}


	public int getUserNo() {
		return userNo;
	}


	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}


	public String getNickName() {
		return nickName;
	}


	public void setNickName(String nickName) {
		this.nickName = nickName;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getAddressDetail() {
		return addressDetail;
	}


	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}


	public String getJoinDate() {
		return joinDate;
	}


	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}


	public String getProfile() {
		return profile;
	}


	public void setProfile(String profile) {
		this.profile = profile;
	}


	public String getDeletedDate() {
		return deletedDate;
	}


	public void setDeletedDate(String deletedDate) {
		this.deletedDate = deletedDate;
	}


	public int getGrade() {
		return grade;
	}


	public void setGrade(int grade) {
		this.grade = grade;
	}


	@Override
	public String toString() {
		return "MemberDto [userNo=" + userNo + ", nickName=" + nickName + ", id=" + id + ", pw=" + pw + ", name=" + name
				+ ", birthDate=" + birthDate + ", gender=" + gender + ", email=" + email + ", address=" + address
				+ ", addressDetail=" + addressDetail + ", joinDate=" + joinDate + ", profile=" + profile
				+ ", deletedDate=" + deletedDate + ", grade=" + grade + "]";
	}
	

	



}
