package com.geekster.MusicStreamingAPI.repositories;

import com.geekster.MusicStreamingAPI.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdminRepo extends JpaRepository<Admin,Integer> {
    Admin findByAdminEmail(String email);
}
