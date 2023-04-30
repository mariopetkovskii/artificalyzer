package com.artificalyzer.service.aimodelsservice.interfaces;

import com.artificalyzer.models.aimodels.images.Images;
import com.artificalyzer.models.aimodels.images.ImagesHelper;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Optional;

public interface ImagesService {
    Optional<Images> addImagesModel(ImagesHelper imagesHelper, String authHeader) throws JsonProcessingException;
}
