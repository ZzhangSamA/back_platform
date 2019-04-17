package com.back.yxy.pojo;

import java.util.Date;

public class BlogLabel {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog_label.label_id
     *
     * @mbggenerated
     */
    private Integer labelId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog_label.label_name
     *
     * @mbggenerated
     */
    private String labelName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog_label.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog_label.label_desc
     *
     * @mbggenerated
     */
    private String labelDesc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog_label.status
     *
     * @mbggenerated
     */
    private Boolean status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog_label.rank
     *
     * @mbggenerated
     */
    private Byte rank;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog_label.label_id
     *
     * @return the value of blog_label.label_id
     *
     * @mbggenerated
     */
    public Integer getLabelId() {
        return labelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog_label.label_id
     *
     * @param labelId the value for blog_label.label_id
     *
     * @mbggenerated
     */
    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog_label.label_name
     *
     * @return the value of blog_label.label_name
     *
     * @mbggenerated
     */
    public String getLabelName() {
        return labelName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog_label.label_name
     *
     * @param labelName the value for blog_label.label_name
     *
     * @mbggenerated
     */
    public void setLabelName(String labelName) {
        this.labelName = labelName == null ? null : labelName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog_label.create_time
     *
     * @return the value of blog_label.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog_label.create_time
     *
     * @param createTime the value for blog_label.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog_label.label_desc
     *
     * @return the value of blog_label.label_desc
     *
     * @mbggenerated
     */
    public String getLabelDesc() {
        return labelDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog_label.label_desc
     *
     * @param labelDesc the value for blog_label.label_desc
     *
     * @mbggenerated
     */
    public void setLabelDesc(String labelDesc) {
        this.labelDesc = labelDesc == null ? null : labelDesc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog_label.status
     *
     * @return the value of blog_label.status
     *
     * @mbggenerated
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog_label.status
     *
     * @param status the value for blog_label.status
     *
     * @mbggenerated
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog_label.rank
     *
     * @return the value of blog_label.rank
     *
     * @mbggenerated
     */
    public Byte getRank() {
        return rank;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog_label.rank
     *
     * @param rank the value for blog_label.rank
     *
     * @mbggenerated
     */
    public void setRank(Byte rank) {
        this.rank = rank;
    }
}