package com.davinchicoder.spring_boot_web_template_community.user.application.command.deleteUser;

import com.davinchicoder.spring_boot_web_template_community.common.mediator.RequestHandler;
import com.davinchicoder.spring_boot_web_template_community.user.domain.port.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteUserHandler implements RequestHandler<DeleteUserRequest, Void> {

    private final UserRepository userRepository;

    @Override
    public Void handle(DeleteUserRequest request) {

        userRepository.deleteById(request.userId());

        return null;
    }

    @Override
    public Class<DeleteUserRequest> getRequestType() {
        return DeleteUserRequest.class;
    }
}
