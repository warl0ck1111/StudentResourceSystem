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
@Table(name = "resource")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resource.findAll", query = "SELECT r FROM Resource r")
    , @NamedQuery(name = "Resource.findByResourceId", query = "SELECT r FROM Resource r WHERE r.resourceId = :resourceId")
    , @NamedQuery(name = "Resource.findByCourseCode", query = "SELECT r FROM Resource r WHERE r.courseCode = :courseCode")
    , @NamedQuery(name = "Resource.findByCourseTitle", query = "SELECT r FROM Resource r WHERE r.courseTitle = :courseTitle")
    , @NamedQuery(name = "Resource.findByResourceType", query = "SELECT r FROM Resource r WHERE r.resourceType = :resourceType")
    , @NamedQuery(name = "Resource.findByInstitution", query = "SELECT r FROM Resource r WHERE r.institution = :institution")
    , @NamedQuery(name = "Resource.findByResourceTimestamp", query = "SELECT r FROM Resource r WHERE r.resourceTimestamp = :resourceTimestamp")
    , @NamedQuery(name = "Resource.findByResourceDescription", query = "SELECT r FROM Resource r WHERE r.resourceDescription = :resourceDescription")
    , @NamedQuery(name = "Resource.findByResourcePath", query = "SELECT r FROM Resource r WHERE r.resourcePath = :resourcePath")})
public class Resource implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "resource_id")
    private Integer resourceId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "course_code")
    private String courseCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "course_title")
    private String courseTitle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "resource_type")
    private String resourceType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "institution")
    private String institution;
    @Basic(optional = false)
    @NotNull
    @Column(name = "resource_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date resourceTimestamp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "resource_description")
    private String resourceDescription;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "resource_path")
    private String resourcePath;
    @JoinColumn(name = "tag_id", referencedColumnName = "tag_id")
    @ManyToOne(optional = false)
    private Tag tagId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User userId;

    public Resource() {
    }

    public Resource(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public Resource(Integer resourceId, String courseCode, String courseTitle, String resourceType, String institution, Date resourceTimestamp, String resourceDescription, String resourcePath) {
        this.resourceId = resourceId;
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.resourceType = resourceType;
        this.institution = institution;
        this.resourceTimestamp = resourceTimestamp;
        this.resourceDescription = resourceDescription;
        this.resourcePath = resourcePath;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public Date getResourceTimestamp() {
        return resourceTimestamp;
    }

    public void setResourceTimestamp(Date resourceTimestamp) {
        this.resourceTimestamp = resourceTimestamp;
    }

    public String getResourceDescription() {
        return resourceDescription;
    }

    public void setResourceDescription(String resourceDescription) {
        this.resourceDescription = resourceDescription;
    }

    public String getResourcePath() {
        return resourcePath;
    }

    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    public Tag getTagId() {
        return tagId;
    }

    public void setTagId(Tag tagId) {
        this.tagId = tagId;
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
        hash += (resourceId != null ? resourceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resource)) {
            return false;
        }
        Resource other = (Resource) object;
        if ((this.resourceId == null && other.resourceId != null) || (this.resourceId != null && !this.resourceId.equals(other.resourceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.warl0ck.student_resource.model.Resource[ resourceId=" + resourceId + " ]";
    }
    
}
