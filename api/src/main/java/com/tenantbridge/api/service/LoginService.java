package com.tenantbridge.api.service;

import com.tenantbridge.api.common.ApiResponse;
import com.tenantbridge.api.common.LoginRequestBody;
import com.tenantbridge.api.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginService {

    private UserRepository userRepository;

    public ResponseEntity<ApiResponse> login(LoginRequestBody requestBody){

        return new ResponseEntity<>(new ApiResponse(false, "User with this email already exists"), HttpStatus.UNAUTHORIZED);
    }

}
