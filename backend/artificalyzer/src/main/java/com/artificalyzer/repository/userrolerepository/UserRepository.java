package com.artificalyzer.repository.userrolerepository;

import com.artificalyzer.models.userroles.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u where u.email=:email")
    User findByEmail(String email);
}