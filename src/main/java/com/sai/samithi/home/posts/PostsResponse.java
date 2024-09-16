package com.sai.samithi.home.posts;


import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PostsResponse {
	
	String name;
	
	String description;
	
	LocalDate publishedOn;
	
	LocalDateTime eventDateTime;
	
	String url;
}

