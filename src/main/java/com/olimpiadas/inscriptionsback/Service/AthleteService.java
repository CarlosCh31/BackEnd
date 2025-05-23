package com.olimpiadas.inscriptionsback.Service;

import com.olimpiadas.inscriptionsback.DTO.AthleteDTO;
import com.olimpiadas.inscriptionsback.Models.Athlete;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public interface AthleteService {
    List<Athlete> findAll();
    Athlete findById(Integer id);
    void deleteById(String id);
    String update(Athlete athlete);
    public void save(Athlete athlete);
    public String handlePostgreSQLError(Exception e);
    public String extractFieldFromError(String detailedMessage);

    String updateManager(Athlete athlete);
}
