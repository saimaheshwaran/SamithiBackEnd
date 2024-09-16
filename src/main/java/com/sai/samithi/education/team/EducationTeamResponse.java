package com.sai.samithi.education.team;


import java.time.LocalDate;
import lombok.Data;

@Data
public class EducationTeamResponse {
	
	String name;
	
	String role;
	
	String contact;

	LocalDate publishedOn;
		
	String details;
}

