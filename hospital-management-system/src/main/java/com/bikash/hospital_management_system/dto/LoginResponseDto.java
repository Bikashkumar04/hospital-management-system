package com.bikash.hospital_management_system.dto;

import lombok.*;
import org.jspecify.annotations.Nullable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDto {
    public String jwt;
    public Long UserId;

}
