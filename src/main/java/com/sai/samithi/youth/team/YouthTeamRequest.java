package com.sai.samithi.youth.team;

import java.time.LocalDate;
import lombok.Builder;
import lombok.NonNull;

@Builder
public record YouthTeamRequest(	
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
