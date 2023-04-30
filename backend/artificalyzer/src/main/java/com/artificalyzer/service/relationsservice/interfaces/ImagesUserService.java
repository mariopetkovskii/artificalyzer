package com.artificalyzer.service.relationsservice.interfaces;

import com.artificalyzer.models.aimodels.relations.ImagesUser;

import java.util.List;

public interface ImagesUserService {
    List<ImagesUser> findAllByUser(String authHeader);
}
