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
@Table(name = "subscription")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subscription.findAll", query = "SELECT s FROM Subscription s")
    , @NamedQuery(name = "Subscription.findBySubscriptionId", query = "SELECT s FROM Subscription s WHERE s.subscriptionId = :subscriptionId")})
public class Subscription implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "subscription_id")
    private Integer subscriptionId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User userId;
    @JoinColumn(name = "tag_id", referencedColumnName = "tag_id")
    @ManyToOne(optional = false)
    private Tag tagId;

    public Subscription() {
    }

    public Subscription(Integer subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public Integer getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Integer subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
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
        hash += (subscriptionId != null ? subscriptionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subscription)) {
            return false;
        }
        Subscription other = (Subscription) object;
        if ((this.subscriptionId == null && other.subscriptionId != null) || (this.subscriptionId != null && !this.subscriptionId.equals(other.subscriptionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.warl0ck.student_resource.model.Subscription[ subscriptionId=" + subscriptionId + " ]";
    }
    
}
