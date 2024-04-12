package com.sai.samithi.education.team;

import java.time.LocalDate;
import lombok.Builder;
import lombok.NonNull;

@Builder
public record EducationTeamRequest(	
	@NonNull
	String name, 
	
	@NonNull
	LocalDate publishedOn, 
	
	@NonNull
	String role,
    
    @NonNull
    String contact,
	
	@NonNull
	String details
) 
{

}
