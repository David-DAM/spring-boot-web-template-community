package com.davinchicoder.spring_boot_web_template_community.user.application.command.deleteUser;

import com.davinchicoder.spring_boot_web_template_community.common.mediator.Request;

public record DeleteUserRequest(Long userId) implements Request<Void> {
}
