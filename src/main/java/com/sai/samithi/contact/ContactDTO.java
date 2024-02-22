package com.sai.samithi.contact;


import com.sai.samithi.util.validator.annotation.Phone;

import jakarta.validation.constraints.Email;
import lombok.Builder;
import lombok.NonNull;

@Builder
public record ContactDTO(
	@NonNull
	String name, 
	
	@NonNull
	@Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
	String email, 
	
	@NonNull
	@Phone
	String phoneNumber, 
	
	@NonNull
	String subject, 
	
	@NonNull
	String message, 
	
	Status status 
) 
{
	
}
