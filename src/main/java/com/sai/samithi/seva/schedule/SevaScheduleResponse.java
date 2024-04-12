package com.sai.samithi.seva.schedule;


import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class SevaScheduleResponse {
	
	String name;
	
	String schedule;
	
	LocalDate publishedOn;
	
	LocalDateTime eventDateTim;
	
	String details;
}

