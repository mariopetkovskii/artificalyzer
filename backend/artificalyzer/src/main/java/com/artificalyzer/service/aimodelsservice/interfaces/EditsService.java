package com.artificalyzer.service.aimodelsservice.interfaces;

import com.artificalyzer.models.aimodels.edits.Edits;
import com.artificalyzer.models.aimodels.edits.EditsHelper;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Optional;

public interface EditsService {
    Optional<Edits> addEditsModel(EditsHelper editsHelper) throws JsonProcessingException;
}
