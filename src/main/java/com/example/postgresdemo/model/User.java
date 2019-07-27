package com.example.postgresdemo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends AuditModel {

    @Id
    @GeneratedValue(generator = "user_generator")
    @SequenceGenerator(
            name = "user_generator",
            sequenceName = "user_sequence",
            initialValue = 1000
    )
    @Column(name = "user_id")
    private Long id;
    @NotBlank
    @Column(columnDefinition = "text")
    private String username;
    @NotBlank
    @Column(columnDefinition = "text")
    private String password;
    @NotBlank
    @Column(columnDefinition = "text")
    private String mail;
    @NotBlank
    @Column(columnDefinition = "boolean")
    private boolean isActive;

    @OneToMany(mappedBy="creator")
    private Set<Category> categories;

    @OneToMany(mappedBy="creator")
    private Set<Question> questions;

    @OneToMany(mappedBy="creator")
    private Set<Answer> answers;

    @OneToMany(mappedBy="creator")
    private Set<PsychoTest> tests;

    @OneToMany(mappedBy="solvedBy")
    private Set<TestResult> solvedTests;


    public void setId(Long id) {
        this.id = id;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public User() {

    }

    public User(long id, String username, String password, String mail, boolean isActive) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.isActive = isActive;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
