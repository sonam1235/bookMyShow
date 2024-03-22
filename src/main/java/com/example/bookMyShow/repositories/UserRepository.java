package com.example.bookMyShow.repositories;

import com.example.bookMyShow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    @Override
    Optional<User> findById(Long aLong);
    Optional<User> findByEmail(String username);
    @Override
    User save(User entity);
}
