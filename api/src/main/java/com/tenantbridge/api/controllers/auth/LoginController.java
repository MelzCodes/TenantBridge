package com.tenantbridge.api.controllers.auth;

import com.tenantbridge.api.common.ApiResponse;
import com.tenantbridge.api.common.LoginRequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/login")
public class LoginController {

    @PostMapping
    public ResponseEntity<ApiResponse> login(@RequestBody LoginRequestBody loginDetails){
        return new ResponseEntity<>(new ApiResponse(true, "Logged in successfully"), HttpStatus.OK);
    }
}
