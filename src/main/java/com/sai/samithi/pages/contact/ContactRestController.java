package com.sai.samithi.pages.contact;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import java.util.List;

@Slf4j
@RestController(value = "/contact")
public class ContactRestController {

    @Autowired
    ContactService contactService;

    @PostMapping
    public ResponseEntity<Contact> saveContact(@RequestBody @Valid ContactDTO contact) {
        return new ResponseEntity<>(contactService.add(contact), HttpStatus.OK);
    }

    @GetMapping
    public List<Contact> getAll() {
        return contactService.findAll();
    }
}
