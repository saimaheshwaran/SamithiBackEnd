package com.sai.samithi.youth.team;


import java.time.LocalDate;
import lombok.Data;

@Data
public class YouthTeamResponse {
	
	String name;
	
	String role;
	
	String contact;

	LocalDate publishedOn;
		
	String details;
}

