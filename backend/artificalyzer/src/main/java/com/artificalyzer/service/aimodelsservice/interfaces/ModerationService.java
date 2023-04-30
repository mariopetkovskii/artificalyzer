package com.artificalyzer.service.aimodelsservice.interfaces;

import com.artificalyzer.models.aimodels.moderations.Moderation;
import com.artificalyzer.models.aimodels.moderations.ModerationHelper;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Optional;

public interface ModerationService {
    Optional<Moderation> addModeration(ModerationHelper moderationHelper) throws JsonProcessingException;
}
