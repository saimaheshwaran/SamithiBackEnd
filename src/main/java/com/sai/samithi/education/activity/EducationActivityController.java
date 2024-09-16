package com.sai.samithi.education.activity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/education-activity")
public class EducationActivityController {

    @Autowired
    EducationActivityService educationActivityService;

    @PostMapping
    public EducationActivityResponse add(@RequestBody @Valid EducationActivityRequest educationActivityRequest) {
    
        return educationActivityService.add(educationActivityRequest);
    }

    @GetMapping
    public List<EducationActivityResponse> getAll() {             
        return educationActivityService.getAll();
    }

}
