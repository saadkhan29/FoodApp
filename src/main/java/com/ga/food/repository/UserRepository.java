package com.ga.food.repository;

import com.ga.food.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // For Registration
    boolean existsByEmailAddress(String emailAddress);

    // For Login
    User findUserByEmailAddress(String emailAddress);
}
