package com.sai.samithi.education.team;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EducationTeamService {

    @Autowired
    EducationTeamRepository educationTeamRepository;
    
    @Autowired
    ModelMapper mapper;

    public EducationTeamResponse add(EducationTeamRequest educationTeamRequest) {
    	EducationTeam educationTeamDb = EducationTeam.builder()
    	.role(educationTeamRequest.role())
    	.name(educationTeamRequest.name())
    	.contact(educationTeamRequest.contact())
    	.details(educationTeamRequest.details())
    	.publishedOn(educationTeamRequest.publishedOn())
    	.build();
    	EducationTeam education = educationTeamRepository.save(educationTeamDb);
    	EducationTeamResponse educationResponse = mapper.map(education, EducationTeamResponse.class);
    	return educationResponse ;
    }

    public List<EducationTeamResponse> getAll() {
    	List<EducationTeam> educationDb = educationTeamRepository.findAll();
    	List<EducationTeamResponse> educationResponses = educationDb
     			.stream()
     			.map( education -> mapper.map(education, EducationTeamResponse.class))
     			.collect(Collectors.toList());
        return educationResponses;
    }
    
}
