package com.sai.samithi.seva.activity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.NonNull;

@Builder
public record SevaActivityRequest(	
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
