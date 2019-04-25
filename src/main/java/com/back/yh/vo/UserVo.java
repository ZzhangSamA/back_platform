package com.back.yh.vo;

import com.back.tools.SplitPage;

import java.util.Date;

public class UserVo {
    private Integer userId;

    private String userName;

    private Integer userNumber;

    private String email;

    private String telephone;

    private Date createTime;

    private Integer status;

    SplitPage splitPage;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(Integer userNumber) {
        this.userNumber = userNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public SplitPage getSplitPage() {
        return splitPage;
    }

    public void setSplitPage(SplitPage splitPage) {
        this.splitPage = splitPage;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userNumber=" + userNumber +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", createTime=" + createTime +
                ", status=" + status +
                ", splitPage=" + splitPage +
                '}';
    }
}
