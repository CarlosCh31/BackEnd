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

    public void deleteById(Integer id) {
        adminRepository.deleteById(id);
    }

    public Administrator findByIdAndPassword(String email, String password) {
        return adminRepository.login(email, password);
    }

    /*public Administrator update(Administrator admin) {
        if (adminRepository.existsById(admin.getId())) {
            return adminRepository.save(admin);
        }
        return null;
    }

     */
}
