package com.artificalyzer.models.aimodels.sentiment_analysis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sentiment_analysis", schema = "artificalyzer")
public class SentimentAnalysis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String input_sentance;
    @Column(name="polarity")
    private String polarity;
}
