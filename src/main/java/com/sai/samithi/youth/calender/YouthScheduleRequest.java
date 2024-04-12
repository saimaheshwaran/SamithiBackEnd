package com.sai.samithi.youth.calender;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.NonNull;

@Builder
public record YouthScheduleRequest(	
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
