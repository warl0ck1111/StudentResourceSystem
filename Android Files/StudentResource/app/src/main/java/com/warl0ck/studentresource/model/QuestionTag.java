/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warl0ck.studentresource.model;

import java.io.Serializable;

/**
 *
 * @author warl0ck
 */
public class QuestionTag implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private int question;
    private Tag tag;

    public QuestionTag() {
    }

    public QuestionTag(Integer id) {
        this.id = id;
    }

    public QuestionTag(Integer id, int question) {
        this.id = id;
        this.question = question;
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

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
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
        if (!(object instanceof QuestionTag)) {
            return false;
        }
        QuestionTag other = (QuestionTag) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dummy.project.QuestionTag[ id=" + id + " ]";
    }
    
}
