package com.artificalyzer.models.aimodels.moderations;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ModerationResultCategories {
    private Boolean hate;
    @JsonProperty("hate/threatening")
    private Boolean hateAndThreatening;
    @JsonProperty("self-harm")
    private Boolean selfHarm;
    private Boolean sexual;
    @JsonProperty("sexual/minors")
    private Boolean sexualMinors;
    private Boolean violence;
    @JsonProperty("violence/graphic")
    private Boolean violenceGraphic;
}
