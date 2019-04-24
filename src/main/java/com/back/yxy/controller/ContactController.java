package com.back.yxy.controller;

import com.back.yxy.dto.ContactDto;
import com.back.yxy.pojo.Contact;
import com.back.yxy.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactController {

    @Autowired
    ContactService contactService;

    @ResponseBody
    @RequestMapping(value = "getTotalContact",method = RequestMethod.GET)
    public int getTotalContact() {
        return contactService.getTotalContact(new Contact());
    }

    @ResponseBody
    @RequestMapping(value = "getContactCount",method = RequestMethod.POST)
    public int getContactCount(@RequestBody Contact contact) {
        return contactService.getContactCount(contact);
    }

    @ResponseBody
    @RequestMapping(value = "initContactPage",method = RequestMethod.POST)
    public Object initContactPage(@RequestBody(required = false)Contact contact) {
        if(contact.getPage() != null) {
            contact.getPage().setTotalCount(contactService.getTotalContact(contact));
        }
        ContactDto contactDto = new ContactDto();
        List<Contact> contactList = contactService.getContactList(contact);
        contactDto.setContactList(contactList);
        contactDto.setPage(contact.getPage());
        return contactDto;
    }

    @ResponseBody
    @RequestMapping(value = "readContact",method = RequestMethod.POST)
    public int readContact(@RequestBody Contact contact) {
        return contactService.updateByPrimaryKeySelective(contact);
    }

    @ResponseBody
    @RequestMapping(value = "batchDelContact",method = RequestMethod.POST)
    public int batchDel(@RequestBody String[] ids) {
        return contactService.batchDel(ids);
    }

    @ResponseBody
    @RequestMapping(value = "updateContactByPrimaryKeySelective",method = RequestMethod.POST)
    public int updateByPrimaryKeySelective(@RequestBody Contact contact) {
        return contactService.updateByPrimaryKeySelective(contact);
    }
}
