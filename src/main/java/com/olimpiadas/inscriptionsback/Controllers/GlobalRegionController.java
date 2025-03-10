package com.olimpiadas.inscriptionsback.Controllers;

import com.olimpiadas.inscriptionsback.Models.GlobalRegion;
import com.olimpiadas.inscriptionsback.Service.GlobalRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/global-regions")
@CrossOrigin(origins = "http://localhost:4200")
class GlobalRegionController {
    @Autowired
    private GlobalRegionService service;

    @GetMapping
    public List<GlobalRegion> getAllRegions() {
        return service.getAllRegions();
    }
}