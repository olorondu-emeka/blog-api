package com.emeka.blogspringboot.controllers;

import com.emeka.blogspringboot.models.Admin;
import com.emeka.blogspringboot.services.AdminService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AdminController {
    private AdminService adminService;

    @PostMapping("/admin")
    public String createAdmin(@RequestBody Admin admin) {
        return adminService.createAdmin(admin);
    }
}
