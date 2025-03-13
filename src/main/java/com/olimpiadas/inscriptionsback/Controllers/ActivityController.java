package com.olimpiadas.inscriptionsback.Controllers;

import com.olimpiadas.inscriptionsback.Models.Activity;
import com.olimpiadas.inscriptionsback.Service.ActivityService;
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
    public List<Activity> getAll(){
        return this.activityService.findAll();
    }

    @DeleteMapping
    public void deleteById(int id) {
        this.activityService.deleteById(id);
    }
}
