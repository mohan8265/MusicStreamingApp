package com.geekster.MusicStreamingAPI.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer listId;

    @OneToOne
    @JoinColumn(name = "fk_user_id")
    private User user;

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "fk_playlist_id"), inverseJoinColumns = @JoinColumn(name = "fk_song_id"))
    private List<Song> songs;
}
