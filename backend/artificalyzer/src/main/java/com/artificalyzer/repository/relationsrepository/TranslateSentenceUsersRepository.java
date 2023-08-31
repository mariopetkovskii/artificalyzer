package com.artificalyzer.repository.relationsrepository;

import com.artificalyzer.models.aimodels.relations.SentimentAnalysisUsers;
import com.artificalyzer.models.aimodels.relations.TranslateSentenceUsers;
import com.artificalyzer.models.userroles.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TranslateSentenceUsersRepository extends JpaRepository<TranslateSentenceUsers, Long> {
    Page<TranslateSentenceUsers> findAllByUser(Pageable pageable, User user);
}

