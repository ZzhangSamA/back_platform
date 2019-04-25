package com.back.yxy.dto;

import com.back.yxy.pojo.Contact;
import com.back.yxy.pojo.Page;

import java.util.List;

public class ContactDto {

    private List<Contact> contactList;

    private Page page;

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "ContactDto{" +
                "contactList=" + contactList +
                ", page=" + page +
                '}';
    }
}
