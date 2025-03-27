package com.olimpiadas.inscriptionsback.Controllers;

import com.olimpiadas.inscriptionsback.Models.Administrator;
import com.olimpiadas.inscriptionsback.Models.Sport;
import com.olimpiadas.inscriptionsback.Service.SportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Time;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/sports")
@CrossOrigin(origins = "http://localhost:4200")
public class SportController {

    private final SportService sportService;

    public SportController(SportService sportService) {
        this.sportService = sportService;
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> saveSport(@RequestBody Sport sport) {
        sport.setAdminEmail(new Administrator("admin@example.com", "admin"));
        String result = sportService.saveSport(
                sport.getType(),
                sport.getName(),
                sport.getDescription(),
                Date.valueOf(sport.getDate()),
                Time.valueOf(sport.getTime()),
                sport.getDuration(),
                sport.getModality(),
                sport.getLocation(),
                sport.getMaxParticipants(),
                sport.getMinimumAge(),
                sport.getMaximumAge(),
                sport.getAdminEmail().getEmail(),
                sport.getState(),

                sport.getType(),
                sport.getDifficulty(),
                sport.getNeeds_special_equipment(),
                sport.getSpecifications(),
                sport.getLevel()
        );
        System.out.println(result);
        Map<String, String> response = new HashMap<>();
        response.put("message", result);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public List<Sport> findAll() {
        List<Sport> sports = sportService.findAll();
        for (Sport sport : sports) {
            System.out.println("Sport Type: " + sport.getType());  // Verifica que no sea null
        }
        return sports;
    }

    @GetMapping("/{id}")
    public Sport findById(@PathVariable Integer id) {
        return sportService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        sportService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Sport updateSport(@PathVariable Integer id, @RequestBody Sport sport) {
        sport.setId(id.longValue());  // Convertimos el Integer a Long
        return sportService.update(sport);
    }

}
