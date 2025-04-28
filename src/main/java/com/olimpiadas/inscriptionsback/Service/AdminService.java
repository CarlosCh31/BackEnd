package com.olimpiadas.inscriptionsback.Service;


import com.olimpiadas.inscriptionsback.Controllers.AdminController;
import com.olimpiadas.inscriptionsback.Models.Administrator;

import com.olimpiadas.inscriptionsback.Repositories.AdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public Administrator save(Administrator admin) {
        return adminRepository.save(admin);
    }

    public List<Administrator> findAll() {
        return adminRepository.findAll();
    }

    public Administrator findById(Integer id) {
        Optional<Administrator> admin = adminRepository.findById(id);
        return admin.orElse(null);
    }

    public void deleteById(String email) {
        adminRepository.deleteAdministrador(email);
    }

    public Optional<Administrator> findByIdAndPassword(String email, String password) {
        Optional<Administrator> admin = adminRepository.findAll().stream()
                .findFirst();
        if (password.equals(admin.get().getPassword()) && email.equals(admin.get().getEmail()) ) {
            return admin;
        };
        return Optional.empty();
    }

    public Optional<Administrator> findByEmail(String email) {
        return adminRepository.findByEmail(email);
    }

    public String actualizarAdministrador(String email, String password) {
        return this.adminRepository.actualizarAdministrador(email, password);
    }

    /*public Administrator update(Administrator admin) {
        if (adminRepository.existsById(admin.getId())) {
            return adminRepository.save(admin);
        }
        return null;
    }

     */
}
