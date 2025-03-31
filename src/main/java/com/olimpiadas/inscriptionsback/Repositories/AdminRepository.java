package com.olimpiadas.inscriptionsback.Repositories;

import com.olimpiadas.inscriptionsback.Models.Administrator;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Administrator, Integer> {

    @Transactional
    @Query(value = "SELECT edit_administrator(:email, :password)", nativeQuery = true)
    String actualizarAdministrador(String email, String password);

    @Transactional
    @Query(value = "Select delete_administrator(:email)", nativeQuery = true)
    String deleteAdministrador(String email);

    @Transactional
    @Query(value ="Select * from administrator where email = :email", nativeQuery = true)
    Optional<Administrator> findByEmail(String email);
}
