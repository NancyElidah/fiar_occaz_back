package com.pack.fiaraoccaz.repository;

import com.pack.fiaraoccaz.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;  

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmailAndPassword(String email, String password);
    Optional<User> findById(Long id);
}
