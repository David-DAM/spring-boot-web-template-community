package com.davinchicoder.spring_boot_web_template_community.user.infrastructure.mapper;


import com.davinchicoder.spring_boot_web_template_community.user.domain.entity.User;
import com.davinchicoder.spring_boot_web_template_community.user.infrastructure.api.dto.RegisterUserDTO;
import com.davinchicoder.spring_boot_web_template_community.user.infrastructure.api.dto.UserDTO;
import com.davinchicoder.spring_boot_web_template_community.user.infrastructure.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.WARN)
public interface UserMapper {

    User userEntityToUser(UserEntity userEntity);

    UserEntity userToUserEntity(User user);

    UserDTO userToUserDTO(User user);

    User userDTOToUser(UserDTO userDTO);

    User registerUserDTOToUser(RegisterUserDTO registerUserDTO);
}
