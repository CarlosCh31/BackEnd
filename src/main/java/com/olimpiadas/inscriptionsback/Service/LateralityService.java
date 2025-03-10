package com.olimpiadas.inscriptionsback.Service;

import com.olimpiadas.inscriptionsback.Models.Laterality;
import com.olimpiadas.inscriptionsback.Repositories.LateralityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LateralityService {
    @Autowired
    private LateralityRepository repository;

    public List<Laterality> getAllLaterality() {
        return repository.findAll();
    }
}
