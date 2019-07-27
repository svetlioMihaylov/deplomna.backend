package com.example.postgresdemo.model;

import javax.persistence.*;

@Entity
@Table(name = "scores")
public class Score {

    @Id
    @GeneratedValue(generator = "score_generator")
    @SequenceGenerator(
            name = "score_generator",
            sequenceName = "score_sequence",
            initialValue = 1000
    )
    @Column(name = "score_id")
    private Long id;


    @OneToOne(mappedBy = "score")
    private TestResult result;

    private Long score;

}
