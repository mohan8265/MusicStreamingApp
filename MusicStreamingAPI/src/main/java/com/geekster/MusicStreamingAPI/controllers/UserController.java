package com.geekster.MusicStreamingAPI.controllers;

import com.geekster.MusicStreamingAPI.dto.SignInInput;
import com.geekster.MusicStreamingAPI.models.User;
import com.geekster.MusicStreamingAPI.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public String signUp(@RequestBody @Valid User user){
        return userService.signUp(user);
    }
    @PostMapping("/signin")
    public String signIn(@RequestBody @Valid SignInInput signInInput){
        return userService.signIn(signInInput);
    }
    @DeleteMapping("/signout")
    public String signOut(@PathVariable String email,@PathVariable String tokenValue){
        return userService.signOut(email,tokenValue);
    }
}
