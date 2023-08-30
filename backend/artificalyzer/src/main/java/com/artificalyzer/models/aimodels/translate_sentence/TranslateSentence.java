package com.artificalyzer.models.aimodels.translate_sentence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sentence_translate", schema = "artificalyzer")
public class TranslateSentence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String input_sentance;
    @Column(name="lg")
    private int lg;
    private String translated_sentece;
}
