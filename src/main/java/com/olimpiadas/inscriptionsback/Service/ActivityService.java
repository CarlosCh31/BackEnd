package com.olimpiadas.inscriptionsback.Service;

import com.olimpiadas.inscriptionsback.Models.Activity;
import com.olimpiadas.inscriptionsback.Repositories.ActivityRepository;
import org.springframework.stereotype.Service;

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

    public List<Activity> findAll() {
        return this.activityRepository.findAll();
    }

    public Activity findById(int id) {
        return this.activityRepository.findById(id).get();
    }

    public void deleteById(int id) {
        this.activityRepository.deleteById(id);
    }

    public int saveActivity(Activity activity) {
        return this.activityRepository.saveActivity(activity.getType(),activity.getName(),activity.getDescription(),activity.getDate(),activity.getTime(),activity.getDuration(),activity.getModality()
        ,activity.getLocation(),activity.getMaxParticipants(),activity.getMinimumAge(),activity.getMaximumAge(),activity.getAdminEmail().getEmail(),activity.getState());
    }
}
