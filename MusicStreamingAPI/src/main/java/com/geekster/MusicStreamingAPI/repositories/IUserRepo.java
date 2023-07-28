package com.geekster.MusicStreamingAPI.repositories;

import com.geekster.MusicStreamingAPI.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User,Integer> {
    User findByUserEmail(String userEmail);
}
