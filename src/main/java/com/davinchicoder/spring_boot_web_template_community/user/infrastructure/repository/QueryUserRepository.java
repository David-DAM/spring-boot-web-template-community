package com.davinchicoder.spring_boot_web_template_community.user.infrastructure.repository;


import com.davinchicoder.spring_boot_web_template_community.user.infrastructure.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QueryUserRepository extends JpaRepository<UserEntity, Long> {

    Boolean existsByEmail(String email);

    Optional<UserEntity> findByEmail(String email);
}
