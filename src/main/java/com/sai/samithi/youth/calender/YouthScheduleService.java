package com.sai.samithi.youth.calender;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class YouthScheduleService {

    @Autowired
    YouthScheduleRepository youthRepository;
    
    @Autowired
    ModelMapper mapper;

    public YouthScheduleResponse add(YouthScheduleRequest request) {
    	YouthSchedule youthDb = YouthSchedule.builder()
    	.schedule(request.schedule())
    	.name(request.name())
    	.eventDateTime(request.eventDateTime())
    	.details(request.details())
    	.publishedOn(request.publishedOn())
    	.build();
    	YouthSchedule youth = youthRepository.save(youthDb);
    	YouthScheduleResponse youthResponse = mapper.map(youth, YouthScheduleResponse.class);
    	return youthResponse ;
    }

    public List<YouthScheduleResponse> getAll() {
    	List<YouthSchedule> youthDb = youthRepository.findAll();
    	List<YouthScheduleResponse> youthResponses = youthDb
     			.stream()
     			.map( youth -> mapper.map(youth, YouthScheduleResponse.class))
     			.collect(Collectors.toList());
        return youthResponses;
    }
    
}
