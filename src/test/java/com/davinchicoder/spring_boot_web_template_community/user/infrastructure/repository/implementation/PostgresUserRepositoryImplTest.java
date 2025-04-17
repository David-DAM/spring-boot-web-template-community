package com.davinchicoder.spring_boot_web_template_community.user.infrastructure.repository.implementation;

import com.davinchicoder.spring_boot_web_template_community.user.domain.entity.User;
import com.davinchicoder.spring_boot_web_template_community.user.infrastructure.entity.UserEntity;
import com.davinchicoder.spring_boot_web_template_community.user.infrastructure.mapper.UserMapper;
import com.davinchicoder.spring_boot_web_template_community.user.infrastructure.repository.QueryUserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PostgresUserRepositoryImplTest {

    @Mock
    private QueryUserRepository queryUserRepository;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private PostgresUserRepositoryImpl postgresUserRepository;

    private final UserEntity userEntity = UserEntity.builder().id(1L).build();
    private final User user = User.builder().id(1L).build();

    @Test
    void save() {
        when(userMapper.userToUserEntity(any(User.class))).thenReturn(userEntity);
        when(userMapper.userEntityToUser(any(UserEntity.class))).thenReturn(user);
        when(queryUserRepository.save(userEntity)).thenReturn(userEntity);

        postgresUserRepository.save(user);

        verify(queryUserRepository).save(any(UserEntity.class));
    }

    @Test
    void findById() {
        when(userMapper.userEntityToUser(any(UserEntity.class))).thenReturn(user);
        when(queryUserRepository.findById(1L)).thenReturn(Optional.of(userEntity));

        Optional<User> optionalUser = postgresUserRepository.findById(1L);

        assertTrue(optionalUser.isPresent());
    }

    @Test
    void findAll() {
        when(userMapper.userEntityToUser(any(UserEntity.class))).thenReturn(user);
        when(queryUserRepository.findAll()).thenReturn(List.of(userEntity));

        List<User> users = postgresUserRepository.findAll();
        assertFalse(users.isEmpty());
    }

    @Test
    void findByEmail() {
        when(userMapper.userEntityToUser(any(UserEntity.class))).thenReturn(user);
        when(queryUserRepository.findByEmail(anyString())).thenReturn(Optional.of(userEntity));

        Optional<User> user = postgresUserRepository.findByEmail("test@gmail.com");
        assertTrue(user.isPresent());
    }

    @Test
    void existsByEmail() {
        when(queryUserRepository.existsByEmail(anyString())).thenReturn(true);

        Boolean existsByEmail = postgresUserRepository.existsByEmail("test@gmail.com");
        assertTrue(existsByEmail);
    }

    @Test
    void deleteById() {

        postgresUserRepository.deleteById(1L);
        verify(queryUserRepository).deleteById(1L);
    }
}