package com.sai.samithi.contact;

import lombok.NoArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@NoArgsConstructor
@Service
public class ContactService {

    @Autowired
    ContactRepository contactRepository;
    
    @Autowired
    ModelMapper mapper;

    public ContactResponse add(ContactRequest contactDto) {
    	
    	Contact contactDB = Contact.builder()
    	.name(contactDto.name())
    	.message(contactDto.message())
    	.phoneNumber(contactDto.phoneNumber())
    	.email(contactDto.email())
    	.subject(contactDto.subject())
    	.status(Status.TBD)
    	.build();
    	
    	Contact contact = contactRepository.save(contactDB);
        
    	mapper.map(contact, ContactResponse.class);
        return mapper.map(contact, ContactResponse.class);
    }

	public List<Contact> getAll() {
		return contactRepository.findAll();
	}

}

