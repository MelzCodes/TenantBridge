package com.tenantbridge.api.service.auth;

import com.tenantbridge.api.common.responses.AuthenticationResponse;
import com.tenantbridge.api.common.requests.LoginRequestBody;
import com.tenantbridge.api.common.requests.RegistrationRequestBody;
import com.tenantbridge.api.model.user.Role;
import com.tenantbridge.api.model.user.Token;
import com.tenantbridge.api.model.user.TokenType;
import com.tenantbridge.api.model.user.User;
import com.tenantbridge.api.repository.TokenRepository;
import com.tenantbridge.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public ResponseEntity<AuthenticationResponse> register(RegistrationRequestBody requestBody){

        if (userRepository.findUserByEmail(requestBody.email()).isEmpty()) {
            User user = User.builder()
                    .firstName(requestBody.firstName())
                    .lastName(requestBody.lastName())
                    .email(requestBody.email())
                    .password(requestBody.password())
                    .role(Role.USER)
                    .build();
            String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            User savedUser = userRepository.save(user);
            String jwtToken = jwtService.generateToken(user);
            saveUserToken(savedUser, jwtToken);
            return new ResponseEntity<>(new AuthenticationResponse(true, "User successfully created", requestBody.email(), jwtToken), HttpStatus.CREATED);
        }

        return new ResponseEntity<>(new AuthenticationResponse(false, "User already exists", requestBody.email(), null), HttpStatus.UNAUTHORIZED);
    }

    public ResponseEntity<AuthenticationResponse> login(LoginRequestBody requestBody){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        requestBody.email(),
                        requestBody.password()
                )
        );

        if(userRepository.findUserByEmail(requestBody.email()).isEmpty()) {
            return new ResponseEntity<>(new AuthenticationResponse(false, "User doesn't exist, please register", requestBody.email(), null), HttpStatus.UNAUTHORIZED);
        }

        User user = userRepository.findUserByEmail(requestBody.email()).get();
        String jwtToken = jwtService.generateToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);

        return ResponseEntity.ok(new AuthenticationResponse(true, "User logged in successfully", requestBody.email(), jwtToken));
    }

    private void saveUserToken(User user, String jwtToken) {
        Token token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }

    private void revokeAllUserTokens(User user){
        List<Token> validTokens = tokenRepository.findTokensByUserAndExpiredAndRevoked(user, false, false);
        if(validTokens.isEmpty()) return;
        validTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validTokens);
    }
}
