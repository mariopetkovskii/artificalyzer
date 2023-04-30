package com.artificalyzer.models.aimodels.relations;

import com.artificalyzer.models.aimodels.images.Images;
import com.artificalyzer.models.aimodels.moderations.Moderation;
import com.artificalyzer.models.userroles.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "ai_moderationsmodel_users", schema = "aimodels")
public class ModerationUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ur_user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ai_moderations_id")
    private Moderation moderation;

    public ModerationUser(User user, Moderation moderation) {
        this.user = user;
        this.moderation = moderation;
    }
}
