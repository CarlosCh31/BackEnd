package com.olimpiadas.inscriptionsback.Service;

import com.olimpiadas.inscriptionsback.DTO.ActivityDTO;
import com.olimpiadas.inscriptionsback.Models.Activity;
import com.olimpiadas.inscriptionsback.Models.Administrator;
import com.olimpiadas.inscriptionsback.Repositories.ActivityRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ActivityService {
    private final ActivityRepository activityRepository;

    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public Activity save(Activity activity) {
        return this.activityRepository.save(activity);
    }

    public List<ActivityDTO> findAll() {
        List<ActivityDTO> activityDTOS = new ArrayList<>();
        this.activityRepository.findAll().forEach(activity -> activityDTOS.addFirst(new ActivityDTO(activity)));
        return activityDTOS;
    }

    public Activity findById(int id) {
        return this.activityRepository.findById(id).get();
    }

    public void deleteById(int id) {
        this.activityRepository.deleteById(id);
    }

    public int saveActivity(Activity activity) {
        return this.activityRepository.saveActivity(activity.getType(),activity.getName(),activity.getDescription(),activity.getDate(),activity.getTime(),activity.getDuration(),activity.getModality()
        ,activity.getLocation(),activity.getMaxParticipants(),activity.getMinimumAge(),activity.getMaximumAge(),activity.getAdministrator().getEmail(),activity.getState());
    }

    public String update(Long id, String type, String name, String description, LocalDate date, LocalTime time, String duration, String modality, String location, Integer maxParticipants, Integer minimumAge, Integer maximumAge, String adminEmail, String state) {
        return this.activityRepository.update(id, type, name, description, date, time, duration, modality, location, maxParticipants, minimumAge, maximumAge, adminEmail, state);
    }
}
