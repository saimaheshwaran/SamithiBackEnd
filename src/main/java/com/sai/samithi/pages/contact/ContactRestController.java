package com.sai.samithi.pages.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactRestController {

    @Autowired
    ContactService contactService;
}
