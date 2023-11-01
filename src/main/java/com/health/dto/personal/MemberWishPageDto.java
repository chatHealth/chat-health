package com.health.dto.personal;

import com.health.dto.PageDto;

public class MemberWishPageDto extends PageDto {
    private int rNum;
    private int postNo;
    private String title;
    private String potImg;

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

    public String getPotImg() {
        return potImg;
    }

    public void setPotImg(String potImg) {
        this.potImg = potImg;
    }

    public MemberWishPageDto() {
    }

    public MemberWishPageDto(int rNum, int postNo, String title, String potImg) {
        this.rNum = rNum;
        this.postNo = postNo;
        this.title = title;
        this.potImg = potImg;
    }
}
