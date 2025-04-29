package com.olimpiadas.inscriptionsback.Service;

import com.olimpiadas.inscriptionsback.DTO.ActivityResultsDTO;
import com.olimpiadas.inscriptionsback.Models.ActivityResults;
import com.olimpiadas.inscriptionsback.Repositories.ActivityResultsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityResultsServiceImpl implements ActivityResultsService {

    private final ActivityResultsRepository activityResultsRepository;
    private AthleteService athleteService;

    @Autowired
    public ActivityResultsServiceImpl(ActivityResultsRepository activityResultsRepository) {
        this.activityResultsRepository = activityResultsRepository;
    }

    @Override
    public List<ActivityResults> findAll() {
        return activityResultsRepository.findAll();
    }

    @Override
    public Optional<ActivityResults> findById(Long id) {
        return activityResultsRepository.findById(id);
    }

    @Override
    public ActivityResults save(ActivityResults result) {
        return activityResultsRepository.save(result);
    }

    @Override
    public void deleteById(Long id) {
        activityResultsRepository.deleteById(id);
    }

    @Override
    public void saveFromDTO(ActivityResultsDTO dto) {

        activityResultsRepository.saveResult(dto.getAthlete(), dto.getActivity(), dto.getPosition(), dto.getTime());
    }

}

