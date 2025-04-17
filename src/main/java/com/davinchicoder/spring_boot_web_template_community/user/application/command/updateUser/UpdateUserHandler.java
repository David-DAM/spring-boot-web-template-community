package com.davinchicoder.spring_boot_web_template_community.user.application.command.updateUser;

import com.davinchicoder.spring_boot_web_template_community.common.mediator.RequestHandler;
import com.davinchicoder.spring_boot_web_template_community.user.domain.entity.User;
import com.davinchicoder.spring_boot_web_template_community.user.domain.exception.UserNotFoundException;
import com.davinchicoder.spring_boot_web_template_community.user.domain.port.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateUserHandler implements RequestHandler<UpdateUserRequest, Void> {

    private final UserRepository userRepository;

    @Override
    public Void handle(UpdateUserRequest request) {

        User user = userRepository.findById(request.user().getId()).orElseThrow(() -> new UserNotFoundException("User not found"));

        user.setFirstname(request.user().getFirstname());
        user.setLastname(request.user().getLastname());

        userRepository.save(user);

        return null;
    }

    @Override
    public Class<UpdateUserRequest> getRequestType() {
        return UpdateUserRequest.class;
    }
}
