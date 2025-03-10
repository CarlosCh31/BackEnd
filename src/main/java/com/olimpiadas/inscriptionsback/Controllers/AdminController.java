package com.olimpiadas.inscriptionsback.Controllers;

import com.olimpiadas.inscriptionsback.Models.Administrator;
import com.olimpiadas.inscriptionsback.Service.AdminService;
import org.springframework.http.ResponseEntity;
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

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
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
    public Optional<Administrator> findByIdAndPassword(@RequestBody Administrator admin) {
        return adminService.findByIdAndPassword(admin.getEmail(), admin.getPassword());

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


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        adminService.deleteById(id);
    }

    @PutMapping("/edit")
    public ResponseEntity<String> updateAdmin(@RequestBody Administrator admin) {
        String result = adminService.actualizarAdministrador(admin.getEmail(), admin.getPassword());
        return ResponseEntity.ok(result);
    }

}