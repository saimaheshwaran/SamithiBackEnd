package com.sai.samithi.devotional.prayers;


import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PrayerSPostsResponse {
	
	String name;
	
	String description;
	
	LocalDate publishedOn;
	
	LocalDateTime eventDateTime;
	
	String url;
}

