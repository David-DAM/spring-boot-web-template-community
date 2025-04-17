package com.davinchicoder.spring_boot_web_template_community.user.application.query.getAllUsers;

import com.davinchicoder.spring_boot_web_template_community.user.domain.entity.User;

import java.util.List;

public record GetAllUsersResponse(List<User> users) {
}
