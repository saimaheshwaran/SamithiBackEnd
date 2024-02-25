package com.sai.samithi.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/contact")
public class ContactRestController {

    @Autowired
    ContactService contactService;

    @PostMapping
    public ContactResponse saveContact(@RequestBody @Valid ContactRequest contact) {
        return contactService.add(contact);
    }

}
