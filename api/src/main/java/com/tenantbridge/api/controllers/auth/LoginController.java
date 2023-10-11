package com.tenantbridge.api.controllers.auth;

import com.tenantbridge.api.common.ApiResponse;
import com.tenantbridge.api.common.LoginDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginController {

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestBody LoginDetails loginDetails){
        return new ResponseEntity<>(new ApiResponse(true, "Logged in successfully"), HttpStatus.OK);
    }
}
