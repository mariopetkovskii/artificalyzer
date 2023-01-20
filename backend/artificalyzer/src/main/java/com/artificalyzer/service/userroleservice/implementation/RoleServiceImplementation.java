package com.artificalyzer.service.userroleservice.implementation;

import com.artificalyzer.models.userroles.entity.Role;
import com.artificalyzer.models.userroles.exceptions.RoleAlreadyExistsException;
import com.artificalyzer.models.userroles.exceptions.RoleNotFoundException;
import com.artificalyzer.models.userroles.helpers.RoleHelper;
import com.artificalyzer.repository.userrolerepository.RoleRepository;
import com.artificalyzer.service.userroleservice.interfaces.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RoleServiceImplementation implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public Optional<Role> addRole(RoleHelper roleHelper) {
        String PREFIX_ROLE = "ROLE_";
        String roleName = PREFIX_ROLE + roleHelper.getName();
        if(this.roleRepository.findByName(roleName) != null){
            throw new RoleAlreadyExistsException();
        }
        Role role = new Role();
        role.setName(roleName);
        return Optional.of(this.roleRepository.save(role));
    }

    @Override
    public Role findById(Long id){
        return this.roleRepository.findById(id).orElseThrow(() -> new RoleNotFoundException(id));
    }

    @Override
    public List<Role> findAll() {
        return this.roleRepository.findAll();
    }

    @Override
    public Optional<Role> editRole(Long id, RoleHelper roleHelper) {
        Role role = this.roleRepository.findById(id).orElseThrow(() -> new RoleNotFoundException(id));
        role.setName(roleHelper.getName());
        return Optional.of(this.roleRepository.save(role));
    }

    @Override
    public void deleteRole(RoleHelper roleHelper) {
        Role role = this.roleRepository.findByName(roleHelper.getName());
        this.roleRepository.deleteById(role.getId());
    }

    @Override
    public Role findByName(String name) {
        return this.roleRepository.findByName(name);
    }


}