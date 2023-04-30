package com.artificalyzer.service.relationsservice.interfaces;

import com.artificalyzer.models.aimodels.relations.ModerationUser;

import java.util.List;

public interface ModerationUserService {
    List<ModerationUser> findAllByUser(String authHeader);
}
