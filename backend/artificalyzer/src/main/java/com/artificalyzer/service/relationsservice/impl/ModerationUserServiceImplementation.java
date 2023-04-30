package com.artificalyzer.service.relationsservice.impl;

import com.artificalyzer.helperfunction.HelperFunction;
import com.artificalyzer.models.aimodels.relations.ModerationUser;
import com.artificalyzer.models.userroles.entity.User;
import com.artificalyzer.repository.relationsrepository.ModerationUserRepository;
import com.artificalyzer.repository.userrolerepository.UserRepository;
import com.artificalyzer.service.relationsservice.interfaces.ModerationUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ModerationUserServiceImplementation implements ModerationUserService {
    private final ModerationUserRepository moderationUserRepository;
    private final UserRepository userRepository;
    @Override
    public List<ModerationUser> findAllByUser(String authHeader) {
        String email = HelperFunction.decodeJwtToGetEmail(authHeader);
        User user = this.userRepository.findByEmail(email);
        return this.moderationUserRepository.findAllByUser(user);
    }
}
