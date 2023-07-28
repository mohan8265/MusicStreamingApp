package com.geekster.MusicStreamingAPI.repositories;

import com.geekster.MusicStreamingAPI.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongRepo extends JpaRepository<Song,Integer> {
}
