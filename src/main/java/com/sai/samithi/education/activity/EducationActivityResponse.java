package com.sai.samithi.education.activity;


import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class EducationActivityResponse {
	
	String name;
	
	String activity;
	
	LocalDate publishedOn;
	
	LocalDateTime eventDateTim;
	
	String details;
}

