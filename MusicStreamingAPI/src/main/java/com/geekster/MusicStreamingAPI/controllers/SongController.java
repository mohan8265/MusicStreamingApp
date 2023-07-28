package com.geekster.MusicStreamingAPI.controllers;

import com.geekster.MusicStreamingAPI.models.Song;
import com.geekster.MusicStreamingAPI.services.SongService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/song")
@Validated
public class SongController {
    @Autowired
    private SongService songService;

    @PostMapping("/add")
    public String addSong(@RequestBody @Valid Song song, @RequestParam String email){
        return songService.addSong(song,email);
    }
    @GetMapping("/fetchAll")
    public List<Song> getAllSongs(@RequestParam String email){
        return songService.getAllSongs(email);
    }
    @GetMapping("/fetch/{id}")
    public Song getSongById(@PathVariable Integer id,@RequestParam String email){
        return songService.getSongById(id,email);
    }
    @PutMapping("/update/{id}")
    public String updateById(@PathVariable Integer id,@RequestBody @Valid Song song,@RequestParam String email){
        return songService.updateById(id,song,email);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable Integer id,@RequestParam String email){
        return songService.deleteById(id,email);
    }
}
