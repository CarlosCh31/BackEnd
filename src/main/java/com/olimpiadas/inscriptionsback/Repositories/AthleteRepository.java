package com.olimpiadas.inscriptionsback.Repositories;

import com.olimpiadas.inscriptionsback.Models.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface AthleteRepository extends JpaRepository<Athlete, Integer> {


    @Transactional
    @Query(value = "SELECT register_athlete(" +
            "CAST(:p_id AS VARCHAR), " +
            "CAST(:p_name AS VARCHAR), " +
            "CAST(:p_birthdate AS DATE), " +
            "CAST(:p_region_id AS INT), " +
            "CAST(:p_email AS VARCHAR), " +
            "CAST(:p_phone_number AS VARCHAR), " +
            "CAST(:p_tipo AS VARCHAR), " +
            "CAST(:p_province AS int), " +
            "CAST(:p_canton AS int), " +
            "CAST(:a_laterality AS VARCHAR), " +
            "CAST(:a_disability_type AS VARCHAR), " +
            "CAST(:a_weight AS DOUBLE PRECISION), " +
            "CAST(:a_height AS DOUBLE PRECISION)," +
            "CAST(:a_sub_program AS VARCHAR)," +
            "CAST(:a_state AS VARCHAR))",
            nativeQuery = true)
    String saveAthlete(@Param("p_id") String p_id,
                       @Param("p_name") String p_name,
                       @Param("p_birthdate") Date p_birthdate,
                       @Param("p_region_id") Integer p_region_id,
                       @Param("p_email") String p_email,
                       @Param("p_phone_number") String p_phone_number,
                       @Param("p_tipo") String p_tipo,
                       @Param("p_province") int p_province,
                       @Param("p_canton") int p_canton,
                       @Param("a_laterality") String a_laterality,
                       @Param("a_disability_type") String a_disability_type,
                       @Param("a_weight") Double a_weight,
                       @Param("a_height") Double a_height,
                       @Param("a_sub_program") String a_sub_program,
                       @Param("a_state") String state);
    @Transactional
    @Query(value = "select delete_athlete_by_id(:id)")
    void deleteAthlete(String id);

    @Transactional
    @Query(value = "select update_athlete(:id, :laterality, :disability_type, :weight, :height)",nativeQuery = true)
    String update(String id, String laterality, String disability_type, Double weight, Double height);

    @Transactional
    @Query(value = "select update_athlete_manager(:id, :laterality, :disability_type, :state)", nativeQuery = true)
    String updateManager(String id, String laterality, String disability_type, String state);
}
