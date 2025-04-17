package com.davinchicoder.spring_boot_web_template_community.user.application.query.getAllUsers;

import com.davinchicoder.spring_boot_web_template_community.common.mediator.RequestHandler;
import com.davinchicoder.spring_boot_web_template_community.user.domain.entity.User;
import com.davinchicoder.spring_boot_web_template_community.user.domain.port.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetAllUsersHandler implements RequestHandler<GetAllUsersRequest, GetAllUsersResponse> {

    private final UserRepository userRepository;

    @Override
    public GetAllUsersResponse handle(GetAllUsersRequest request) {

        List<User> users = userRepository.findAll();

        return new GetAllUsersResponse(users);
    }

    @Override
    public Class<GetAllUsersRequest> getRequestType() {
        return GetAllUsersRequest.class;
    }
}
