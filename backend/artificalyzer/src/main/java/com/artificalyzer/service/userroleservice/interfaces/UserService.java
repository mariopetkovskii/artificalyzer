package com.artificalyzer.service.userroleservice.interfaces;

import com.artificalyzer.models.userroles.entity.User;
import com.artificalyzer.models.userroles.helpers.*;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User findByEmail(String email);

    User save(User user);

    Boolean passwordMatches(User user, String password);

    Optional<User> register(UserHelper userHelper);

    Optional<User> changePassword(ChangePasswordHelper changePasswordHelper);

    User enableAccount(User user);

    Optional<User> addRoleToUser(AddRoleToUserHelper addRoleToUserHelper);

    List<User> findAll();

    void deleteUser(DeleteUserHelper deleteUserHelper);

    Optional<User> getUserDetails(UserHelper userHelper);

    Optional<User> recoveryAccountChangePassword(AccountRecoveryChangePasswordHelper accountRecoveryChangePasswordHelper);

    Optional<Boolean> recoverAccount(AccountRecoveryHelper accountRecoveryHelper);

    void deleteUserByEmail(String email);

    Optional<User> editAccount(UserHelper userHelper);
}