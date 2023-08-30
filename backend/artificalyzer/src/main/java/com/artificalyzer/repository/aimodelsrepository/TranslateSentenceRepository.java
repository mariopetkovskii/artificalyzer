package com.artificalyzer.repository.aimodelsrepository;

import com.artificalyzer.models.aimodels.translate_sentence.TranslateSentence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TranslateSentenceRepository extends JpaRepository<TranslateSentence, Long> {
}
