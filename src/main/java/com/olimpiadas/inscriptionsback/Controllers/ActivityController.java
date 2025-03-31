package com.olimpiadas.inscriptionsback.Controllers;

import com.olimpiadas.inscriptionsback.DTO.ActivityDTO;
import com.olimpiadas.inscriptionsback.Models.Activity;
import com.olimpiadas.inscriptionsback.Service.ActivityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activity")
@CrossOrigin(origins = "http://localhost:4200")


public class ActivityController {

    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @PostMapping("/register")
    public int save(@RequestBody Activity activity) {
        return this.activityService.saveActivity(activity);
    }

    @GetMapping("/getAll")
    public List<ActivityDTO> getAll(){
        return this.activityService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id) {
        this.activityService.deleteById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody ActivityDTO activity) {
        String result = this.activityService.update(activity.getId(), activity.getType(), activity.getName(),
                activity.getDescription(), activity.getDate(), activity.getTime(), activity.getDuration(),
                activity.getModality(), activity.getLocation(), activity.getMaxParticipants(),
                activity.getMinimumAge(),activity.getMaximumAge(), activity.getAdministratorEmail(), activity.getState());
        return ResponseEntity.ok(result);
    }
}
