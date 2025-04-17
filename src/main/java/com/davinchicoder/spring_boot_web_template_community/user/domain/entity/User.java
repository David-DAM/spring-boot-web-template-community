package com.davinchicoder.spring_boot_web_template_community.user.domain.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Role role;
}
