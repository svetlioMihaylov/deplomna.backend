package com.example.postgresdemo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "categories")

public class Category extends AuditModel {
    @Id
    @GeneratedValue(generator = "category_generator")
    @SequenceGenerator(
            name = "category_generator",
            sequenceName = "category_sequence",
            initialValue = 1000
    )
    @Column(name = "category_id")
    private Long id;

    @NotBlank
    @Column(columnDefinition = "text")
    private String title;


    @ManyToOne (fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="user_id", nullable=false)
    private User creator;

    @NotBlank
    @Column(columnDefinition = "boolean")
    private boolean isActive;

    @NotBlank
    @Column(columnDefinition = "text")
    private String description;

    @OneToMany(mappedBy="category")
    private Set<Question> questions;

    @OneToMany(mappedBy="category")
    private Set<PsychoTest> tests;

    public Category(long id, String title, User creatorId, boolean isActive, String description) {
        this.id = id;
        this.title = title;
        this.creator = creatorId;
        this.isActive = isActive;
        this.description = description;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public User getCreator() {
        return creator;
    }

    public boolean isActive() {
        return isActive;
    }

    public String getDescription() {
        return description;
    }
}
