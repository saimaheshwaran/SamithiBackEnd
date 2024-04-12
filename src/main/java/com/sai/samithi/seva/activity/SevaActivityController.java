package com.sai.samithi.seva.activity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/seva-activity")
public class SevaActivityController {

    @Autowired
    SevaActivityService sevaActivityService;

    @PostMapping
    public SevaActivityResponse addSevaActivity(@RequestBody @Valid SevaActivityRequest sevaActivityRequest) {
    
        return sevaActivityService.addSevaActivity(sevaActivityRequest);
    }

    @GetMapping
    public List<SevaActivityResponse> getSevaActivities() {             
        return sevaActivityService.getAll();
    }

}
