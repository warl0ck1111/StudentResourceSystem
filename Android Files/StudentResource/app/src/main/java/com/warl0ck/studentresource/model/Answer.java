/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warl0ck.studentresource.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author warl0ck
 */

public class Answer implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private int question;
    private String description;
    private Date timestamp;
    private int voteCount;
    private User user;
    private Collection<Question> questionCollection;

    public Answer() {
    }

    public Answer(Integer id) {
        this.id = id;
    }

    public Answer(Integer id, int question, String description, Date timestamp, int voteCount) {
        this.id = id;
        this.question = question;
        this.description = description;
        this.timestamp = timestamp;
        this.voteCount = voteCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQuestion() {
        return question;
    }

    public void setQuestion(int question) {
        this.question = question;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Collection<Question> getQuestionCollection() {
        return questionCollection;
    }

    public void setQuestionCollection(Collection<Question> questionCollection) {
        this.questionCollection = questionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Answer)) {
            return false;
        }
        Answer other = (Answer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dummy.project.Answer[ id=" + id + " ]";
    }
    
}
