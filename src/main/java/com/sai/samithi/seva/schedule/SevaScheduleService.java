package com.sai.samithi.seva.schedule;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SevaScheduleService {

    @Autowired
    SevaScheduleRepository sevaRepository;
    
    @Autowired
    ModelMapper mapper;

    public SevaScheduleResponse add(SevaScheduleRequest request) {
    	SevaSchedule sevaDb = SevaSchedule.builder()
    	.schedule(request.schedule())
    	.name(request.name())
    	.eventDateTime(request.eventDateTime())
    	.details(request.details())
    	.publishedOn(request.publishedOn())
    	.build();
    	SevaSchedule seva = sevaRepository.save(sevaDb);
    	SevaScheduleResponse sevaResponse = mapper.map(seva, SevaScheduleResponse.class);
    	return sevaResponse ;
    }

    public List<SevaScheduleResponse> getAll() {
    	List<SevaSchedule> sevaDb = sevaRepository.findAll();
    	List<SevaScheduleResponse> sevaResponses = sevaDb
     			.stream()
     			.map( seva -> mapper.map(seva, SevaScheduleResponse.class))
     			.collect(Collectors.toList());
        return sevaResponses;
    }
    
}
