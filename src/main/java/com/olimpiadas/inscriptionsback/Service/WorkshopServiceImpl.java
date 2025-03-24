package com.olimpiadas.inscriptionsback.Service;

import com.olimpiadas.inscriptionsback.Models.Workshop;
import com.olimpiadas.inscriptionsback.Repositories.WorkshopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

@Service
public class WorkshopServiceImpl implements WorkshopService {

    @Autowired
    private WorkshopRepository workshopRepository;

    @Override
    public List<Workshop> getAllWorkshops() {
        return workshopRepository.findAll();
    }

    @Override
    public Optional<Workshop> getWorkshopById(Long id) {
        return workshopRepository.findById(id);
    }

    @Override
    public String saveWorkshop(
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
            String objectives,
            String targetAudience,
            Boolean needsMaterial,
            String specifications
    ) {
        return workshopRepository.saveWorkshop(
                type,
                name,
                description,
                date,
                time,
                duration,
                modality,
                location,
                maxParticipants,
                minimumAge,
                maximumAge,
                adminEmail,
                state,
                objectives,
                targetAudience,
                needsMaterial,
                specifications
        );
    }

    @Override
    public Workshop updateWorkshop(Long id, Workshop updatedWorkshop) {
        return workshopRepository.findById(id)
                .map(workshop -> {
                    workshop.setObjectives(updatedWorkshop.getObjectives());
                    workshop.setTarget_audience(updatedWorkshop.getTarget_audience());
                    workshop.setNeeds_material(updatedWorkshop.getNeeds_material());
                    workshop.setSpecifications(updatedWorkshop.getSpecifications());
                    // También podés actualizar los campos heredados de Activity si es necesario
                    return workshopRepository.save(workshop);
                })
                .orElseThrow(() -> new RuntimeException("Workshop not found with id " + id));
    }

    @Override
    public void deleteWorkshop(Long id) {
        workshopRepository.deleteById(id);
    }
}

