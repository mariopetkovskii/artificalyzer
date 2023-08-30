package com.artificalyzer.service.relationsservice.interfaces;

import com.artificalyzer.models.aimodels.relations.ModerationUser;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ModerationUserService {
    Page<ModerationUser> findAllByUser(String authHeader, Integer pageNo, Integer pageSize, String sortBy);
}
