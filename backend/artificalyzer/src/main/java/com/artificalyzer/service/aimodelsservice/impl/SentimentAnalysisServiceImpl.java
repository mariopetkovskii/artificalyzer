package com.artificalyzer.service.aimodelsservice.impl;

import com.artificalyzer.helperfunction.HelperFunction;
import com.artificalyzer.models.aimodels.images.Images;
import com.artificalyzer.models.aimodels.relations.ImagesUser;
import com.artificalyzer.models.aimodels.relations.SentimentAnalysisUsers;
import com.artificalyzer.models.aimodels.sentiment_analysis.SentmentAnalysisHelper;
import com.artificalyzer.models.aimodels.sentiment_analysis.SentimentAnalysis;
import com.artificalyzer.models.userroles.entity.User;
import com.artificalyzer.port.AiModelsApiCalls;
import com.artificalyzer.repository.aimodelsrepository.SentimentAnalysisRepository;
import com.artificalyzer.repository.relationsrepository.SentimentAnalysisUsersRepository;
import com.artificalyzer.repository.userrolerepository.UserRepository;
import com.artificalyzer.service.aimodelsservice.interfaces.SentimentAnalysisService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class SentimentAnalysisServiceImpl implements SentimentAnalysisService {
    private final UserRepository userRepository;
    private final SentimentAnalysisUsersRepository sentimentAnalysisUsersRepository;
    private final SentimentAnalysisRepository sentimentAnalysisRepository;
    @Override
    public Optional<SentimentAnalysis> saveSentimentAnalysisModel(SentmentAnalysisHelper sentimentHelper, String authHeader) throws JsonProcessingException {
        SentimentAnalysis sentimentAnalysis = new SentimentAnalysis();
        sentimentAnalysis.setInput_sentance(sentimentHelper.getInput_sentance());
        sentimentAnalysis.setPolarity(sentimentHelper.getPolarity());
        String email = HelperFunction.decodeJwtToGetEmail(authHeader);
        User user = this.userRepository.findByEmail(email);
        this.sentimentAnalysisUsersRepository.save(new SentimentAnalysisUsers(user, sentimentAnalysis));
        return Optional.of(this.sentimentAnalysisRepository.save(sentimentAnalysis));    }
}
