package com.back.yxy.service.Impl;

import com.back.yxy.mapper.ContactMapper;
import com.back.yxy.pojo.Contact;
import com.back.yxy.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactMapper contactMapper;


    public int getTotalContact(Contact contact) {
        if(contact.getContent() != null) {
            contact.setContent("%"+contact.getContent()+"%");
        }else {
            contact.setContent("%%");
        }
        if(contact.getCreateTime() != null) {
            contact.setCreateTime("%"+contact.getCreateTime()+"%");
        }else {
            contact.setCreateTime("%%");
        }
        return contactMapper.getTotalContact(contact);
    }

    public int getContactCount(Contact contact) {
        if(contact.getContent() != null) {
            contact.setContent("%"+contact.getContent()+"%");
        }else {
            contact.setContent("%%");
        }
        if(contact.getCreateTime() != null) {
            contact.setCreateTime("%"+contact.getCreateTime()+"%");
        }else {
            contact.setCreateTime("%%");
        }
        return contactMapper.getTotalContact(contact);
    }

    public List<Contact> getContactList(Contact contact) {
        if(contact.getCreateTime() == null) {
            contact.setCreateTime("%%");
        }else {
            contact.setCreateTime("%"+contact.getCreateTime()+"%");
        }
        if(contact.getContent() == null) {
            contact.setContent("%%");
        }else {
            contact.setContent("%"+contact.getContent()+"%");
        }
        return contactMapper.getContactList(contact);
    }

    public int updateByPrimaryKeySelective(Contact record) {
        return contactMapper.updateByPrimaryKeySelective(record);
    }

    public int batchDel(String[] ids) {
        return contactMapper.batchDel(ids);
    }
}
