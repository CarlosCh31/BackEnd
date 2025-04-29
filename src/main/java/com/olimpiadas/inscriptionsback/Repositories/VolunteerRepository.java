package com.olimpiadas.inscriptionsback.Repositories;

import com.olimpiadas.inscriptionsback.Models.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface VolunteerRepository extends JpaRepository<Volunteer, Integer> {



    @Transactional
    @Query(value = "SELECT register_volunteer(" +
            "CAST(:p_id AS VARCHAR), " +
            "CAST(:p_name AS VARCHAR), " +
            "CAST(:p_birthdate AS DATE), " +
            "CAST(:p_region_id AS INT), " +
            "CAST(:p_email AS VARCHAR), " +
            "CAST(:p_phone_number AS VARCHAR), " +
            "CAST(:p_tipo AS VARCHAR), " +
            "CAST(:p_province AS INT), " +
            "CAST(:p_canton AS INT), " +
            "CAST(:p_citizenship AS VARCHAR), " +
            "CAST(:v_sport_experience AS VARCHAR))",
            nativeQuery = true)
    String saveVolunteer(
            @Param("p_id") String id,
            @Param("p_name") String name,
            @Param("p_birthdate") Date birthdate,
            @Param("p_region_id") Integer regionId,
            @Param("p_email") String email,
            @Param("p_phone_number") String phoneNumber,
            @Param("p_tipo") String tipo,
            @Param("p_province") Integer provinceId,
            @Param("p_canton") Integer cantonId,
            @Param("p_citizenship") String citizenship,
            @Param("v_sport_experience") String sportExperience
    );




    @Transactional
    @Query(value = "SELECT update_volunteer_sport_experience(:id, :sportExperience)", nativeQuery = true)
    String updateVolunteer(String id, String sportExperience);

    @Transactional
    @Query(value = "SELECT delete_volunteer_by_id(:id)", nativeQuery = true)
    String deleteVolunteer(String id);
}

