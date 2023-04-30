package com.artificalyzer.xcontrollers.aimodelscontrollers;

import com.artificalyzer.models.aimodels.moderations.Moderation;
import com.artificalyzer.models.aimodels.moderations.ModerationHelper;
import com.artificalyzer.service.aimodelsservice.interfaces.ModerationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/aimodels/moderations")
@CrossOrigin("http://localhost:3000/")
@AllArgsConstructor
public class ModerationController {
    private ModerationService moderationService;
    @PostMapping
    private ResponseEntity<Moderation> addModeration(@RequestBody ModerationHelper moderationHelper) throws JsonProcessingException {
        return this.moderationService.addModeration(moderationHelper)
                .map(moderation -> ResponseEntity.ok().body(moderation))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
