package com.sai.samithi.seva.activity;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SevaActivityService {

    @Autowired
    SevaActivityRepository sevaActivityRepository;
    
    @Autowired
    ModelMapper mapper;

    public SevaActivityResponse addSevaActivity(SevaActivityRequest sevaActivityRequest) {
    	SevaActivity sevaActivityDb = SevaActivity.builder()
    	.activity(sevaActivityRequest.activity())
    	.name(sevaActivityRequest.name())
    	.eventDateTime(sevaActivityRequest.eventDateTime())
    	.details(sevaActivityRequest.details())
    	.publishedOn(sevaActivityRequest.publishedOn())
    	.build();
    	SevaActivity seva = sevaActivityRepository.save(sevaActivityDb);
    	SevaActivityResponse sevaResponse = mapper.map(seva, SevaActivityResponse.class);
    	return sevaResponse ;
    }

    public List<SevaActivityResponse> getAll() {
    	List<SevaActivity> sevaDb = sevaActivityRepository.findAll();
    	List<SevaActivityResponse> sevaResponses = sevaDb
     			.stream()
     			.map( seva -> mapper.map(seva, SevaActivityResponse.class))
     			.collect(Collectors.toList());
        return sevaResponses;
    }
    
}
