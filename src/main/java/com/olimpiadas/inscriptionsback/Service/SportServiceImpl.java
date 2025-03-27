package com.olimpiadas.inscriptionsback.Service;

import com.olimpiadas.inscriptionsback.Models.Sport;
import com.olimpiadas.inscriptionsback.Repositories.SportRepository;
import com.olimpiadas.inscriptionsback.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Service
public class SportServiceImpl implements SportService {

    private final SportRepository sportRepository;

    public SportServiceImpl(SportRepository sportRepository) {
        this.sportRepository = sportRepository;
    }

    @Override
    public Sport save(Sport sport) {
        return sportRepository.save(sport);
    }

    @Override
    public List<Sport> findAll() {
        return sportRepository.findAll();
    }

    @Override
    public Sport findById(Integer id) {
        return sportRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Deporte con id " + id + " no se encuentra")
        );
    }

    @Override
    public void deleteById(Integer id) {
        sportRepository.deleteById(id);
    }

    @Override
    public Sport update(Sport sport) {
        return sportRepository.save(sport);
    }

    @Override
    public String saveSport(
            String type,
            String name,
            String description,
            Date date,
            Time time,
            String duration,
            String modality,
            String location,
            Integer maxParticipants,
            Integer minimumAge,
            Integer maximumAge,
            String adminEmail,
            String state,
            String sportType,
            String difficulty,
            Boolean needsSpecialEquipment,
            String specifications,
            String level
    ) {
        return sportRepository.saveSport(
                type, name, description, date, time, duration, modality, location,
                maxParticipants, minimumAge, maximumAge, adminEmail, state,
                sportType, difficulty, needsSpecialEquipment, specifications, level
        );
    }
}
