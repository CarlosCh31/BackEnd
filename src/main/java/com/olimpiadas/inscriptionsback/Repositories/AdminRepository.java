package com.olimpiadas.inscriptionsback.Repositories;

import com.olimpiadas.inscriptionsback.Models.Administrator;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Administrator, Integer> {

    @Transactional
    @Query(value = "SELECT * FROM veriy_administrator(:p_email, :p_password);", nativeQuery = true)
    Administrator login(@Param("p_email") String p_email,
                        @Param("p_email") String p_password);
}
