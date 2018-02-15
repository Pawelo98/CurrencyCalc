package com.github.pawelo98.emailverification;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface VerificationRepository extends JpaRepository<VerificationToken, Long> {
    Optional<VerificationToken> findOneByToken(String token);
    Set<VerificationToken> findAllByUserIsEnabledFalse();
}
