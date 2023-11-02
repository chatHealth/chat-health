package com.health.dto.personal;

import com.health.dto.PageDto;

public class MemberReviewPageDto extends PageDto {
    private int rNum;
    private String postImg;
    private int reviewNo;
    private int postNo;
    private String title;
    private int likes;
    private String regDate;
    private String postTitle;
    private String postDeletedDate;

    public MemberReviewPageDto(int rNum, String postImg, int reviewNo, int postNo, String title, int likes, String regDate, String postTitle, String postDeletedDate) {
        this.rNum = rNum;
        this.postImg = postImg;
        this.reviewNo = reviewNo;
        this.postNo = postNo;
        this.title = title;
        this.likes = likes;
        this.regDate = regDate;
        this.postTitle = postTitle;
        this.postDeletedDate = postDeletedDate;
    }

    public MemberReviewPageDto() {
    }

    public int getrNum() {
        return rNum;
    }

    public void setrNum(int rNum) {
        this.rNum = rNum;
    }

    public String getPostImg() {
        return postImg;
    }

    public void setPostImg(String postImg) {
        this.postImg = postImg;
    }

    public int getReviewNo() {
        return reviewNo;
    }

    public void setReviewNo(int reviewNo) {
        this.reviewNo = reviewNo;
    }

    public int getPostNo() {
        return postNo;
    }

    public void setPostNo(int postNo) {
        this.postNo = postNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostDeletedDate() {
        return postDeletedDate;
    }

    public void setPostDeletedDate(String postDeletedDate) {
        this.postDeletedDate = postDeletedDate;
    }
}
