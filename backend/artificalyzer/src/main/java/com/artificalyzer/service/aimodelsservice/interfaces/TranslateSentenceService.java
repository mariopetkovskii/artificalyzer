package com.artificalyzer.service.aimodelsservice.interfaces;

import com.artificalyzer.models.aimodels.translate_sentence.TranslateSentence;
import com.artificalyzer.models.aimodels.translate_sentence.TranslateSentenceHelper;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Optional;

public interface TranslateSentenceService {
    Optional<TranslateSentence> saveTranslateSentenceModel(TranslateSentenceHelper translateSentenceHelper, String authHeader) throws JsonProcessingException;

}
