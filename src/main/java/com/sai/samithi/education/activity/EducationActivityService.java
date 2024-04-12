package com.sai.samithi.education.activity;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EducationActivityService {

    @Autowired
    EducationActivityRepository educationActivityRepository;
    
    @Autowired
    ModelMapper mapper;

    public EducationActivityResponse add(EducationActivityRequest educationActivityRequest) {
    	EducationActivity educationActivityDb = EducationActivity.builder()
    	.activity(educationActivityRequest.activity())
    	.name(educationActivityRequest.name())
    	.eventDateTime(educationActivityRequest.eventDateTime())
    	.details(educationActivityRequest.details())
    	.publishedOn(educationActivityRequest.publishedOn())
    	.build();
    	EducationActivity education = educationActivityRepository.save(educationActivityDb);
    	EducationActivityResponse educationResponse = mapper.map(education, EducationActivityResponse.class);
    	return educationResponse ;
    }

    public List<EducationActivityResponse> getAll() {
    	List<EducationActivity> educationDb = educationActivityRepository.findAll();
    	List<EducationActivityResponse> educationResponses = educationDb
     			.stream()
     			.map( education -> mapper.map(education, EducationActivityResponse.class))
     			.collect(Collectors.toList());
        return educationResponses;
    }
    
}
