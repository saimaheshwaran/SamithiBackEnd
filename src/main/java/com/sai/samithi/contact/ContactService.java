package com.sai.samithi.contact;

import lombok.NoArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@NoArgsConstructor
@Service
public class ContactService {

    @Autowired
    ContactRepository contactRepository;

    public Contact add(ContactDTO contactDto) {
    	
    	Contact contactDB = Contact.builder()
    	.name(contactDto.name())
    	.message(contactDto.message())
    	.phone(contactDto.phone())
    	.email(contactDto.email())
    	.subject(contactDto.subject())
    	.status(Status.TBD)
    	.build();
    	
        return contactRepository.save(contactDB);
    }

    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

}

