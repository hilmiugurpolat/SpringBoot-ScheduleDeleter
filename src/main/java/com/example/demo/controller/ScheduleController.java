package com.example.demo.controller;

import com.example.demo.model.Schedule;
import com.example.demo.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
public class ScheduleController {

    private final ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("/schedule")
    public Schedule getSchedule(@RequestParam Long id) {
        return scheduleService.getSchedule(id);
    }


    @DeleteMapping("/schedule")
    public void deleteSchedule(@RequestParam Long id) {
        scheduleService.deleteScheduleById(id);
    }





}
