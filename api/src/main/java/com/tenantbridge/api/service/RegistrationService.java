package com.tenantbridge.api.service;

import com.tenantbridge.api.common.ApiResponse;
import com.tenantbridge.api.common.RegistrationRequestBody;
import com.tenantbridge.api.model.User;
import com.tenantbridge.api.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
@AllArgsConstructor
public class RegistrationService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public ResponseEntity<ApiResponse> register(RegistrationRequestBody requestBody){

        if(userRepository.findUserByEmail(requestBody.email()).isEmpty()){
            User user = new User(
                    requestBody.firstName(),
                    requestBody.lastName(),
                    requestBody.email(),
                    requestBody.password()
            );
            String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            userRepository.save(user);
            return new ResponseEntity<>(new ApiResponse(true, "User successfully created"), HttpStatus.CREATED);
        }

        return new ResponseEntity<>(new ApiResponse(false, "User with this email already exists"), HttpStatus.UNAUTHORIZED);
    }

}
