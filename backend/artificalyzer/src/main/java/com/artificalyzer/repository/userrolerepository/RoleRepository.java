package com.artificalyzer.repository.userrolerepository;

import com.artificalyzer.models.userroles.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}