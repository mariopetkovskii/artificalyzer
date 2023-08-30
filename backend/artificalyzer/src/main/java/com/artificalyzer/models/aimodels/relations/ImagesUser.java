package com.artificalyzer.models.aimodels.relations;

import com.artificalyzer.models.aimodels.edits.Edits;
import com.artificalyzer.models.aimodels.images.Images;
import com.artificalyzer.models.userroles.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "ai_imagesmodel_users", schema = "aimodels")
public class ImagesUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ur_user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ai_images_id")
    private Images images;

    public ImagesUser(User user, Images images) {
        this.user = user;
        this.images = images;
    }
}