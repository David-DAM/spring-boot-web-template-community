package com.davinchicoder.spring_boot_web_template_community.user.application.command.updateUser;

import com.davinchicoder.spring_boot_web_template_community.common.mediator.Request;
import com.davinchicoder.spring_boot_web_template_community.user.domain.entity.User;

public record UpdateUserRequest(User user) implements Request<Void> {
}
