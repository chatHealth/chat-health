package com.health.dto;

public class PostPageDto extends PageDto{
    private int rNum;
    private int postNo;
    private String title;
    private String regDate;

    private int likes;

    private String postImg;

    public PostPageDto(int rNum, int postNo, String title, String regDate, int likes, String postImg) {
        this.rNum = rNum;
        this.postNo = postNo;
        this.title = title;
        this.regDate = regDate;
        this.likes = likes;
        this.postImg = postImg;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getPostImg() {
        return postImg;
    }

    public void setPostImg(String postImg) {
        this.postImg = postImg;
    }

    public PostPageDto() {
    }

    public int getrNum() {
        return rNum;
    }

    public void setrNum(int rNum) {
        this.rNum = rNum;
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

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }
}
