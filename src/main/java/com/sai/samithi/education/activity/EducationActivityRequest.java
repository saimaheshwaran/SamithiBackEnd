package com.sai.samithi.education.activity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.NonNull;

@Builder
public record EducationActivityRequest(	
	@NonNull
	String name, 
	
	@NonNull
	String activity,
	
	@NonNull
	LocalDate publishedOn, 
	
	@NonNull
	LocalDateTime eventDateTime,
	
	@NonNull
	String details
) 
{

}
