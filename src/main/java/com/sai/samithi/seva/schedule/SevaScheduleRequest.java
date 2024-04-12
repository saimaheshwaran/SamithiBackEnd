package com.sai.samithi.seva.schedule;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.NonNull;

@Builder
public record SevaScheduleRequest(	
	@NonNull
	String name, 
	
	@NonNull
	String schedule,
	
	@NonNull
	LocalDate publishedOn, 
	
	@NonNull
	LocalDateTime eventDateTime,
	
	@NonNull
	String details
) 
{

}
