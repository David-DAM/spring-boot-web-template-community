package com.davinchicoder.spring_boot_web_template_community.user.infrastructure.repository.implementation;


import com.davinchicoder.spring_boot_web_template_community.user.domain.entity.User;
import com.davinchicoder.spring_boot_web_template_community.user.domain.port.UserRepository;
import com.davinchicoder.spring_boot_web_template_community.user.infrastructure.entity.UserEntity;
import com.davinchicoder.spring_boot_web_template_community.user.infrastructure.mapper.UserMapper;
import com.davinchicoder.spring_boot_web_template_community.user.infrastructure.repository.QueryUserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Primary
public class PostgresUserRepositoryImpl implements UserRepository {

    private final QueryUserRepository queryUserRepository;
    private final UserMapper userMapper;

    @Override
    public User save(User userEntity) {
        UserEntity entity = userMapper.userToUserEntity(userEntity);
        UserEntity saved = queryUserRepository.save(entity);
        return userMapper.userEntityToUser(saved);
    }

    @Override
    public Optional<User> findById(Long id) {
        return queryUserRepository.findById(id).map(userMapper::userEntityToUser);
    }

    @Override
    public List<User> findAll() {
        return queryUserRepository.findAll().stream().map(userMapper::userEntityToUser).toList();
    }

    @Transactional
    @Override
    public Optional<User> findByEmail(String email) {
        return queryUserRepository.findByEmail(email).map(userMapper::userEntityToUser);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return queryUserRepository.existsByEmail(email);
    }

    @Override
    public void deleteById(Long id) {
        queryUserRepository.deleteById(id);
    }

}
