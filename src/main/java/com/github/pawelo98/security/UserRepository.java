package com.github.pawelo98.security;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{

    User findUserByEmail(String email);
    boolean existsByEmail(String email);
}
