package com.olimpiadas.inscriptionsback.Service;

import com.olimpiadas.inscriptionsback.Models.GlobalRegion;
import com.olimpiadas.inscriptionsback.Repositories.GlobalRegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GlobalRegionService {
    @Autowired
    private GlobalRegionRepository repository;

    public List<GlobalRegion> getAllRegions() {
        return repository.findAll();
    }
}
