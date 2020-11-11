/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warl0ck.student_resource.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author warl0ck
 */
@Entity
@Table(name = "question")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Question.findAll", query = "SELECT q FROM Question q")
    , @NamedQuery(name = "Question.findByQuestionId", query = "SELECT q FROM Question q WHERE q.questionId = :questionId")
    , @NamedQuery(name = "Question.findByQuestionTitle", query = "SELECT q FROM Question q WHERE q.questionTitle = :questionTitle")
    , @NamedQuery(name = "Question.findByQuestionDescription", query = "SELECT q FROM Question q WHERE q.questionDescription = :questionDescription")
    , @NamedQuery(name = "Question.findByQuestionTimestamp", query = "SELECT q FROM Question q WHERE q.questionTimestamp = :questionTimestamp")
    , @NamedQuery(name = "Question.findByVoteCount", query = "SELECT q FROM Question q WHERE q.voteCount = :voteCount")
    , @NamedQuery(name = "Question.findByApprovedAnswer", query = "SELECT q FROM Question q WHERE q.approvedAnswer = :approvedAnswer")})
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "question_id")
    private Integer questionId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "question_title")
    private String questionTitle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "question_description")
    private String questionDescription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "question_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date questionTimestamp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vote_count")
    private int voteCount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "approved_answer")
    private int approvedAnswer;
    
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User userId;

    public Question() {
    }

    public Question(Integer questionId) {
        this.questionId = questionId;
    }

    public Question(Integer questionId, String questionTitle, String questionDescription, Date questionTimestamp, int voteCount, int approvedAnswer) {
        this.questionId = questionId;
        this.questionTitle = questionTitle;
        this.questionDescription = questionDescription;
        this.questionTimestamp = questionTimestamp;
        this.voteCount = voteCount;
        this.approvedAnswer = approvedAnswer;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getQuestionDescription() {
        return questionDescription;
    }

    public void setQuestionDescription(String questionDescription) {
        this.questionDescription = questionDescription;
    }

    public Date getQuestionTimestamp() {
        return questionTimestamp;
    }

    public void setQuestionTimestamp(Date questionTimestamp) {
        this.questionTimestamp = questionTimestamp;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public int getApprovedAnswer() {
        return approvedAnswer;
    }

    public void setApprovedAnswer(int approvedAnswer) {
        this.approvedAnswer = approvedAnswer;
    }


    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (questionId != null ? questionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Question)) {
            return false;
        }
        Question other = (Question) object;
        if ((this.questionId == null && other.questionId != null) || (this.questionId != null && !this.questionId.equals(other.questionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.warl0ck.student_resource.model.Question[ questionId=" + questionId + " ]";
    }
    
}
