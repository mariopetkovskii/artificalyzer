package com.artificalyzer.xcontrollers.aimodelscontrollers;

import com.artificalyzer.models.aimodels.images.Images;
import com.artificalyzer.models.aimodels.images.ImagesHelper;
import com.artificalyzer.service.aimodelsservice.interfaces.ImagesService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/aimodels/images")
@CrossOrigin("http://localhost:3000/")
@AllArgsConstructor
public class ImagesController {

    private final ImagesService imagesService;

    @PostMapping("/generate")
    public ResponseEntity<Images> generateImage(@RequestBody ImagesHelper imagesHelper,
                                                @RequestHeader("Authorization") String authorizationHeader) throws JsonProcessingException {
        return this.imagesService.addImagesModel(imagesHelper, authorizationHeader)
                .map(images -> ResponseEntity.ok().body(images))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
