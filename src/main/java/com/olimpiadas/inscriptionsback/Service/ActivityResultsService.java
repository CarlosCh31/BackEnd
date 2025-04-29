package com.olimpiadas.inscriptionsback.Service;

import com.olimpiadas.inscriptionsback.Models.ActivityResults;
import com.olimpiadas.inscriptionsback.DTO.ActivityResultsDTO;
import java.util.List;
import java.util.Optional;

public interface ActivityResultsService {
    List<ActivityResults> findAll();
    Optional<ActivityResults> findById(Long id);
    ActivityResults save(ActivityResults result);
    void deleteById(Long id);
    void saveFromDTO(ActivityResultsDTO dto);
}

