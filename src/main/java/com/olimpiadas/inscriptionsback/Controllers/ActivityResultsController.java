package com.olimpiadas.inscriptionsback.Controllers;

import com.olimpiadas.inscriptionsback.DTO.ActivityResultsDTO;
import com.olimpiadas.inscriptionsback.Models.ActivityResults;
import com.olimpiadas.inscriptionsback.Models.Athlete;
import com.olimpiadas.inscriptionsback.Service.ActivityResultsService;
import com.olimpiadas.inscriptionsback.Service.AthleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/results")
@CrossOrigin(origins = "http://localhost:4200") // Si necesitas permitir peticiones desde frontend como Angular
public class ActivityResultsController {

    private final ActivityResultsService activityResultsService;
    private final AthleteService athleteService;

    @Autowired
    public ActivityResultsController(ActivityResultsService activityResultsService, AthleteService athleteService) {
        this.activityResultsService = activityResultsService;
        this.athleteService = athleteService;
    }

    @GetMapping
    public List<ActivityResults> getAllResults() {
        return activityResultsService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<ActivityResults> getResultById(@PathVariable Long id) {
        return activityResultsService.findById(id);
    }

    @PostMapping("/register")
    public ResponseEntity<String> createResult(@RequestBody ActivityResultsDTO dto) {
        try {
            activityResultsService.saveFromDTO(dto);
            return ResponseEntity.ok("Resultado registrado correctamente.");
        } catch (DataIntegrityViolationException e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error de integridad de datos: " + e.getRootCause().getMessage());
        } catch (DataAccessException e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error de acceso a la base de datos: " + e.getRootCause().getMessage());
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error inesperado: " + e.getMessage());
        }
    }


    @PutMapping("/{id}")
    public ActivityResults updateResult(@PathVariable Long id, @RequestBody ActivityResults updatedResult) {
        return activityResultsService.findById(id).map(result -> {
            result.setAthlete(updatedResult.getAthlete());
            result.setActivity(updatedResult.getActivity());
            result.setPosition(updatedResult.getPosition());
            result.setTime(updatedResult.getTime());
            return activityResultsService.save(result);
        }).orElseGet(() -> {
            updatedResult.setId(id);
            return activityResultsService.save(updatedResult);
        });
    }

    @DeleteMapping("/{id}")
    public void deleteResult(@PathVariable Long id) {
        activityResultsService.deleteById(id);
    }
}

