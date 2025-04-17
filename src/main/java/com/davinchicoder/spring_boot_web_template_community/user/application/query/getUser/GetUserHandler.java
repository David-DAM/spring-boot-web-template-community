package com.davinchicoder.spring_boot_web_template_community.user.application.query.getUser;

import com.davinchicoder.spring_boot_web_template_community.common.mediator.RequestHandler;
import com.davinchicoder.spring_boot_web_template_community.user.domain.entity.User;
import com.davinchicoder.spring_boot_web_template_community.user.domain.exception.UserNotFoundException;
import com.davinchicoder.spring_boot_web_template_community.user.domain.port.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetUserHandler implements RequestHandler<GetUserRequest, GetUserResponse> {

    private final UserRepository userRepository;

    @Override
    public GetUserResponse handle(GetUserRequest request) {

        User user = userRepository.findById(request.userId()).orElseThrow(() -> new UserNotFoundException("User not found"));

        return new GetUserResponse(user);
    }

    @Override
    public Class<GetUserRequest> getRequestType() {
        return GetUserRequest.class;
    }
}
