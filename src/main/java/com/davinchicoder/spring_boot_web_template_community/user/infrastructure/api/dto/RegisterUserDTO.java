package com.davinchicoder.spring_boot_web_template_community.user.infrastructure.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserDTO {

    private String firstname;

    private String lastname;

    private String email;

    private String password;
}
