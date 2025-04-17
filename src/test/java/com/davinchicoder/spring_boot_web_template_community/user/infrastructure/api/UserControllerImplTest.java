package com.davinchicoder.spring_boot_web_template_community.user.infrastructure.api;

import com.davinchicoder.spring_boot_web_template_community.common.mediator.Mediator;
import com.davinchicoder.spring_boot_web_template_community.user.application.query.getAllUsers.GetAllUsersResponse;
import com.davinchicoder.spring_boot_web_template_community.user.application.query.getUser.GetUserResponse;
import com.davinchicoder.spring_boot_web_template_community.user.domain.entity.User;
import com.davinchicoder.spring_boot_web_template_community.user.infrastructure.api.dto.RegisterUserDTO;
import com.davinchicoder.spring_boot_web_template_community.user.infrastructure.api.dto.UserDTO;
import com.davinchicoder.spring_boot_web_template_community.user.infrastructure.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserControllerImplTest {

    @Mock
    private Mediator mediator;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserControllerImpl controller;

    private final User user = User.builder().id(1L).build();
    private final UserDTO userDTO = UserDTO.builder().id(1L).build();

    @Test
    void findById() {

        when(mediator.dispatch(any())).thenReturn(new GetUserResponse(user));
        when(userMapper.userToUserDTO(user)).thenReturn(userDTO);

        ResponseEntity<UserDTO> response = controller.findById(1L);
        assertEquals(HttpStatusCode.valueOf(200), response.getStatusCode());
    }

    @Test
    void findAll() {
        when(mediator.dispatch(any())).thenReturn(new GetAllUsersResponse(List.of(user)));
        when(userMapper.userToUserDTO(user)).thenReturn(userDTO);

        ResponseEntity<List<UserDTO>> response = controller.findAll();
        assertEquals(HttpStatusCode.valueOf(200), response.getStatusCode());
    }

    @Test
    void update() {

        ResponseEntity<Void> response = controller.update(userDTO);
        assertEquals(HttpStatusCode.valueOf(204), response.getStatusCode());
    }

    @Test
    void delete() {
        ResponseEntity<Void> response = controller.delete(1L);
        assertEquals(HttpStatusCode.valueOf(204), response.getStatusCode());
    }

    @Test
    void register() {
        when(mediator.dispatch(any())).thenReturn(void.class);
        when(userMapper.registerUserDTOToUser(any())).thenReturn(user);

        RegisterUserDTO userRegisterDTO = RegisterUserDTO.builder().build();

        ResponseEntity<Void> response = controller.register(userRegisterDTO);
        assertEquals(HttpStatusCode.valueOf(204), response.getStatusCode());
    }
}