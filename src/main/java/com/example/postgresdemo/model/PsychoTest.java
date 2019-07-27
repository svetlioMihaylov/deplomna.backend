package com.example.postgresdemo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "psycho_test")
public class PsychoTest extends AuditModel  {
    @Id
    @GeneratedValue(generator = "test_generator")
    @SequenceGenerator(
            name = "test_generator",
            sequenceName = "test_sequence",
            initialValue = 1000
    )
    @Column(name = "test_id")
    private Long id;

    private Long numberOfQuestions;

    private Long timeToSolve;

    private String description;

    @ManyToOne (fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="category_id", nullable=false)
    private Category category;

    @ManyToOne (fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="user_id", nullable=false)
    private User creator;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Test_Question",
            joinColumns = { @JoinColumn(name = "test_id") },
            inverseJoinColumns = { @JoinColumn(name = "question_id") }
    )
    private Set<Question> questions;

    @OneToOne(mappedBy = "test")
    private TestResult result;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void setNumberOfQuestions(Long numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

    public Long getTimeToSolve() {
        return timeToSolve;
    }

    public void setTimeToSolve(Long timeToSolve) {
        this.timeToSolve = timeToSolve;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }
}
