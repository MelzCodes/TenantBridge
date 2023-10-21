package com.tenantbridge.api.service.auth;

import com.tenantbridge.api.common.responses.AuthenticationResponse;
import com.tenantbridge.api.common.requests.LoginRequestBody;
import com.tenantbridge.api.common.requests.RegistrationRequestBody;
import com.tenantbridge.api.model.Role;
import com.tenantbridge.api.model.User;
import com.tenantbridge.api.repository.UserRepository;
import com.tenantbridge.api.service.auth.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JWTService jwtService;
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
            userRepository.save(user);
            String jwtToken = jwtService.generateToken(user);
            return new ResponseEntity<>(new AuthenticationResponse(true, "User successfully created", jwtToken), HttpStatus.CREATED);
        }

        return new ResponseEntity<>(new AuthenticationResponse(false, "User already exists", null), HttpStatus.UNAUTHORIZED);
    }

    public ResponseEntity<AuthenticationResponse> authenticate(LoginRequestBody requestBody){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        requestBody.email(),
                        requestBody.password()
                )
        );
        if(userRepository.findUserByEmail(requestBody.email()).isEmpty())
            return new ResponseEntity<>(new AuthenticationResponse(false, "User doesn't exist", null), HttpStatus.NOT_FOUND);
        User user = userRepository.findUserByEmail(requestBody.email()).get();
        String jwtToken = jwtService.generateToken(user);
        return new ResponseEntity<>(new AuthenticationResponse(true, "User authenticated", jwtToken), HttpStatus.OK);
    }

}
