/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warl0ck.student_resource.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author warl0ck
 */
@Entity
@Table(name = "tag")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tag.findAll", query = "SELECT t FROM Tag t")
    , @NamedQuery(name = "Tag.findByTagId", query = "SELECT t FROM Tag t WHERE t.tagId = :tagId")
    , @NamedQuery(name = "Tag.findByTagName", query = "SELECT t FROM Tag t WHERE t.tagName = :tagName")
    , @NamedQuery(name = "Tag.findByTagDescription", query = "SELECT t FROM Tag t WHERE t.tagDescription = :tagDescription")})
public class Tag implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tag_id")
    private Integer tagId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "tag_name")
    private String tagName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "tag_description")
    private String tagDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tagId")
    private List<QuestionTag> questionTagList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tagId")
    private List<Resource> resourceList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tagId")
    private List<Subscription> subscriptionList;

    public Tag() {
    }

    public Tag(Integer tagId) {
        this.tagId = tagId;
    }

    public Tag(Integer tagId, String tagName, String tagDescription) {
        this.tagId = tagId;
        this.tagName = tagName;
        this.tagDescription = tagDescription;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getTagDescription() {
        return tagDescription;
    }

    public void setTagDescription(String tagDescription) {
        this.tagDescription = tagDescription;
    }

    @XmlTransient
    public List<QuestionTag> getQuestionTagList() {
        return questionTagList;
    }

    public void setQuestionTagList(List<QuestionTag> questionTagList) {
        this.questionTagList = questionTagList;
    }

    @XmlTransient
    public List<Resource> getResourceList() {
        return resourceList;
    }

    public void setResourceList(List<Resource> resourceList) {
        this.resourceList = resourceList;
    }

    @XmlTransient
    public List<Subscription> getSubscriptionList() {
        return subscriptionList;
    }

    public void setSubscriptionList(List<Subscription> subscriptionList) {
        this.subscriptionList = subscriptionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tagId != null ? tagId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tag)) {
            return false;
        }
        Tag other = (Tag) object;
        if ((this.tagId == null && other.tagId != null) || (this.tagId != null && !this.tagId.equals(other.tagId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.warl0ck.student_resource.model.Tag[ tagId=" + tagId + " ]";
    }
    
}
