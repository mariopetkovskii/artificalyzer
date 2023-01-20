package com.artificalyzer.service.userroleservice.implementation;

import com.artificalyzer.models.userroles.entity.Token;
import com.artificalyzer.repository.userrolerepository.TokenRepository;
import com.artificalyzer.service.userroleservice.interfaces.TokenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TokenServiceImplementation implements TokenService {

    private final TokenRepository tokenRepository;

    @Override
    public Token create(Token token) {
        return tokenRepository.save(token);
    }

    @Override
    public Token findByToken(String token) {
        return this.tokenRepository.findByToken(token);
    }

    @Override
    public void deleteByToken(String token) {
        this.tokenRepository.deleteByToken(token);
    }
}