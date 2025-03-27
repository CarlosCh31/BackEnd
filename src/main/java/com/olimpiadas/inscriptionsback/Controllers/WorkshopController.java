package com.olimpiadas.inscriptionsback.Controllers;

import com.olimpiadas.inscriptionsback.Models.Administrator;
import com.olimpiadas.inscriptionsback.Models.Workshop;
import com.olimpiadas.inscriptionsback.Service.WorkshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.sql.Date;
import java.sql.Time;
import java.util.Map;

@RestController
@RequestMapping("/api/workshops")
@CrossOrigin(origins = "http://localhost:4200")
public class WorkshopController {

    @Autowired
    private WorkshopService workshopService;

    @GetMapping
    public ResponseEntity<List<Workshop>> getAllWorkshops() {
        return ResponseEntity.ok(workshopService.getAllWorkshops());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Workshop> getWorkshopById(@PathVariable Long id) {
        return workshopService.getWorkshopById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> saveWorkshopUsingFunction(@RequestBody Workshop dto) {
        dto.setAdminEmail(new Administrator("admin@example.com", "sapo"));
        String result = workshopService.saveWorkshop(
                dto.getType(),
                dto.getName(),
                dto.getDescription(),
                Date.valueOf(dto.getDate()),
                Time.valueOf(dto.getTime()),
                dto.getDuration(), // Ejemplo: "2 hours"
                dto.getModality(),
                dto.getLocation(),
                dto.getMaxParticipants(),
                dto.getMinimumAge(),
                dto.getMaximumAge(),
                dto.getAdminEmail().getEmail(),
                dto.getState(),
                dto.getObjectives(),
                dto.getTarget_audience(),
                dto.getNeeds_material(),
                dto.getSpecifications()
        );
        System.out.println(result);
        Map<String, String> response = new HashMap<>();
        response.put("message", result);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Workshop> updateWorkshop(@PathVariable Long id, @RequestBody Workshop updatedWorkshop) {
        try {
            return ResponseEntity.ok(workshopService.updateWorkshop(id, updatedWorkshop));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkshop(@PathVariable Long id) {
        workshopService.deleteWorkshop(id);
        return ResponseEntity.noContent().build();
    }
}

