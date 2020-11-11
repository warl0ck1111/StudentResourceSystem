/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warl0ck.student_resource.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author warl0ck
 */
@Entity
@Table(name = "answer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Answer.findAll", query = "SELECT a FROM Answer a")
    , @NamedQuery(name = "Answer.findByAnswerId", query = "SELECT a FROM Answer a WHERE a.answerId = :answerId")
    , @NamedQuery(name = "Answer.findByAnswerTimestamp", query = "SELECT a FROM Answer a WHERE a.answerTimestamp = :answerTimestamp")
    , @NamedQuery(name = "Answer.findByVoteCount", query = "SELECT a FROM Answer a WHERE a.voteCount = :voteCount")
    , @NamedQuery(name = "Answer.findByAnswer", query = "SELECT a FROM Answer a WHERE a.answer = :answer")
    , @NamedQuery(name = "Answer.findByTimestamp", query = "SELECT a FROM Answer a WHERE a.timestamp = :timestamp")
    , @NamedQuery(name = "Answer.findByQuestionDescription", query = "SELECT a FROM Answer a WHERE a.questionDescription = :questionDescription")
    , @NamedQuery(name = "Answer.findByQuestionTitle", query = "SELECT a FROM Answer a WHERE a.questionTitle = :questionTitle")})
public class Answer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "answer_id")
    private Integer answerId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "answer_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date answerTimestamp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vote_count")
    private int voteCount;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "answer")
    private String answer;
    @Basic(optional = false)
    @NotNull
    @Column(name = "timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "question_description")
    private String questionDescription;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "question_title")
    private String questionTitle;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User userId;
    @JoinColumn(name = "question_id", referencedColumnName = "question_id")
    @ManyToOne(optional = false)
    private Question questionId;

    public Answer() {
    }

    public Answer(Integer answerId) {
        this.answerId = answerId;
    }

    public Answer(Integer answerId, Date answerTimestamp, int voteCount, String answer, Date timestamp, String questionDescription, String questionTitle) {
        this.answerId = answerId;
        this.answerTimestamp = answerTimestamp;
        this.voteCount = voteCount;
        this.answer = answer;
        this.timestamp = timestamp;
        this.questionDescription = questionDescription;
        this.questionTitle = questionTitle;
    }

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    public Date getAnswerTimestamp() {
        return answerTimestamp;
    }

    public void setAnswerTimestamp(Date answerTimestamp) {
        this.answerTimestamp = answerTimestamp;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getQuestionDescription() {
        return questionDescription;
    }

    public void setQuestionDescription(String questionDescription) {
        this.questionDescription = questionDescription;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Question getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Question questionId) {
        this.questionId = questionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (answerId != null ? answerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Answer)) {
            return false;
        }
        Answer other = (Answer) object;
        if ((this.answerId == null && other.answerId != null) || (this.answerId != null && !this.answerId.equals(other.answerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.warl0ck.student_resource.model.Answer[ answerId=" + answerId + " ]";
    }
    
}
