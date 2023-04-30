package com.artificalyzer.models.aimodels.moderations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ai_moderations", schema = "aimodels")
public class Moderation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "input_text")
    private String inputText;
    //===============================
    private Boolean hate;
    @Column(name = "hate_score")
    private Double hateScore;
    //===============================
    //===============================
    @Column(name = "hate_and_threatening")
    private Boolean hateAndThreatening;
    @Column(name = "hate_and_threatening_score")
    private Double hateAndThreateningScore;
    //===============================
    //===============================
    @Column(name = "self_harm")
    private Boolean selfHarm;
    @Column(name = "self_harm_score")
    private Double selfHarmScore;
    //===============================
    //===============================
    private Boolean sexual;
    @Column(name = "sexual_score")
    private Double sexualScore;
    //===============================
    //===============================
    @Column(name = "sexual_minors")
    private Boolean sexualMinors;
    @Column(name = "sexual_minors_score")
    private Double sexualMinorsScore;
    //===============================
    //===============================
    private Boolean violence;
    @Column(name = "violence_score")
    private Double violenceScore;
    //===============================
    //===============================
    @Column(name = "violence_graphic")
    private Boolean violenceGraphic;
    @Column(name = "violence_graphic_score")
    private Double violenceGraphicScore;
    //===============================
}
