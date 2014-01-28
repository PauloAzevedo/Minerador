/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ehrickwilliam.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author Erick
 */
@Entity
public class Issue implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.REMOVE)
    private Usuario submittedBy;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.REMOVE)
    private Usuario assignedTo;
    
    private int issue;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar submittedOn;

    private String ferramenta;

    public String getFerramenta() {
        return ferramenta;
    }

    public void setFerramenta(String ferramenta) {
        this.ferramenta = ferramenta;
    }
    
    public Calendar getSubmittedOn() {
        return submittedOn;
    }

    public void setSubmittedOn(Calendar submittedOn) {
        this.submittedOn = submittedOn;
    }

    public int getIssue() {
        return issue;
    }

    public void setIssue(int issue) {
        this.issue = issue;
    }

    public Issue() {
    }

    public Issue(Integer id, Usuario submittedBy, Usuario assignedTo) {
        this.id = id;
        this.submittedBy = submittedBy;
        this.assignedTo = assignedTo;
    }

    public Issue(Usuario submittedBy, Usuario assignedTo, int issue) {
        this.submittedBy = submittedBy;
        this.assignedTo = assignedTo;
        this.issue = issue;
    }

    public Issue(Integer id, Usuario submittedBy, Usuario assignedTo, int issue, Calendar submittedOn) {
        this.id = id;
        this.submittedBy = submittedBy;
        this.assignedTo = assignedTo;
        this.issue = issue;
        this.submittedOn = submittedOn;
    }

    public Issue(Usuario submittedBy, Usuario assignedTo, int issue, Calendar submittedOn) {
        this.submittedBy = submittedBy;
        this.assignedTo = assignedTo;
        this.issue = issue;
        this.submittedOn = submittedOn;
    }

    public Issue(Usuario submittedBy, Usuario assignedTo, int issue, Calendar submittedOn, String ferramenta) {
        this.submittedBy = submittedBy;
        this.assignedTo = assignedTo;
        this.issue = issue;
        this.submittedOn = submittedOn;
        this.ferramenta = ferramenta;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(Usuario submittedBy) {
        this.submittedBy = submittedBy;
    }

    public Usuario getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(Usuario assignedTo) {
        this.assignedTo = assignedTo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.submittedBy);
        hash = 53 * hash + Objects.hashCode(this.assignedTo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Issue other = (Issue) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.submittedBy, other.submittedBy)) {
            return false;
        }
        if (!Objects.equals(this.assignedTo, other.assignedTo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Issue{" + "id=" + id + ", submittedBy=" + submittedBy + ", assignedTo=" + assignedTo + '}';
    }
    
    
}
