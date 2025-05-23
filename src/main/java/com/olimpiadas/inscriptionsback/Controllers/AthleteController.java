package com.olimpiadas.inscriptionsback.Controllers;

import com.olimpiadas.inscriptionsback.DTO.AthleteDTO;
import com.olimpiadas.inscriptionsback.Models.Athlete;
import com.olimpiadas.inscriptionsback.Models.ErrorResponse;
import com.olimpiadas.inscriptionsback.Models.Sport;
import com.olimpiadas.inscriptionsback.Models.SportLevel;
import com.olimpiadas.inscriptionsback.Service.AthleteService;
import com.olimpiadas.inscriptionsback.exception.MessageResponse;
import org.apache.coyote.Response;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/athletes")
@CrossOrigin(origins = "http://localhost:4200")
public class AthleteController {

    private final AthleteService athleteService;

    public AthleteController(AthleteService athleteService) {
        this.athleteService = athleteService;
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Athlete athlete) {
        // Pre-validation of name
        athlete.setHeight(170.0);
        athlete.setWeight(150.0);
        athlete.setTipo("Atleta");
        if (athlete.getName() == null || athlete.getName().isEmpty()) {
            return ResponseEntity.badRequest().body(new ErrorResponse("name", "El nombre del atleta es requerido"));
        }

        try {
            // Try to save athlete using service method
            athleteService.save(athlete); // Let service handle transaction
            return ResponseEntity.ok(new MessageResponse("Éxito: El atleta con ID " + athlete.getId() + " ha sido registrado correctamente."));
        } catch (DataIntegrityViolationException e) {
            // Handle specific database-related errors
            String errorMessage = athleteService.handlePostgreSQLError(e);
            return ResponseEntity.badRequest().body(new ErrorResponse(athleteService.extractFieldFromError(errorMessage), errorMessage));
        } catch (Exception e) {
            System.out.println(e);
            // General error handling
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse("general", e.getMessage()));
        }
    }

    @GetMapping("/getAll")
    public List<Athlete> findAll() {
        return athleteService.findAll();
    }

    @GetMapping("/{id}")
    public Athlete findById(@PathVariable Integer id) {
        return athleteService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable String id) {
        athleteService.deleteById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateAthlete(@RequestBody Athlete athlete) {
        String result = athleteService.update(athlete);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/updateManager")
    public ResponseEntity<String> updateAthleteManager(@RequestBody Athlete athlete) {
        String result = athleteService.updateManager(athlete);
        return ResponseEntity.ok(result);
    }
}

