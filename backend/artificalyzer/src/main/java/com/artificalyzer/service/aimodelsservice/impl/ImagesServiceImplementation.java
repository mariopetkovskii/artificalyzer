package com.artificalyzer.service.aimodelsservice.impl;

import com.artificalyzer.helperfunction.HelperFunction;
import com.artificalyzer.models.aimodels.images.Images;
import com.artificalyzer.models.aimodels.images.ImagesHelper;
import com.artificalyzer.models.aimodels.relations.EditsUser;
import com.artificalyzer.models.aimodels.relations.ImagesUser;
import com.artificalyzer.models.userroles.entity.User;
import com.artificalyzer.port.AiModelsApiCalls;
import com.artificalyzer.repository.aimodelsrepository.ImagesRepository;
import com.artificalyzer.repository.relationsrepository.ImagesUserRepository;
import com.artificalyzer.repository.userrolerepository.UserRepository;
import com.artificalyzer.service.aimodelsservice.interfaces.ImagesService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ImagesServiceImplementation implements ImagesService {
    private ImagesRepository imagesRepository;
    private UserRepository userRepository;
    private ImagesUserRepository imagesUserRepository;
    @Override
    public Optional<Images> addImagesModel(ImagesHelper imagesHelper, String authHeader) throws JsonProcessingException {
        Images images = new Images();
        images.setPrompt(imagesHelper.getPrompt());
        images.setNumberImages(1);
        images.setSize(imagesHelper.getSize());
        images.setUrl(AiModelsApiCalls.urlImages(imagesHelper.getPrompt(), 1, imagesHelper.getSize()));
        String email = HelperFunction.decodeJwtToGetEmail(authHeader);
        User user = this.userRepository.findByEmail(email);
        this.imagesUserRepository.save(new ImagesUser(user, images));
        return Optional.of(this.imagesRepository.save(images));
    }
}
