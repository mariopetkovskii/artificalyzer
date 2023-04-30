package com.artificalyzer.repository.aimodelsrepository;

import com.artificalyzer.models.aimodels.moderations.Moderation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModerationRepository extends JpaRepository<Moderation, Long> {
}
