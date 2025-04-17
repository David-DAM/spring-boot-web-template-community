package com.davinchicoder.spring_boot_web_template_community.user.infrastructure.api;


import com.davinchicoder.spring_boot_web_template_community.user.infrastructure.api.dto.RegisterUserDTO;
import com.davinchicoder.spring_boot_web_template_community.user.infrastructure.api.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserController {

    ResponseEntity<UserDTO> findById(@PathVariable Long id);

    ResponseEntity<List<UserDTO>> findAll();

    ResponseEntity<Void> update(@RequestBody UserDTO userDTO);

    ResponseEntity<Void> delete(@PathVariable Long id);

    ResponseEntity<Void> register(@RequestBody RegisterUserDTO request);
}
