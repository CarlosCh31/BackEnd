package com.olimpiadas.inscriptionsback.Service;

import com.olimpiadas.inscriptionsback.Models.Volunteer;
import com.olimpiadas.inscriptionsback.Repositories.VolunteerRepository;
import com.olimpiadas.inscriptionsback.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class VolunteerServiceImpl implements VolunteerService {
    @Autowired
    private final VolunteerRepository volunteerRepository;

    public VolunteerServiceImpl(VolunteerRepository volunteerRepository) {
        this.volunteerRepository = volunteerRepository;
    }

    @Override
    public Volunteer save(Volunteer volunteer) {
        return volunteerRepository.save(volunteer);
    }

    @Override
    public void saveVolunteer(Volunteer volunteer) {
        volunteerRepository.saveVolunteer(
                volunteer.getId(),
                volunteer.getName(),
                volunteer.getBirthdate(),
                volunteer.getRegion_id().getId(),
                volunteer.getEmail(),
                volunteer.getPhone_number(),
                volunteer.getTipo(),
                volunteer.getProvince_id().getId(),
                volunteer.getCanton_id().getId(),
                volunteer.getCitizenship(),
                volunteer.getSportExperience()
        );

    }

    @Override
    public List<Volunteer> findAll() {
        return volunteerRepository.findAll();
    }

    @Override
    public Volunteer findById(Integer id) {
        return volunteerRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Voluntario con id " + id + " no se encuentra")
        );
    }

    @Override
    public String deleteById(Volunteer volunteer) {
        return volunteerRepository.deleteVolunteer(volunteer.getId());
    }


    @Override
    public String update(Volunteer volunteer) {
        return volunteerRepository.updateVolunteer(volunteer.getId(), volunteer.getSportExperience());
    }

}
