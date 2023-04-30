package com.artificalyzer.service.relationsservice.impl;

import com.artificalyzer.helperfunction.HelperFunction;
import com.artificalyzer.models.aimodels.relations.ImagesUser;
import com.artificalyzer.models.userroles.entity.User;
import com.artificalyzer.repository.relationsrepository.ImagesUserRepository;
import com.artificalyzer.repository.userrolerepository.UserRepository;
import com.artificalyzer.service.relationsservice.interfaces.ImagesUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ImagesUserServiceImplementation implements ImagesUserService {
    private final ImagesUserRepository imagesUserRepository;
    private final UserRepository userRepository;
    @Override
    public List<ImagesUser> findAllByUser(String authHeader) {
        String email = HelperFunction.decodeJwtToGetEmail(authHeader);
        User user = this.userRepository.findByEmail(email);
        return this.imagesUserRepository.findAllByUser(user);
    }
}
