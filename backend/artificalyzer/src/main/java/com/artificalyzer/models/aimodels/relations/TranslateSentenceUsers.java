package com.artificalyzer.models.aimodels.relations;

import com.artificalyzer.models.aimodels.translate_sentence.TranslateSentence;
import com.artificalyzer.models.userroles.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "translate_sentence_users", schema = "artificalyzer")
public class TranslateSentenceUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ur_user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "translate_sentence_id")
    private TranslateSentence translateSentence;

    public TranslateSentenceUsers(User user, TranslateSentence translateSentence) {
        this.user = user;
        this.translateSentence = translateSentence;
    }
}