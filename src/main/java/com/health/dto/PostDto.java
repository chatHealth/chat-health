package com.health.dto;

public class PostDto {
    private int postNo;
    private int enterpriseNo;
    private String title;
    private String content;
    private String postImg;
    private String regDate;
    private String deletedDate;

    public PostDto() {
        super();
    }

    public PostDto(int postNo, int enterpriseNo, String title, String content, String postImg,
                   String regDate, String deletedDate) {
        super();
        this.postNo = postNo;
        this.enterpriseNo = enterpriseNo;
        this.title = title;
        this.content = content;
        this.postImg = postImg;
        this.regDate = regDate;
        this.deletedDate = deletedDate;
    }

    public int getPostNo() {
        return postNo;
    }

    public void setPostNo(int postNo) {
        this.postNo = postNo;
    }

    public int getEnterpriseNo() {
        return enterpriseNo;
    }

    public void setEnterpriseNo(int enterpriseNo) {
        this.enterpriseNo = enterpriseNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPostImg() {
        return postImg;
    }

    public void setPostImg(String postImg) {
        this.postImg = postImg;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(String deletedDate) {
        this.deletedDate = deletedDate;
    }



}