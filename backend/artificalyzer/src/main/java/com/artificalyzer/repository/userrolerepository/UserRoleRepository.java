package com.artificalyzer.repository.userrolerepository;

import com.artificalyzer.models.userroles.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}
