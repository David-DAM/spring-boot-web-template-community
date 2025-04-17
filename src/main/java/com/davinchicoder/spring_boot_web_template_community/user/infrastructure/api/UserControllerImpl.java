package com.davinchicoder.spring_boot_web_template_community.user.infrastructure.api;


import com.davinchicoder.spring_boot_web_template_community.common.mediator.Mediator;
import com.davinchicoder.spring_boot_web_template_community.user.application.command.deleteUser.DeleteUserRequest;
import com.davinchicoder.spring_boot_web_template_community.user.application.command.registerUser.RegisterUserRequest;
import com.davinchicoder.spring_boot_web_template_community.user.application.command.updateUser.UpdateUserRequest;
import com.davinchicoder.spring_boot_web_template_community.user.application.query.getAllUsers.GetAllUsersRequest;
import com.davinchicoder.spring_boot_web_template_community.user.application.query.getAllUsers.GetAllUsersResponse;
import com.davinchicoder.spring_boot_web_template_community.user.application.query.getUser.GetUserRequest;
import com.davinchicoder.spring_boot_web_template_community.user.application.query.getUser.GetUserResponse;
import com.davinchicoder.spring_boot_web_template_community.user.domain.entity.User;
import com.davinchicoder.spring_boot_web_template_community.user.infrastructure.api.dto.RegisterUserDTO;
import com.davinchicoder.spring_boot_web_template_community.user.infrastructure.api.dto.UserDTO;
import com.davinchicoder.spring_boot_web_template_community.user.infrastructure.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@RestController
public class UserControllerImpl implements UserController {

    private final Mediator mediator;
    private final UserMapper userMapper;

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id) {

        GetUserResponse response = mediator.dispatch(new GetUserRequest(id));

        UserDTO userDTO = userMapper.userToUserDTO(response.user());

        return ResponseEntity.ok(userDTO);
    }

    @GetMapping()
    public ResponseEntity<List<UserDTO>> findAll() {

        GetAllUsersResponse response = mediator.dispatch(new GetAllUsersRequest());

        List<UserDTO> userDTOS = response.users().stream().map(userMapper::userToUserDTO).toList();

        return ResponseEntity.ok(userDTOS);
    }

    @PutMapping()
    public ResponseEntity<Void> update(@RequestBody UserDTO userDTO) {

        User user = userMapper.userDTOToUser(userDTO);

        mediator.dispatch(new UpdateUserRequest(user));

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        mediator.dispatch(new DeleteUserRequest(id));

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody @Validated RegisterUserDTO request) {

        User user = userMapper.registerUserDTOToUser(request);

        mediator.dispatch(new RegisterUserRequest(user));

        return ResponseEntity.noContent().build();
    }

}


