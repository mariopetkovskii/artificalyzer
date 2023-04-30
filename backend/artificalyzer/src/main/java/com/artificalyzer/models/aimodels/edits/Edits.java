package com.artificalyzer.models.aimodels.edits;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ai_edits", schema = "aimodels")
public class Edits {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    @Column(name = "input_text")

    private String inputText;
    private String instruction;
    @Column(name = "output_text")

    private String outputText;
}
