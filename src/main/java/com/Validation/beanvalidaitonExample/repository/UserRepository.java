package com.Validation.beanvalidaitonExample.repository;

import com.Validation.beanvalidaitonExample.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByuserId(int userId);
}
