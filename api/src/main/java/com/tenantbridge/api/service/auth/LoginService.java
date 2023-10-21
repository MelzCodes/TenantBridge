package com.tenantbridge.api.service.auth;

import com.tenantbridge.api.common.responses.BaseApiResponse;
import com.tenantbridge.api.common.requests.LoginRequestBody;
import com.tenantbridge.api.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginService {

    private UserRepository userRepository;

    public ResponseEntity<BaseApiResponse> login(LoginRequestBody requestBody){

        return new ResponseEntity<>(new BaseApiResponse(false, "User with this email already exists"), HttpStatus.UNAUTHORIZED);
    }

}
