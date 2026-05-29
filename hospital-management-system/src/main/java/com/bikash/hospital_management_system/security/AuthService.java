package com.bikash.hospital_management_system.security;

import com.bikash.hospital_management_system.dto.LoginRequestDto;
import com.bikash.hospital_management_system.dto.LoginResponseDto;
import com.bikash.hospital_management_system.dto.SignupRequestDto;
import com.bikash.hospital_management_system.dto.SignupResponseDto;
import com.bikash.hospital_management_system.entity.User;
import com.bikash.hospital_management_system.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public LoginResponseDto login(LoginRequestDto loginRequestDto) {

        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                loginRequestDto.getUsername(),
                                loginRequestDto.getPassword()
                        )
                );

        User user = (User) authentication.getPrincipal();

        String token = jwtService.generateToken(user);

        return new LoginResponseDto(
                token,
                user.getId()
        );
    }



    public SignupResponseDto signup(SignupRequestDto signupRequestDto) {

        if (userRepository.existsByUsername(
                signupRequestDto.getUsername())) {

            throw new RuntimeException(
                    "Username already exists"
            );
        }

        User user = new User();

        user.setUsername(
                signupRequestDto.getUsername()
        );

        user.setPassword(
                passwordEncoder.encode(
                        signupRequestDto.getPassword()
                )
        );

        user.setRole(
                signupRequestDto.getRole()
        );

        User savedUser =
                userRepository.save(user);

        return new SignupResponseDto(
                savedUser.getId(),
                savedUser.getUsername()
        );
    }
}