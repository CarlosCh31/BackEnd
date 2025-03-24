package com.olimpiadas.inscriptionsback.Repositories;

import com.olimpiadas.inscriptionsback.Models.Workshop;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkshopRepository extends JpaRepository<Workshop, Long> {

    @Transactional
    @Query(value = "SELECT save_workshop(" +
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
            "CAST(:p_objectives AS VARCHAR), " +
            "CAST(:p_target_audience AS VARCHAR), " +
            "CAST(:p_needs_material AS BOOLEAN), " +
            "CAST(:p_specifications AS VARCHAR))",
            nativeQuery = true)
    String saveWorkshop(
            @Param("p_type") String type,
            @Param("p_name") String name,
            @Param("p_description") String description,
            @Param("p_date") java.sql.Date date,
            @Param("p_time") java.sql.Time time,
            @Param("p_duration") String duration,
            @Param("p_modality") String modality,
            @Param("p_location") String location,
            @Param("p_max_participants") Integer maxParticipants,
            @Param("p_minimum_age") Integer minimumAge,
            @Param("p_maximum_age") Integer maximumAge,
            @Param("p_admin_email") String adminEmail,
            @Param("p_state") String state,
            @Param("p_objectives") String objectives,
            @Param("p_target_audience") String targetAudience,
            @Param("p_needs_material") Boolean needsMaterial,
            @Param("p_specifications") String specifications
    );
}

