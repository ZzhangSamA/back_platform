package com.back.yxy.mapper;

import com.back.yxy.pojo.Contact;

public interface ContactMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table contact
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer contactId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table contact
     *
     * @mbggenerated
     */
    int insert(Contact record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table contact
     *
     * @mbggenerated
     */
    int insertSelective(Contact record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table contact
     *
     * @mbggenerated
     */
    Contact selectByPrimaryKey(Integer contactId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table contact
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Contact record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table contact
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(Contact record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table contact
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Contact record);
}