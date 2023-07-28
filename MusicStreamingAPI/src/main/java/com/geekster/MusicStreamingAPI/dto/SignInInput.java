package com.geekster.MusicStreamingAPI.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignInInput {
    @Email(message = "provide a correct email")
    private String email;
    @NotBlank(message = "user password can't be blank")
    private String password;
}
