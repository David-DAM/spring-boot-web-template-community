package com.davinchicoder.spring_boot_web_template_community.user.application.command.registerUser;

import com.davinchicoder.spring_boot_web_template_community.user.domain.entity.User;
import com.davinchicoder.spring_boot_web_template_community.user.domain.port.UserRepository;
import com.davinchicoder.spring_boot_web_template_community.user.infrastructure.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RegisterUserHandlerTest {

    @Mock
    private UserMapper userMapper;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private RegisterUserHandler handler;

    @Test
    void handle() {

        RegisterUserRequest request = new RegisterUserRequest(User.builder().email("test@gmail.com").password("12345").build());

        when(userRepository.existsByEmail(request.user().getEmail())).thenReturn(false);

        User savedUser = User.builder().build();
        savedUser.setEmail("test@example.com");
        savedUser.setPassword("encodedPass");

        when(userRepository.save(request.user())).thenReturn(savedUser);

        handler.handle(request);
        verify(userRepository).save(any(User.class));
    }

    @Test
    void handleErrorUserExist() {

        RegisterUserRequest request = new RegisterUserRequest(User.builder().email("test@gmail.com").password("12345").build());

        when(userRepository.existsByEmail(request.user().getEmail())).thenReturn(true);

        assertThrows(RuntimeException.class, () -> handler.handle(request));
    }

    @Test
    void getRequestType() {
        assertEquals(RegisterUserRequest.class, handler.getRequestType());
    }

}