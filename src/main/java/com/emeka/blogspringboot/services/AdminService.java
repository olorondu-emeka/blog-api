package com.emeka.blogspringboot.services;

import com.emeka.blogspringboot.models.Admin;
import com.emeka.blogspringboot.repositories.AdminRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    private AdminRepository adminRepository;

    public String createAdmin(Admin admin) {
        admin.setRole("ADMIN");
        adminRepository.save(admin);
        return "Admin created successfully";
    }
}
