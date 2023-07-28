package com.geekster.MusicStreamingAPI.services;

import com.geekster.MusicStreamingAPI.dto.SignInInput;
import com.geekster.MusicStreamingAPI.models.AuthenticationToken;
import com.geekster.MusicStreamingAPI.models.User;
import com.geekster.MusicStreamingAPI.repositories.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private IUserRepo userRepo;
    @Autowired
    private AuthTokenService authTokenService;

    public String signUp(User user) {
        User existingUser = userRepo.findByUserEmail(user.getUserEmail());
        if(existingUser != null){
            return "user already registered";
        }
        try {
            String encryptedPassword = PasswordEncrypter.encryptPassword(user.getUserPassword());
            user.setUserPassword(encryptedPassword);
            userRepo.save(user);
            return "Registered successfully";
        }
        catch (Exception e){
            return "Internal error occurred during signup please try after some time";
        }
    }

    public String signIn(SignInInput signInInput) {
        User existingUser = userRepo.findByUserEmail(signInInput.getEmail());
        if(existingUser == null){
            return "sign up first";
        }

        AuthenticationToken existingToken  = authTokenService.getTokenByUser(existingUser);
        if(existingToken != null){
            return "already signed in";
        }
        try {
            String encryptedPassword = PasswordEncrypter.encryptPassword(signInInput.getPassword());
            if(!existingUser.getUserPassword().equals(encryptedPassword)){
                return "password incorrect";
            }
        }
        catch (Exception e){
            return "Internal error occurred during sign in please try after some time";
        }

        String tokenValue = authTokenService.addToken(existingUser);
        return "sign in successfully your Token value is: " + tokenValue;
    }

    public User getUserByEmail(String email) {
        return userRepo.findByUserEmail(email);
    }

    public String signOut(String email, String tokenValue) {
        User existingUser = userRepo.findByUserEmail(email);
        if(existingUser == null){
            return "sign up first";
        }
        AuthenticationToken existingToken  = authTokenService.getTokenByUser(existingUser);
        if(!tokenValue.equals(existingToken.getTokenValue())){
            return "Provide a correct token value";
        }
        authTokenService.deleteToken(existingToken);
        return "sign out successfully";
    }
}
