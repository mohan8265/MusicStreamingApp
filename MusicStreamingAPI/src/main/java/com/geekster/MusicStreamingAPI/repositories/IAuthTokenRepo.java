package com.geekster.MusicStreamingAPI.repositories;

import com.geekster.MusicStreamingAPI.models.AuthenticationToken;
import com.geekster.MusicStreamingAPI.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthTokenRepo extends JpaRepository<AuthenticationToken,Integer> {
    AuthenticationToken findByUser(User existingUser);
}
