package com.olimpiadas.inscriptionsback.Repositories;

import com.olimpiadas.inscriptionsback.Models.Sport;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Repository
public interface SportRepository extends JpaRepository<Sport, Integer> {

    @Override
    @Query(value = "SELECT * FROM get_sports_with_activity();", nativeQuery = true)
    List<Sport> findAll();

    @Transactional
    @Query(value = "SELECT save_sport(" +
            "CAST(:p_type AS VARCHAR), " +
            "CAST(:p_name AS VARCHAR), " +
            "CAST(:p_description AS TEXT), " +
            "CAST(:p_date AS DATE), " +
            "CAST(:p_time AS TIME), " +
            "CAST(:p_duration AS INTERVAL), " +
            "CAST(:p_modality AS VARCHAR), " +
            "CAST(:p_location AS VARCHAR), " +
            "CAST(:p_max_participants AS INT), " +
            "CAST(:p_minimum_age AS INT), " +
            "CAST(:p_maximum_age AS INT), " +
            "CAST(:p_admin_email AS VARCHAR), " +
            "CAST(:p_state AS VARCHAR), " +
            "CAST(:p_sport_type AS VARCHAR), " +
            "CAST(:p_difficulty AS VARCHAR), " +
            "CAST(:p_needs_special_equipment AS BOOLEAN), " +
            "CAST(:p_specifications AS VARCHAR), " +
            "CAST(:p_level AS VARCHAR))",
            nativeQuery = true)
    String saveSport(
            @Param("p_type") String type,
            @Param("p_name") String name,
            @Param("p_description") String description,
            @Param("p_date") Date date,
            @Param("p_time") Time time,
            @Param("p_duration") String duration,
            @Param("p_modality") String modality,
            @Param("p_location") String location,
            @Param("p_max_participants") Integer maxParticipants,
            @Param("p_minimum_age") Integer minimumAge,
            @Param("p_maximum_age") Integer maximumAge,
            @Param("p_admin_email") String adminEmail,
            @Param("p_state") String state,
            @Param("p_sport_type") String sportType,
            @Param("p_difficulty") String difficulty,
            @Param("p_needs_special_equipment") Boolean needsSpecialEquipment,
            @Param("p_specifications") String specifications,
            @Param("p_level") String level
    );

}
