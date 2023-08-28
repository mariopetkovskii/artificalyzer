package com.artificalyzer.service.userroleservice.interfaces;

import com.artificalyzer.models.userroles.entity.User;
import com.artificalyzer.models.userroles.helpers.*;
import com.artificalyzer.records.UserResponseDto;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserService {
    User findByEmail(String email);

    User save(User user);

    Boolean passwordMatches(User user, String password);

    Optional<Map<String,String>> register(UserHelper userHelper);

    Optional<User> changePassword(ChangePasswordHelper changePasswordHelper);

    User enableAccount(User user);

    Optional<User> addRoleToUser(AddRoleToUserHelper addRoleToUserHelper);

    List<User> findAll();

    void deleteUser(DeleteUserHelper deleteUserHelper);

    Optional<User> getUserDetails(UserHelper userHelper);

    Optional<User> recoveryAccountChangePassword(AccountRecoveryChangePasswordHelper accountRecoveryChangePasswordHelper);

    void recoverAccount(AccountRecoveryHelper accountRecoveryHelper);

    void deleteUserByEmail(String email);

    Optional<User> editAccount(UserHelper userHelper);

    UserResponseDto getUserDetails();
}
