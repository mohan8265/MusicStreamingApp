package com.geekster.MusicStreamingAPI.services;

import com.geekster.MusicStreamingAPI.models.AuthenticationToken;
import com.geekster.MusicStreamingAPI.models.User;
import com.geekster.MusicStreamingAPI.repositories.IAuthTokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthTokenService {
    @Autowired
    private IAuthTokenRepo authTokenRepo;

    public AuthenticationToken getTokenByUser(User existingUser ){
        return authTokenRepo.findByUser(existingUser);
    }

    public String addToken(User existingUser) {
        AuthenticationToken authenticationToken = new AuthenticationToken(existingUser);
        authTokenRepo.save(authenticationToken);
        return authenticationToken.getTokenValue();
    }

    public void deleteToken(AuthenticationToken existingToken) {
        authTokenRepo.delete(existingToken);
    }
}
