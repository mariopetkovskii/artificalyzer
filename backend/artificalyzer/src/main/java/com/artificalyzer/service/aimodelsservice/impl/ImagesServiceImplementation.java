package com.artificalyzer.service.aimodelsservice.impl;

import com.artificalyzer.models.aimodels.images.Images;
import com.artificalyzer.models.aimodels.images.ImagesHelper;
import com.artificalyzer.port.AiModelsApiCalls;
import com.artificalyzer.repository.aimodelsrepository.ImagesRepository;
import com.artificalyzer.service.aimodelsservice.interfaces.ImagesService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ImagesServiceImplementation implements ImagesService {
    private ImagesRepository imagesRepository;
    @Override
    public Optional<Images> addImagesModel(ImagesHelper imagesHelper) throws JsonProcessingException {
        Images images = new Images();
        images.setPrompt(imagesHelper.getPrompt());
        images.setNumberImages(imagesHelper.getN());
        images.setSize(imagesHelper.getSize());
        images.setUrl(AiModelsApiCalls.urlImages(imagesHelper.getPrompt(), images.getNumberImages(), imagesHelper.getSize()));
        return Optional.of(this.imagesRepository.save(images));
    }
}
