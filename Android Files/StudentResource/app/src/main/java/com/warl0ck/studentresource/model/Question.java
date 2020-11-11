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
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String questionTitle;
    private String description;
    private User user;
    private int viewCount;
    private Date timestamp;
    private Answer approvedAnswer;
    private Collection<Resource> resourceCollection;

    public Question() {
    }

    public Question(Integer id) {
        this.id = id;
    }

    public Question(Integer id, String questionTitle, String description, User user, int viewCount, Date timestamp) {
        this.id = id;
        this.questionTitle = questionTitle;
        this.description = description;
        this.user = user;
        this.viewCount = viewCount;
        this.timestamp = timestamp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Answer getApprovedAnswer() {
        return approvedAnswer;
    }

    public void setApprovedAnswer(Answer approvedAnswer) {
        this.approvedAnswer = approvedAnswer;
    }

    public Collection<Resource> getResourceCollection() {
        return resourceCollection;
    }

    public void setResourceCollection(Collection<Resource> resourceCollection) {
        this.resourceCollection = resourceCollection;
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
        if (!(object instanceof Question)) {
            return false;
        }
        Question other = (Question) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dummy.project.Question[ id=" + id + " ]";
    }
    
}
