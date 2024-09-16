package com.sai.samithi.youth.team;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/youth-team")
public class YouthTeamController {

    @Autowired
    YouthTeamService youthActivityService;

    @PostMapping
    public YouthTeamResponse add(@RequestBody @Valid YouthTeamRequest youthTeamRequest) {
    
        return youthActivityService.add(youthTeamRequest);
    }

    @GetMapping
    public List<YouthTeamResponse> getAll() {             
        return youthActivityService.getAll();
    }

}
