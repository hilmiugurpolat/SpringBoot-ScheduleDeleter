package com.example.demo.repository;

import com.example.demo.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.time.LocalDateTime;

import org.springframework.transaction.annotation.Transactional; // Import the correct @Transactional annotation

@Repository
@Component

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

 //    void deleteByDateTimeBefore(LocalDateTime dateTime);
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM schedule WHERE date_time < NOW() - INTERVAL 48 HOUR", nativeQuery = true)
    void deleteSchedulesOlderThan();

}



