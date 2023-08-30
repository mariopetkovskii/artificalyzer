package com.artificalyzer.service.relationsservice.interfaces;

import com.artificalyzer.models.aimodels.relations.ImagesUser;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ImagesUserService {
    Page<ImagesUser> findAllByUser(String authHeader, Integer pageNo, Integer pageSize, String sortBy);
}
