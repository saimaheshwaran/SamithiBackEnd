package com.sai.samithi.pages.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContactRestController {

    @Autowired
    ContactService contactService;

    @PostMapping("/contact/save")
    public ResponseEntity<Contact> saveContact(@RequestBody Contact contact) {
        return new ResponseEntity<Contact>(contactService.add(contact), HttpStatus.OK);
    }

    @GetMapping("/contact/getall")
    public List<Contact> getAll() {
        return contactService.findAll();
    }
}
