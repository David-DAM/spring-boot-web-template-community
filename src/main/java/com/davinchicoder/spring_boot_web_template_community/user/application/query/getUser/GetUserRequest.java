package com.davinchicoder.spring_boot_web_template_community.user.application.query.getUser;

import com.davinchicoder.spring_boot_web_template_community.common.mediator.Request;

public record GetUserRequest(Long userId) implements Request<GetUserResponse> {
}
