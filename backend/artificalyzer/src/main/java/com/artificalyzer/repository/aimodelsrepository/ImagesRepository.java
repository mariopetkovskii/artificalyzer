package com.artificalyzer.repository.aimodelsrepository;

import com.artificalyzer.models.aimodels.images.Images;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagesRepository extends JpaRepository<Images, Long> {
}
