package com.sai.samithi.contact;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/contact")
public class ContactRestController {

    @Autowired
    ContactService contactService;

    @PostMapping
    @ResponseBody
    public Contact saveContact(@RequestBody @Valid ContactDTO contact) {
        return contactService.add(contact);
    }

    @GetMapping
    public List<Contact> getAll() {
        return contactService.findAll();
    }
}
