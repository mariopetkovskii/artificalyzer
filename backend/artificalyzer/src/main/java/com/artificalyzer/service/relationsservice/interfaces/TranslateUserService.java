package com.artificalyzer.service.relationsservice.interfaces;

import com.artificalyzer.models.aimodels.relations.SentimentAnalysisUsers;
import com.artificalyzer.models.aimodels.relations.TranslateSentenceUsers;
import org.springframework.data.domain.Page;

public interface TranslateUserService {
    Page<TranslateSentenceUsers> findAllbyUser(String authHeader, Integer pageNo, Integer pageSize,  String sortBy);
}
