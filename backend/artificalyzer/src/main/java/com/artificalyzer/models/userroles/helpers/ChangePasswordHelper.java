package com.artificalyzer.models.userroles.helpers;

import lombok.Getter;

@Getter
public class ChangePasswordHelper {
    private String email;
    private String oldPassword;
    private String newPassword;
    private String confirmNewPassword;
}