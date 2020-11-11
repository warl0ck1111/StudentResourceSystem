/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warl0ck.studentresource.model;

import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author warl0ck
 */

public class Tag implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private String description;
    private Collection<QuestionTag> questionTagCollection;

    public Tag() {
    }

    public Tag(Integer id) {
        this.id = id;
    }

    public Tag(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<QuestionTag> getQuestionTagCollection() {
        return questionTagCollection;
    }

    public void setQuestionTagCollection(Collection<QuestionTag> questionTagCollection) {
        this.questionTagCollection = questionTagCollection;
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
        if (!(object instanceof Tag)) {
            return false;
        }
        Tag other = (Tag) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dummy.project.Tag[ id=" + id + " ]";
    }
    
}
