package com.example.demo.service;

import com.example.demo.model.Schedule;
import com.example.demo.repository.ScheduleRepository;
import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Autowired
    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public Schedule getSchedule(Long id) {
        return scheduleRepository.findById(id).orElse(null);
    }

    public void deleteScheduleById(Long id) {
        scheduleRepository.deleteById(id);
    }

    /*
   @PostConstruct
    public void deleteOldSchedule() {
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime thresholdTime = currentTime.minusHours(48);
        scheduleRepository.deleteSchedulesOlderThan(thresholdTime);
    }*/



   @Scheduled(cron = "0 0 0 * * ?")
   public void deleteOldSchedules() {
       System.out.println("girdi");;
       // LocalDateTime currentTime = LocalDateTime.now();
      //LocalDateTime thresholdTime = currentTime.minusHours(48);
       scheduleRepository.deleteSchedulesOlderThan();
       //LocalDateTime dateTime = LocalDateTime.now().minusHours(48);
       //        scheduleRepository.deleteByDateTimeBefore(dateTime);
   }




}
