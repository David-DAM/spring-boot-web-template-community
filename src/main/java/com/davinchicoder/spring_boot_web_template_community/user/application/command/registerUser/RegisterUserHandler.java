package com.davinchicoder.spring_boot_web_template_community.user.application.command.registerUser;

import com.davinchicoder.spring_boot_web_template_community.common.mediator.RequestHandler;
import com.davinchicoder.spring_boot_web_template_community.user.domain.entity.Role;
import com.davinchicoder.spring_boot_web_template_community.user.domain.entity.User;
import com.davinchicoder.spring_boot_web_template_community.user.domain.port.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegisterUserHandler implements RequestHandler<RegisterUserRequest, Void> {

    private final UserRepository userRepository;

    @Override
    public Void handle(RegisterUserRequest request) {

        User user = request.user();

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Error the user exist");
        }

        user.setRole(Role.USER);

        userRepository.save(user);

        return null;
    }

    @Override
    public Class<RegisterUserRequest> getRequestType() {
        return RegisterUserRequest.class;
    }
}
