package com.davinchicoder.spring_boot_web_template_community.user.application.command.deleteUser;

import com.davinchicoder.spring_boot_web_template_community.user.domain.port.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DeleteUserHandlerTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private DeleteUserHandler handler;

    @Test
    void handle() {

        DeleteUserRequest request = new DeleteUserRequest(1L);

        handler.handle(request);

        verify(userRepository).deleteById(request.userId());
    }

    @Test
    void getRequestType() {
        assertEquals(DeleteUserRequest.class, handler.getRequestType());
    }
}