package com.artificalyzer.service.userroleservice.interfaces;

import com.artificalyzer.models.userroles.entity.Token;

public interface TokenService {
    Token create (Token token);
    Token findByToken (String token);
    void deleteByToken(String token);
}