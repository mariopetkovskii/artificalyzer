package com.artificalyzer.repository.relationsrepository;

import com.artificalyzer.models.aimodels.relations.ImagesUser;
import com.artificalyzer.models.userroles.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImagesUserRepository extends JpaRepository<ImagesUser, Long> {
    List<ImagesUser> findAllByUser(User user);
}
