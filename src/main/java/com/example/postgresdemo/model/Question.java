package com.example.postgresdemo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "questions")
public class Question extends AuditModel {
    @Id
    @GeneratedValue(generator = "question_generator")
    @SequenceGenerator(
            name = "question_generator",
            sequenceName = "question_sequence",
            initialValue = 1000
    )
    @Column(name = "question_id")
    private Long id;

    @NotBlank
    @Column(columnDefinition = "text")
    private  String questionText;

    @NotBlank
    @Column(columnDefinition = "boolean")
    private boolean isActive;

    @ManyToOne (fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="category_id", nullable=false)
    private Category category;

    @ManyToOne (fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="user_id", nullable=false)
    private User creator;

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Set<PsychoTest> getTests() {
        return tests;
    }

    public void setTests(Set<PsychoTest> tests) {
        this.tests = tests;
    }

    @ManyToMany(mappedBy = "category")
    private Set<PsychoTest> tests;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getCreatedBy() {
        return creator;
    }

    public void setCreatedBy(User creatorId) {
        this.creator = creatorId;
    }
}
