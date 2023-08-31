package com.artificalyzer.service.aimodelsservice.interfaces;

import com.artificalyzer.models.aimodels.sentiment_analysis.SentmentAnalysisHelper;
import com.artificalyzer.models.aimodels.sentiment_analysis.SentimentAnalysis;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Optional;

public interface SentimentAnalysisService {
    Optional<SentimentAnalysis> saveSentimentAnalysisModel(SentmentAnalysisHelper sentmentAnalysisHelper, String authHeader) throws JsonProcessingException;
}
