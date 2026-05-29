package com.bikash.hospital_management_system.controller;

import com.bikash.hospital_management_system.dto.LoginRequestDto;
import com.bikash.hospital_management_system.dto.LoginResponseDto;
import com.bikash.hospital_management_system.dto.SignupRequestDto;
import com.bikash.hospital_management_system.dto.SignupResponseDto;
import com.bikash.hospital_management_system.security.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto) {
        return ResponseEntity.ok(authService.login(loginRequestDto));
    }

    @PostMapping("/signup")
    public ResponseEntity<SignupResponseDto> signup(@RequestBody SignupRequestDto signupRequestDto){
        return ResponseEntity.ok(authService.signup(signupRequestDto));

    }

}
