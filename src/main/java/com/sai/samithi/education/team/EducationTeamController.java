package com.sai.samithi.education.team;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/education-team")
public class EducationTeamController {

    @Autowired
    EducationTeamService educationActivityService;

    @PostMapping
    public EducationTeamResponse add(@RequestBody @Valid EducationTeamRequest educationActivityRequest) {
    
        return educationActivityService.add(educationActivityRequest);
    }

    @GetMapping
    public List<EducationTeamResponse> getAll() {             
        return educationActivityService.getAll();
    }

}
