package com.artificalyzer.repository.relationsrepository;

import com.artificalyzer.models.aimodels.relations.ModerationUser;
import com.artificalyzer.models.userroles.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModerationUserRepository extends JpaRepository<ModerationUser, Long> {
    List<ModerationUser> findAllByUser(User user);
}
