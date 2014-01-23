/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ehrickwilliam.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author Erick
 */
@Entity
public class Comment implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.REMOVE)
    private Usuario commitedBy;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.REMOVE)
    private Issue issue;

    public Comment() {
    }

    public Comment(Integer id, Usuario commitedBy, Issue issue) {
        this.id = id;
        this.commitedBy = commitedBy;
        this.issue = issue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getCommitedBy() {
        return commitedBy;
    }

    public void setCommitedBy(Usuario commitedBy) {
        this.commitedBy = commitedBy;
    }

    public Issue getIssue() {
        return issue;
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.commitedBy);
        hash = 97 * hash + Objects.hashCode(this.issue);
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
        final Comment other = (Comment) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.commitedBy, other.commitedBy)) {
            return false;
        }
        if (!Objects.equals(this.issue, other.issue)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Comment{" + "id=" + id + ", commitedBy=" + commitedBy + ", issue=" + issue + '}';
    }
    
    
    
}
