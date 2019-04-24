package com.back.yxy.service;

import com.back.yxy.pojo.Contact;

import java.util.List;

public interface ContactService {

    public int getTotalContact(Contact contact);

    public int getContactCount(Contact contact);

    public List<Contact> getContactList(Contact contact);

    int updateByPrimaryKeySelective(Contact record);

    public int batchDel(String[] ids);
}
