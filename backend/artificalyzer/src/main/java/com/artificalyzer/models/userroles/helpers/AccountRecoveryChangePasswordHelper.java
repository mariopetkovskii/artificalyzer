package com.artificalyzer.models.userroles.helpers;

import lombok.Getter;

@Getter
public class AccountRecoveryChangePasswordHelper {
    private String token;
    private String email;
    private String newPassword;
    private String confirmNewPassword;
}