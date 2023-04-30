package com.artificalyzer.service.relationsservice.interfaces;

import com.artificalyzer.models.aimodels.edits.Edits;
import com.artificalyzer.models.aimodels.relations.EditsUser;

import java.util.List;

public interface EditsUserService {
    List<EditsUser> findAllByUser(String authHeader);
}
