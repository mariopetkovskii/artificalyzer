package com.artificalyzer.service.relationsservice.interfaces;

import com.artificalyzer.models.aimodels.edits.Edits;
import com.artificalyzer.models.aimodels.relations.EditsUser;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EditsUserService {
    Page<EditsUser> findAllByUser(String authHeader, Integer pageNo, Integer pageSize, String sortBy);
}
