package com.artificalyzer.models.aimodels.relations;

import com.artificalyzer.models.aimodels.edits.Edits;
import com.artificalyzer.models.userroles.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "ai_editsmodel_users", schema = "aimodels")
public class EditsUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ur_user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ai_edits_id")
    private Edits edits;

    public EditsUser(User user, Edits edits) {
        this.user = user;
        this.edits = edits;
    }
}
