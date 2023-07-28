package com.geekster.MusicStreamingAPI.controllers;

import com.geekster.MusicStreamingAPI.models.Playlist;
import com.geekster.MusicStreamingAPI.models.Song;
import com.geekster.MusicStreamingAPI.services.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playlist")
public class PlaylistController {
    @Autowired
    private PlaylistService playlistService;

    @PostMapping("/addSongs")
    public String addSongs(@RequestBody Playlist playlist, @RequestParam String email){
        return playlistService.addSongs(playlist,email);
    }
    @GetMapping("/fetchSongs")
    public List<Song> getTenSongs(@RequestParam String email){
        return playlistService.getTenSongs(email);
    }
    @PutMapping("/update")
    public String updateByEmail(@RequestBody Playlist playlist,@RequestParam String email){
        return playlistService.updateByEmail(playlist,email);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable Integer id,@RequestParam String email){
        return playlistService.deleteById(id,email);
    }

}
