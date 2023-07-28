package com.geekster.MusicStreamingAPI.controllers;

import com.geekster.MusicStreamingAPI.models.Admin;
import com.geekster.MusicStreamingAPI.services.AdminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@Validated
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/add")
    public String addAdmin(@RequestBody @Valid Admin admin){
        return adminService.addAdmin(admin);
    }
    @GetMapping("/fetchList")
    public List<Admin> getAllAdmins(){
        return adminService.getAllAdmins();
    }
    @DeleteMapping("/remove/{email}")
    public String deleteByEmail(@PathVariable String email){
        return adminService.deleteByEmail(email);
    }
}
