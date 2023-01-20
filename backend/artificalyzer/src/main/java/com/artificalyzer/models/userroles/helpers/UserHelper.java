package com.artificalyzer.models.userroles.helpers;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserHelper {
    String firstName;
    String lastName;
    String email;
    String password;
    String confirmPassword;
}