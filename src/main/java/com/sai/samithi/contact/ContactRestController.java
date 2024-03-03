package com.sai.samithi.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactRestController {

    @Autowired
    ContactService contactService;

    @PostMapping
    public ContactResponse saveContact(@RequestBody @Valid ContactRequest contact) {
        return contactService.add(contact);
    }

    @GetMapping
    public List<Contact> getAll() {
        return contactService.getAll();
    }

}
