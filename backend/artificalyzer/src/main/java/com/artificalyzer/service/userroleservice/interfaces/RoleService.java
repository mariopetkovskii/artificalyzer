package com.artificalyzer.service.userroleservice.interfaces;

import com.artificalyzer.models.userroles.entity.Role;
import com.artificalyzer.models.userroles.helpers.RoleHelper;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    Optional<Role> addRole (RoleHelper roleHelper);

    Role findById (Long id);

    List<Role> findAll();

    Optional<Role> editRole(Long id, RoleHelper roleHelper);

    void deleteRole(RoleHelper roleHelper);

    Role findByName(String name);
}
