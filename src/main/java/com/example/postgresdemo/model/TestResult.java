package com.example.postgresdemo.model;


import javax.persistence.*;

@Entity
@Table(name = "test_results")
public class TestResult extends AuditModel {

    @Id
    @GeneratedValue(generator = "result_generator")
    @SequenceGenerator(
            name = "result_generator",
            sequenceName = "result_sequence",
            initialValue = 1000
    )
    @Column(name = "result_id")
    private Long id;


    @ManyToOne (fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="user_id", nullable=false)
    private User solvedBy;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "test_id", referencedColumnName = "test_id")
    private PsychoTest test;

    private Long solvedForTime;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "score_id", referencedColumnName = "score_id")
    private Score score;
}
