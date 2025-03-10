package com.olimpiadas.inscriptionsback.Controllers;

import com.olimpiadas.inscriptionsback.Models.Country;
import com.olimpiadas.inscriptionsback.Service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
@CrossOrigin(origins = "http://localhost:4200")
class CountryController {
    @Autowired
    private CountryService service;

    @GetMapping
    public List<Country> getAllCountries() {
        return service.getAllCountries();
    }
}
