package com.artificalyzer.models.aimodels.moderations;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ModerationResult {
    private ModerationResultCategories categories;
    @JsonProperty("category_scores")
    private ModerationResultCategoryScores categoryScores;
}
