package com.artificalyzer.service.aimodelsservice.impl;

import com.artificalyzer.helperfunction.HelperFunction;
import com.artificalyzer.models.aimodels.moderations.Moderation;
import com.artificalyzer.models.aimodels.moderations.ModerationDto;
import com.artificalyzer.models.aimodels.moderations.ModerationHelper;
import com.artificalyzer.models.aimodels.relations.ImagesUser;
import com.artificalyzer.models.aimodels.relations.ModerationUser;
import com.artificalyzer.models.userroles.entity.User;
import com.artificalyzer.port.AiModelsApiCalls;
import com.artificalyzer.repository.aimodelsrepository.ModerationRepository;
import com.artificalyzer.repository.relationsrepository.ModerationUserRepository;
import com.artificalyzer.repository.userrolerepository.UserRepository;
import com.artificalyzer.service.aimodelsservice.interfaces.ModerationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ModerationServiceImplementation implements ModerationService {
    private final ModerationRepository moderationRepository;
    private final UserRepository userRepository;
    private final ModerationUserRepository moderationUserRepository;
    @Override
    public Optional<Moderation> addModeration(ModerationHelper moderationHelper, String authHeader) throws JsonProcessingException {
        Moderation moderation = new Moderation();
        moderation.setInputText(moderationHelper.getInput());

        ModerationDto moderationDto = AiModelsApiCalls.outputModerationModel(moderationHelper.getInput());

        moderation.setHate(moderationDto.getResults().get(0).getCategories().getHate());
        moderation.setHateAndThreatening(moderationDto.getResults().get(0).getCategories().getHateAndThreatening());
        moderation.setSelfHarm(moderationDto.getResults().get(0).getCategories().getSelfHarm());
        moderation.setSexual(moderationDto.getResults().get(0).getCategories().getSexual());
        moderation.setSexualMinors(moderationDto.getResults().get(0).getCategories().getSexualMinors());
        moderation.setViolence(moderationDto.getResults().get(0).getCategories().getViolence());
        moderation.setViolenceGraphic(moderationDto.getResults().get(0).getCategories().getViolenceGraphic());

        moderation.setHateScore(moderationDto.getResults().get(0).getCategoryScores().getHate());
        moderation.setHateAndThreateningScore(moderationDto.getResults().get(0).getCategoryScores().getHateAndThreatening());
        moderation.setSelfHarmScore(moderationDto.getResults().get(0).getCategoryScores().getSelfHarm());
        moderation.setSexualScore(moderationDto.getResults().get(0).getCategoryScores().getSexual());
        moderation.setSexualMinorsScore(moderationDto.getResults().get(0).getCategoryScores().getSexualMinors());
        moderation.setViolenceScore(moderationDto.getResults().get(0).getCategoryScores().getViolence());
        moderation.setViolenceGraphicScore(moderationDto.getResults().get(0).getCategoryScores().getViolenceGraphic());

        String email = HelperFunction.decodeJwtToGetEmail(authHeader);
        User user = this.userRepository.findByEmail(email);
        this.moderationUserRepository.save(new ModerationUser(user, moderation));

        return Optional.of(this.moderationRepository.save(moderation));
    }
}
