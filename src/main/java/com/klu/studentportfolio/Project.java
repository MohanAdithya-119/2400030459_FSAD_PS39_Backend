package com.klu.studentportfolio;

import jakarta.persistence.*;

@Entity
@Table(name="projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String studentName;
    private String status;
    private String feedback;

    public Project() {}

    public Long getId() { return id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getStudentName() { return studentName; }

    public void setStudentName(String studentName) { this.studentName = studentName; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public String getFeedback() { return feedback; }

    public void setFeedback(String feedback) { this.feedback = feedback; }
}