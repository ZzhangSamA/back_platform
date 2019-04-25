package com.back.yh.vo;

import com.back.tools.SplitPage;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomerVo {
    private Integer customerId;

    private String customerName;

    private String name;

    private String email;

    private String birthday;

    private int sex;

    private String telephone;

    private String createTime;

    private int status;

    SplitPage splitPage;
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        if(birthday==null){
            this.birthday = null;
            return;
        }
        String dateStr = "";
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            dateStr = sdf.format(birthday);
        }catch(Exception e){
            e.printStackTrace();
        }

        this.birthday = dateStr;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        if(createTime==null){
            this.createTime = null;
            return;
        }
        String dateStr = "";
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            dateStr = sdf.format(createTime);
        }catch(Exception e){
            e.printStackTrace();
        }

        this.createTime = dateStr;
    }

    public SplitPage getSplitPage() {
        return splitPage;
    }

    public void setSplitPage(SplitPage splitPage) {
        this.splitPage = splitPage;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CustomerVo{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", sex=" + sex +
                ", telephone='" + telephone + '\'' +
                ", createTime=" + createTime +
                ", status=" + status +
                ", splitPage=" + splitPage +
                '}';
    }
}
