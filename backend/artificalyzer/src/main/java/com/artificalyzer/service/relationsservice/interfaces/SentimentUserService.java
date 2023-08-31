package com.artificalyzer.service.relationsservice.interfaces;

import com.artificalyzer.models.aimodels.relations.SentimentAnalysisUsers;
import org.springframework.data.domain.Page;

public interface SentimentUserService {
    Page<SentimentAnalysisUsers> findAllbyUser(String authHeader, Integer pageNo, Integer pageSize,  String sortBy);
}
