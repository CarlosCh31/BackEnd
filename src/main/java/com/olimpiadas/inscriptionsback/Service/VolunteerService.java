package com.olimpiadas.inscriptionsback.Service;

import com.olimpiadas.inscriptionsback.Models.Volunteer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VolunteerService {
    Volunteer save(Volunteer volunteer);
    void saveVolunteer(Volunteer volunteer);
    List<Volunteer> findAll();
    Volunteer findById(Integer id);
    String deleteById(Volunteer volunteer);
    String update(Volunteer volunteer);
}
