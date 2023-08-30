package com.artificalyzer.repository.relationsrepository;

import com.artificalyzer.models.aimodels.relations.ImagesUser;
import com.artificalyzer.models.userroles.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImagesUserRepository extends JpaRepository<ImagesUser, Long> {
    Page<ImagesUser> findAllByUser(Pageable pageable, User user);
}
