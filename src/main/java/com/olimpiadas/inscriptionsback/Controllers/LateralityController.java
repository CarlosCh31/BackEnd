package com.olimpiadas.inscriptionsback.Controllers;

import com.olimpiadas.inscriptionsback.Models.Laterality;
import com.olimpiadas.inscriptionsback.Service.LateralityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/laterality")
@CrossOrigin(origins = "http://localhost:4200")
public class LateralityController {
    @Autowired
    private LateralityService service;

    @GetMapping
    public List<Laterality> getAllLaterality() {
        return service.getAllLaterality();
    }
}
