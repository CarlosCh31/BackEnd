package com.olimpiadas.inscriptionsback.Service;

import com.olimpiadas.inscriptionsback.Models.Sport;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Service
public interface SportService {
    Sport save(Sport sport);
    List<Sport> findAll();
    Sport findById(Integer id);
    void deleteById(Integer id);
    Sport update(Sport sport);
    String saveSport(
            String type,
            String name,
            String description,
            Date date,
            Time time,
            String duration,
            String modality,
            String location,
            Integer maxParticipants,
            Integer minimumAge,
            Integer maximumAge,
            String adminEmail,
            String state,
            String sportType,
            String difficulty,
            Boolean needsSpecialEquipment,
            String specifications,
            String level
    );
}
