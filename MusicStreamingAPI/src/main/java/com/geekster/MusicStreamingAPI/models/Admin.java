package com.geekster.MusicStreamingAPI.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adminId;
    @NotBlank(message = "admin name can't be blank")
    private String adminName;
    @Pattern(regexp = "\\w+@admin\\.com",message = "Email must end with @admin.com")
    private String adminEmail;
    @NotBlank(message = "password can't be blank")
    private String adminPassword;

}
