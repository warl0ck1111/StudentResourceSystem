/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warl0ck.student_resource.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author warl0ck
 */
@Entity
@Table(name = "question_tag")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QuestionTag.findAll", query = "SELECT q FROM QuestionTag q")
    , @NamedQuery(name = "QuestionTag.findByQuestionTagId", query = "SELECT q FROM QuestionTag q WHERE q.questionTagId = :questionTagId")})
public class QuestionTag implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "question_tag_id")
    private Integer questionTagId;
    @JoinColumn(name = "question_id", referencedColumnName = "question_id")
    @ManyToOne(optional = false)
    private Question questionId;
    @JoinColumn(name = "tag_id", referencedColumnName = "tag_id")
    @ManyToOne(optional = false)
    private Tag tagId;

    public QuestionTag() {
    }

    public QuestionTag(Integer questionTagId) {
        this.questionTagId = questionTagId;
    }

    public Integer getQuestionTagId() {
        return questionTagId;
    }

    public void setQuestionTagId(Integer questionTagId) {
        this.questionTagId = questionTagId;
    }

    public Question getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Question questionId) {
        this.questionId = questionId;
    }

    public Tag getTagId() {
        return tagId;
    }

    public void setTagId(Tag tagId) {
        this.tagId = tagId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (questionTagId != null ? questionTagId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuestionTag)) {
            return false;
        }
        QuestionTag other = (QuestionTag) object;
        if ((this.questionTagId == null && other.questionTagId != null) || (this.questionTagId != null && !this.questionTagId.equals(other.questionTagId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.warl0ck.student_resource.model.QuestionTag[ questionTagId=" + questionTagId + " ]";
    }
    
}
