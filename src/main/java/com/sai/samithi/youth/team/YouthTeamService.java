package com.sai.samithi.youth.team;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class YouthTeamService {

	@Autowired
	YouthTeamRepository youthTeamRepository;

	@Autowired
	ModelMapper mapper;

	public YouthTeamResponse add(YouthTeamRequest youthTeamRequest) {
		YouthTeam youthTeamDb = YouthTeam.builder().role(youthTeamRequest.role()).name(youthTeamRequest.name())
				.contact(youthTeamRequest.contact()).details(youthTeamRequest.details())
				.publishedOn(youthTeamRequest.publishedOn()).build();
		YouthTeam youth = youthTeamRepository.save(youthTeamDb);
		YouthTeamResponse youthResponse = mapper.map(youth, YouthTeamResponse.class);
		return youthResponse;
	}

	public List<YouthTeamResponse> getAll() {
		List<YouthTeam> youthDb = youthTeamRepository.findAll();
		List<YouthTeamResponse> youthResponses = youthDb.stream()
				.map(youth -> mapper.map(youth, YouthTeamResponse.class)).collect(Collectors.toList());
		return youthResponses;
	}

}
