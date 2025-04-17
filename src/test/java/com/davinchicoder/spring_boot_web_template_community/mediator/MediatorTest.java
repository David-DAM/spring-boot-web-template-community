package com.davinchicoder.spring_boot_web_template_community.mediator;

import com.davinchicoder.spring_boot_web_template_community.common.mediator.Mediator;
import com.davinchicoder.spring_boot_web_template_community.user.application.query.getAllUsers.GetAllUsersHandler;
import com.davinchicoder.spring_boot_web_template_community.user.application.query.getAllUsers.GetAllUsersRequest;
import com.davinchicoder.spring_boot_web_template_community.user.application.query.getAllUsers.GetAllUsersResponse;
import com.davinchicoder.spring_boot_web_template_community.user.application.query.getUser.GetUserRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MediatorTest {
    @Mock
    private GetAllUsersHandler getAllUsersHandler;

    private Mediator mediator;

    @Test
    void dispatch() {
        when(getAllUsersHandler.getRequestType()).thenReturn(GetAllUsersRequest.class);
        when(getAllUsersHandler.handle(any(GetAllUsersRequest.class))).thenReturn(new GetAllUsersResponse(List.of()));
        mediator = new Mediator(List.of(getAllUsersHandler));

        GetAllUsersRequest request = new GetAllUsersRequest();

        mediator.dispatch(request);

        verify(getAllUsersHandler).handle(request);
    }

    @Test
    void shouldThrowExceptionWhenNoHandlerFound() {

        when(getAllUsersHandler.getRequestType()).thenReturn(GetAllUsersRequest.class);
        mediator = new Mediator(List.of(getAllUsersHandler));

        GetUserRequest request = new GetUserRequest(1L);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> mediator.dispatch(request));
        assertTrue(exception.getMessage().contains("No handler found"));
    }
}