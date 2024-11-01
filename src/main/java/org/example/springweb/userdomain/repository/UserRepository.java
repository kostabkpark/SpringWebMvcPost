package org.example.springweb.userdomain.repository;

import org.example.springweb.userdomain.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserId(String userId);
    void deleteByUserId(String userId);
}
