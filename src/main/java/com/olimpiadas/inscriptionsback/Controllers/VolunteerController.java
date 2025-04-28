package com.olimpiadas.inscriptionsback.Controllers;

import com.olimpiadas.inscriptionsback.Models.Volunteer;
import com.olimpiadas.inscriptionsback.Service.VolunteerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/volunteers")
@CrossOrigin(origins = "http://localhost:4200")
public class VolunteerController {

    private final VolunteerService volunteerService;

    public VolunteerController(VolunteerService volunteerService) {
        this.volunteerService = volunteerService;
    }

    @PostMapping
    public void save(@RequestBody Volunteer volunteer) {
        if (volunteer.getName() == null || volunteer.getName().isEmpty()) {
            throw new IllegalArgumentException("El nombre del voluntario es requerido");
        }
        System.out.println("Volunteer received: " + volunteer.getName());
         volunteerService.saveVolunteer(volunteer);
    }


    @GetMapping("/getAll")
    public List<Volunteer> findAll() {
        return volunteerService.findAll();
    }

    @GetMapping("/{id}")
    public Volunteer findById(@PathVariable Integer id) {
        return volunteerService.findById(id);
    }

    @PutMapping("/delete")
    public ResponseEntity<String> deleteById(@RequestBody Volunteer volunteer) {
        String result = volunteerService.deleteById(volunteer);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/edit")
    public ResponseEntity<String> updateVolunteer(@RequestBody Volunteer volunteer) {
        String result = volunteerService.update(volunteer);
        return ResponseEntity.ok(result);
    }
}
