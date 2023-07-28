package com.geekster.MusicStreamingAPI.repositories;

import com.geekster.MusicStreamingAPI.models.Playlist;
import com.geekster.MusicStreamingAPI.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlaylistRepo extends JpaRepository<Playlist,Integer> {
    Playlist findByUser(User existingUser);
}
