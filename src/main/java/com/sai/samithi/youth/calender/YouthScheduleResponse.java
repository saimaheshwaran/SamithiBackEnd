package com.sai.samithi.youth.calender;


import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class YouthScheduleResponse {
	
	String name;
	
	String schedule;
	
	LocalDate publishedOn;
	
	LocalDateTime eventDateTim;
	
	String details;
}

