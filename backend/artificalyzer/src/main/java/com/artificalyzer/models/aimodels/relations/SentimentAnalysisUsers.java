package com.artificalyzer.models.aimodels.relations;

import com.artificalyzer.models.aimodels.sentiment_analysis.SentimentAnalysis;
import com.artificalyzer.models.userroles.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "sentiment_analysis_users", schema = "artificalyzer")
public class SentimentAnalysisUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ur_user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sentiment_analysis_id")
    private SentimentAnalysis sentimentAnalysis;

    public SentimentAnalysisUsers(User user, SentimentAnalysis sentimentAnalysis) {
        this.user = user;
        this.sentimentAnalysis = sentimentAnalysis;
    }
}
