package com.health.dto;

public class EnterpriseDto {
    private int enterpriseNo;
    private String id;
    private String code;
    private String pw;
    private String name;
    private String profile;
    private String ceo;
    private String location;
    private String tel;
    private String acceptedDate;
    private String deletedDate;

    public int getEnterpriseNo() {
        return enterpriseNo;
    }

    public void setEnterpriseNo(int enterpriseNo) {
        this.enterpriseNo = enterpriseNo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getCeo() {
        return ceo;
    }

    public void setCeo(String ceo) {
        this.ceo = ceo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAcceptedDate() {
        return acceptedDate;
    }

    public void setAcceptedDate(String acceptedDate) {
        this.acceptedDate = acceptedDate;
    }

    public String getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(String deletedDate) {
        this.deletedDate = deletedDate;
    }

    public EnterpriseDto() {
        super();
        // TODO Auto-generated constructor stub
    }

    public EnterpriseDto(int enterpriseNo, String id, String code, String PW, String name, String profile, String ceo,
                         String location, String tel, String acceptedDate, String deletedDate) {
        super();
        this.enterpriseNo = enterpriseNo;
        this.id = id;
        this.code = code;
        this.pw = PW;
        this.name = name;
        this.profile = profile;
        this.ceo = ceo;
        this.location = location;
        this.tel = tel;
        this.acceptedDate = acceptedDate;
        this.deletedDate = deletedDate;
    }


}
