package com.olimpiadas.inscriptionsback.Repositories;

import com.olimpiadas.inscriptionsback.Models.ActivityResults;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityResultsRepository extends JpaRepository<ActivityResults, Long> {
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO activity_results (athlete_id, activity_id, position, time) VALUES (:athleteId, :activityId, :position, :time)", nativeQuery = true)
    void saveResult(String athleteId, Long activityId, String position, String time);
}
