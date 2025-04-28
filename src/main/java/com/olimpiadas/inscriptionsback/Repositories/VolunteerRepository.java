package com.olimpiadas.inscriptionsback.Repositories;

import com.olimpiadas.inscriptionsback.Models.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface VolunteerRepository extends JpaRepository<Volunteer, Integer> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO volunteer (id, identification, name, birthdate, region_id, email, phone_number, nationality) " +
            "VALUES (:#{#volunteer.id}, :#{#volunteer.identification}, :#{#volunteer.name}, :#{#volunteer.birthdate}, :#{#volunteer.region.id}, " +
            ":#{#volunteer.email}, :#{#volunteer.phone_number}, :#{#volunteer.nationality})",
            nativeQuery = true)
    void saveVolunteer(Volunteer volunteer);

    @Transactional
    @Query(value = "SELECT update_volunteer_sport_experience(:id, :sportExperience)", nativeQuery = true)
    String updateVolunteer(String id, String sportExperience);

    @Transactional
    @Query(value = "SELECT delete_volunteer_by_id(:id)", nativeQuery = true)
    String deleteVolunteer(String id);
}

