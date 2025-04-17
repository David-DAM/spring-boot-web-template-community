package com.davinchicoder.spring_boot_web_template_community.user.infrastructure.api.dto;


import com.davinchicoder.spring_boot_web_template_community.user.domain.entity.Role;
import com.davinchicoder.spring_boot_web_template_community.user.infrastructure.annotation.MaskData;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    private Long id;
    private String firstname;
    private String lastname;
    @MaskData
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;

}
