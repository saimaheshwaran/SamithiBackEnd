package com.sai.samithi.youth.calender;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/youth-schedule")
public class YouthScheduleController {

    @Autowired
    YouthScheduleService youthScheduleService;

    @PostMapping
    public YouthScheduleResponse addyouthScheduleSchedule(@RequestBody @Valid YouthScheduleRequest youthScheduleRequest) {
    
        return youthScheduleService.add(youthScheduleRequest);
    }

    @GetMapping
    public List<YouthScheduleResponse> getyouthScheduleSchedules() {             
        return youthScheduleService.getAll();
    }

}
