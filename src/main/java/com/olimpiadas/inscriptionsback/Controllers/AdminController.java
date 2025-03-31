package com.olimpiadas.inscriptionsback.Controllers;

import com.olimpiadas.inscriptionsback.Models.Administrator;
import com.olimpiadas.inscriptionsback.Models.Athlete;
import com.olimpiadas.inscriptionsback.Service.AdminService;
import com.olimpiadas.inscriptionsback.Service.AthleteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:4200")

public class AdminController {

    private final AdminService adminService;
    private final AthleteService athleteService;

    public AdminController(AdminService adminService, AthleteService athleteService) {
        this.adminService = adminService;
        this.athleteService = athleteService;
    }

    @PostMapping("/register")
    public Administrator save(@RequestBody Administrator admin) {

        System.out.println(admin);
        return adminService.save(admin);
    }

    @GetMapping("/getAll")
    public List<Administrator> getAll() {
        return adminService.findAll();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Administrator loginRequest) {
        Optional<Administrator> optionalAdmin = adminService.findByEmail(loginRequest.getEmail());

        if (optionalAdmin.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario no encontrado");
        }

        Administrator admin = optionalAdmin.get();

        // 🔐 Si usás BCrypt, deberías comparar así:
        // if (!passwordEncoder.matches(loginRequest.getPassword(), admin.getPassword()))

        if (!admin.getPassword().equals(loginRequest.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Contraseña incorrecta");
        }

        // Solo respondés con info básica
        Map<String, String> response = new HashMap<>();
        response.put("email", admin.getEmail());

        return ResponseEntity.ok(response);
    }

// llenar de datos reales -- apunto para que no se me olvide

    @GetMapping("/dashboard-stats")
    public Map<String, Object> getDashboardStats() {
        Map<String, Object> response = new HashMap<>();

        response.put("stats", Map.of(
                "totalUsers", 120,
                "totalVolunteers", 80,
                "totalAthletes", 50,
                "totalEvents", 20
        ));

        response.put("volunteers", Map.of(
                "available", 50,
                "unavailable", 30
        ));

        response.put("athletes", Map.of(
                "tea", 10,
                "down", 20,
                "development", 15,
                "pci", 5
        ));

        return response;
    }

    @PutMapping("/delete")
    public void deleteById(@RequestBody Administrator admin) {
        adminService.deleteById(admin.getEmail());
    }

    @PutMapping("/edit")
    public ResponseEntity<String> updateAdmin(@RequestBody Administrator admin) {
        String result = adminService.actualizarAdministrador(admin.getEmail(), admin.getPassword());
        return ResponseEntity.ok(result);
    }

}