package com.health.dto;

public class MemberDto {
	private int userNo;
	private String nickname;
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
	

	
//getter&setter
	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		userNo = userNo;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		nickname = nickname;
	}

	public String getID() {
		return id;
	}

	public void setID(String iD) {
		id = iD;
	}

	public String getPW() {
		return pw;
	}

	public void setPW(String pW) {
		pw = pW;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		name = name;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		birthDate = birthDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		address = address;
	}

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		addressDetail = addressDetail;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		joinDate = joinDate;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		profile = profile;
	}

	public String getDeletedDate() {
		return deletedDate;
	}

	public void setDeletedDate(String deletedDate) {
		deletedDate = deletedDate;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		grade = grade;
	}

	public MemberDto() {
	}
public MemberDto(int userNo,String nickname,String id,String PW,String Name,String BirthDate,String Gender,String Email,String Address,String AddressDetail,String JoinDate,String Profile,String DeletedDate,int Grade) {
		super();
		this.userNo = userNo;
		this.nickname = nickname;
		this.id = id;
		this.pw = PW;
		this.name = Name;
		this.birthDate = BirthDate;
		this.gender = Gender;
		this.email = Email;
		this.address = Address;
		this.addressDetail = AddressDetail;
		this.profile = Profile;
		this.deletedDate = DeletedDate;
		this.grade = Grade;
	}
}
