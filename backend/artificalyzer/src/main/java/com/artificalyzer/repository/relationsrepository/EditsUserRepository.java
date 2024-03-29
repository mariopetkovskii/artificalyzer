package com.artificalyzer.repository.relationsrepository;

import com.artificalyzer.models.aimodels.edits.Edits;
import com.artificalyzer.models.aimodels.relations.EditsUser;
import com.artificalyzer.models.userroles.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EditsUserRepository extends JpaRepository<EditsUser, Long> {
    Page<EditsUser> findAllByUser(Pageable pageable, User user);
}
