package com.artificalyzer.repository.aimodelsrepository;

import com.artificalyzer.models.aimodels.sentiment_analysis.SentimentAnalysis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SentimentAnalysisRepository extends JpaRepository<SentimentAnalysis, Long> {
}
