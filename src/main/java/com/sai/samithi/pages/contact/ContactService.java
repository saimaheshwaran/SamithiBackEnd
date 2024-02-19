package com.sai.samithi.pages.contact;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Service
public class ContactService {

    @Autowired
    ContactRepository contactRepository;

    public Contact add(Contact contact) {
        contact.setCreatedAt(Date.from(Instant.now()));
        return contactRepository.save(contact);
    }

    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

}

