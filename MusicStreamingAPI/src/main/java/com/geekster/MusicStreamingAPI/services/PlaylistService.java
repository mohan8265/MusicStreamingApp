package com.geekster.MusicStreamingAPI.services;

import com.geekster.MusicStreamingAPI.models.AuthenticationToken;
import com.geekster.MusicStreamingAPI.models.Playlist;
import com.geekster.MusicStreamingAPI.models.Song;
import com.geekster.MusicStreamingAPI.models.User;
import com.geekster.MusicStreamingAPI.repositories.IPlaylistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistService {
    @Autowired
    private IPlaylistRepo playlistRepo;
    @Autowired
    private UserService userService;
    @Autowired
    private AuthTokenService authTokenService;
    @Autowired
    private SongService songService;

    public String addSongs(Playlist playlist,String email) {
        User existingUser = userService.getUserByEmail(email);
        if(existingUser == null){
            return "provide a registered email";
        }
        AuthenticationToken token = authTokenService.getTokenByUser(existingUser);
        if(token == null){
            return "sign in first";
        }

        for(Song song:playlist.getSongs()){
            Integer songId = song.getSongId();
            if(!songService.checkSong(songId)){
                return "song with id: " + songId + " doesn't exist";
            }
        }

        playlistRepo.save(playlist);
        return "songs added to your playlist";
    }

    public List<Song> getAllSongs(String email) {
        User existingUser = userService.getUserByEmail(email);
        if(existingUser == null){
            throw new IllegalStateException("provide a registered email");
        }
        AuthenticationToken token = authTokenService.getTokenByUser(existingUser);
        if(token == null){
            throw new IllegalStateException("sign in first");
        }

        Playlist playlist = playlistRepo.findByUser(existingUser);
        List<Song> songs = playlist.getSongs();
        return songs;
    }

    public String updateByEmail(Playlist playlist,String email) {
        User existingUser = userService.getUserByEmail(email);
        if(existingUser == null){
            return "provide a registered email";
        }
        AuthenticationToken token = authTokenService.getTokenByUser(existingUser);
        if(token == null){
            return "sign in first";
        }

        for(Song song:playlist.getSongs()){
            Integer songId = song.getSongId();
            if(!songService.checkSong(songId)){
                return "song with id: " + songId + " doesn't exist";
            }
        }

        playlistRepo.save(playlist);
        return "playlist updated";
    }


    public String deleteById(Integer id,String email) {
        User existingUser = userService.getUserByEmail(email);
        if(existingUser == null){
            return "provide a registered email";
        }
        AuthenticationToken token = authTokenService.getTokenByUser(existingUser);
        if(token == null){
            return "sign in first";
        }

        if(!playlistRepo.existsById(id)){
            return "playlist with id: " + id + " doesn't exist";
        }

        playlistRepo.deleteById(id);
        return "deleted successfully";
    }
}
