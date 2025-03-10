package com.olimpiadas.inscriptionsback.Repositories;

import com.olimpiadas.inscriptionsback.Models.Activity;
import com.olimpiadas.inscriptionsback.Models.Administrator;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.time.LocalTime;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer> {

    @Transactional
    @Query(value = "SELECT insert_activity(" +
            ":type," +
            ":name," +
            ":description," +
            ":date," +
            ":time," +
            "CAST(:duration AS INTERVAL)," +
            ":modality," +
            ":location," +
            ":maxParticipants," +
            ":minimumAge," +
            ":maximumAge," +
            ":adminEmail," +
            ":state)", nativeQuery = true)
    int saveActivity(String type, String name, String description, LocalDate date, LocalTime time, String duration, String modality, String location, Integer maxParticipants, Integer minimumAge, Integer maximumAge, String adminEmail, String state);
}
