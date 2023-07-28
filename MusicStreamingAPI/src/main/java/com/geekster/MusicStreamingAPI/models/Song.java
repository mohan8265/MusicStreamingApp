package com.geekster.MusicStreamingAPI.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer songId;
    @NotBlank(message = "song name can't be blank")
    private String songName;
    @NotEmpty(message = "song album can't be empty")
    private String songAlbum;
    @NotEmpty(message = "song sing can't be empty")
    private String songSinger;
    private Integer songReleasedYear;

}
