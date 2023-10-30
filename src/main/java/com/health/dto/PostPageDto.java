package com.health.dto;

public class PostPageDto {
    private int rowNum;
    private int postNo;
    private String title;
    private String regDate;

    public PostPageDto(int rowNum, int postNo, String title, String regDate) {
        this.rowNum = rowNum;
        this.postNo = postNo;
        this.title = title;
        this.regDate = regDate;
    }

    public PostPageDto() {
    }

    public int getPostNo() {
        return postNo;
    }

    public void setPostNo(int postNo) {
        this.postNo = postNo;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public int getRowNum() {
        return rowNum;
    }

    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
