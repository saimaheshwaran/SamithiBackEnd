package com.sai.samithi.contact;

import lombok.NoArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

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
        return mapper.map(contact, ContactResponse.class);
    }

	public List<ContactResponse> getAll() {
	 	List<Contact> contacts = contactRepository.findAll();
	 	List<ContactResponse> contactResponses = contacts
	 			.stream()
	 			.map( contact -> mapper.map(contact, ContactResponse.class))
	 			.collect(Collectors.toList());
		return contactResponses;
	}

}

