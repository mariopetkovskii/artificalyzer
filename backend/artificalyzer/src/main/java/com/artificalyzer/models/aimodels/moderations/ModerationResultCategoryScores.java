package com.artificalyzer.models.aimodels.moderations;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ModerationResultCategoryScores {
    private Double hate;
    @JsonProperty("hate/threatening")
    private Double hateAndThreatening;
    @JsonProperty("self-harm")
    private Double selfHarm;
    private Double sexual;
    @JsonProperty("sexual/minors")
    private Double sexualMinors;
    private Double violence;
    @JsonProperty("violence/graphic")
    private Double violenceGraphic;
}
