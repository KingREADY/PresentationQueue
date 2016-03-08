package com.github.kingready.presentationqueue.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Presentation implements Serializable {

    private static final long serialVersionID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String studentID;
    private String topic;
    private String subject;

    //<editor-fold desc="Constructors">
    public Presentation() {
    }

    public Presentation(String studentID, String topic, String subject) {
        this.studentID = studentID;
        this.topic = topic;
        this.subject = subject;
    }
    //</editor-fold>

    //<editor-fold desc="Getters & Setters">
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    //</editor-fold>
}
