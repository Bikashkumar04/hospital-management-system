package com.bikash.hospital_management_system.dto;

import com.bikash.hospital_management_system.entity.Role;
import lombok.*;
import org.springframework.data.repository.cdi.Eager;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequestDto {
    private String username;
    private String password;
    private Role role;

}
