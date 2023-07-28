package com.geekster.MusicStreamingAPI.services;

import com.geekster.MusicStreamingAPI.models.Admin;
import com.geekster.MusicStreamingAPI.repositories.IAdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private IAdminRepo adminRepo;

    public String addAdmin(Admin admin) {
        Admin existingAdmin = adminRepo.findByAdminEmail(admin.getAdminEmail());
        if(existingAdmin != null){
            return "admin with email " + admin.getAdminEmail() + " already present";
        }
        try{
            String encryptedPassword = PasswordEncrypter.encryptPassword(admin.getAdminPassword());
            admin.setAdminPassword(encryptedPassword);
            adminRepo.save(admin);
            return "admin details added";
        }
        catch (Exception e){
            return "Internal error occurred during adding admin";
        }
    }

    public List<Admin> getAllAdmins() {
        return adminRepo.findAll();
    }

    public String deleteByEmail(String email) {
        Admin existingAdmin = adminRepo.findByAdminEmail(email);
        if(existingAdmin == null){
            return "admin with email: " + email + " doesn't exist";
        }
        adminRepo.delete(existingAdmin);
        return "deleted successfully";
    }

    public Admin getAdminByEmail(String email) {
        return adminRepo.findByAdminEmail(email);
    }
}
