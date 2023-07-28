package com.geekster.MusicStreamingAPI.services;

import com.geekster.MusicStreamingAPI.models.Admin;
import com.geekster.MusicStreamingAPI.models.Song;
import com.geekster.MusicStreamingAPI.repositories.ISongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {
    @Autowired
    private ISongRepo songRepo;
    @Autowired
    private AdminService adminService;

    public boolean checkSong(Integer songId){
        return songRepo.existsById(songId);
    }

    public String addSong(Song song, String email) {
        Admin existingAdmin = adminService.getAdminByEmail(email);
        if(existingAdmin == null){
            return "Not a valid person. First!! add the person in admin table";
        }
        songRepo.save(song);
        return "song added";
    }

    public List<Song> getAllSongs(String email) {
        Admin existingAdmin = adminService.getAdminByEmail(email);
        if(existingAdmin == null){
            throw new IllegalStateException("Not a valid person. First!! add the person in admin table");
        }
        return songRepo.findAll();
    }

    public Song getSongById(Integer id, String email) {
        Admin existingAdmin = adminService.getAdminByEmail(email);
        if(existingAdmin == null){
            throw new IllegalStateException("Not a valid person. First!! add the person in admin table");
        }

        return songRepo.findById(id).orElse(null);
    }

    public String updateById(Integer id,Song song, String email) {
        Admin existingAdmin = adminService.getAdminByEmail(email);
        if(existingAdmin == null){
            return "Not a valid person. First!! add the person in admin table";
        }

        Song existingSong = songRepo.findById(id).orElse(null);
        if(existingSong == null){
            return "song with id: " + id + " doesn't exist";
        }

        song.setSongId(id);
        songRepo.save(song);
        return "song's information updated";
    }

    public String deleteById(Integer id, String email) {
        Admin existingAdmin = adminService.getAdminByEmail(email);
        if(existingAdmin == null){
            return "Not a valid person. First!! add the person in admin table";
        }

        Song existingSong = songRepo.findById(id).orElse(null);
        if(existingSong == null){
            return "song with id: " + id + " doesn't exist";
        }

        songRepo.deleteById(id);
        return "song deleted successfully";
    }
}
