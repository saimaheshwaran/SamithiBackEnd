package com.sai.samithi.seva.schedule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/seva-schedule")
public class SevaScheduleController {

    @Autowired
    SevaScheduleService sevaScheduleService;

    @PostMapping
    public SevaScheduleResponse addsevaScheduleSchedule(@RequestBody @Valid SevaScheduleRequest sevaScheduleRequest) {
    
        return sevaScheduleService.add(sevaScheduleRequest);
    }

    @GetMapping
    public List<SevaScheduleResponse> getsevaScheduleSchedules() {             
        return sevaScheduleService.getAll();
    }

}
