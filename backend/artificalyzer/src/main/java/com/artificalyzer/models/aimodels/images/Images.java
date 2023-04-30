package com.artificalyzer.models.aimodels.images;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ai_images", schema = "aimodels")
public class Images {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String prompt;
    @Column(name="number_images")
    private int numberImages;
    private String size;

    private String url;

}
