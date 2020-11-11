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

public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private String email;
    private String password;
    private int phoneNo;
    private Collection<Answer> answerCollection;
    private Collection<Resource> resourceCollection;
    private Collection<Subscription> subscriptionCollection;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String name, String email, String password, int phoneNo) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNo = phoneNo;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Collection<Answer> getAnswerCollection() {
        return answerCollection;
    }

    public void setAnswerCollection(Collection<Answer> answerCollection) {
        this.answerCollection = answerCollection;
    }

    public Collection<Resource> getResourceCollection() {
        return resourceCollection;
    }

    public void setResourceCollection(Collection<Resource> resourceCollection) {
        this.resourceCollection = resourceCollection;
    }

    public Collection<Subscription> getSubscriptionCollection() {
        return subscriptionCollection;
    }

    public void setSubscriptionCollection(Collection<Subscription> subscriptionCollection) {
        this.subscriptionCollection = subscriptionCollection;
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dummy.project.User[ id=" + id + " ]";
    }
    
}
