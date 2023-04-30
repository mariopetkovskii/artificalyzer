package com.artificalyzer.models.aimodels.moderations;

import lombok.Getter;

import java.util.List;

@Getter
public class ModerationDto {
    List<ModerationResult> results;
}
