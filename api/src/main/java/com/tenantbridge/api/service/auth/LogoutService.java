package com.tenantbridge.api.service.auth;

import com.tenantbridge.api.model.user.Token;
import com.tenantbridge.api.repository.TokenRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogoutService implements LogoutHandler {

    private final TokenRepository tokenRepository;

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        final String authenticationHeader = request.getHeader("Authorization");
        final String jwt;

        if (authenticationHeader == null || !authenticationHeader.startsWith("Bearer ")) {
            return;
        }
        jwt = authenticationHeader.substring(7);
        Token storedToken = tokenRepository.findByToken(jwt).orElse(null);
        if(storedToken != null){
            storedToken.setExpired(true);
            storedToken.setRevoked(true);
            tokenRepository.save(storedToken);
        }
    }
}
