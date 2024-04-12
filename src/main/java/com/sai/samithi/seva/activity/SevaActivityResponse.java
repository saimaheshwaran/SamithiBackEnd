package com.sai.samithi.seva.activity;


import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class SevaActivityResponse {
	
	String name;
	
	String activity;
	
	LocalDate publishedOn;
	
	LocalDateTime eventDateTim;
	
	String details;
}

