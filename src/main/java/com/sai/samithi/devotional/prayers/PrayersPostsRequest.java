package com.sai.samithi.devotional.prayers;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.NonNull;

@Builder
public record PrayersPostsRequest(	
	@NonNull
	String name, 
	
	@NonNull
	String description,
	
	LocalDate publishedOn, 
	
	@NonNull
	LocalDateTime eventDateTime,
	
	@NonNull
	String url
) 
{

}
