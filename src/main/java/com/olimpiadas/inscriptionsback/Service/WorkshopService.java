package com.olimpiadas.inscriptionsback.Service;

import com.olimpiadas.inscriptionsback.Models.Workshop;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

public interface WorkshopService {
    List<Workshop> getAllWorkshops();
    Optional<Workshop> getWorkshopById(Long id);
    String saveWorkshop(
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
            String objectives,
            String targetAudience,
            Boolean needsMaterial,
            String specifications
    );
    Workshop updateWorkshop(Long id, Workshop updatedWorkshop);
    void deleteWorkshop(Long id);
}
