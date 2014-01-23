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
import javax.persistence.OneToOne;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author Erick
 */
@Entity
public class Commit implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.REMOVE)
    private Usuario commiter;

    public Commit() {
    }

    public Commit(Integer id, Usuario commiter) {
        this.id = id;
        this.commiter = commiter;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getCommiter() {
        return commiter;
    }

    public void setCommiter(Usuario commiter) {
        this.commiter = commiter;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.commiter);
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
        final Commit other = (Commit) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.commiter, other.commiter)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Commit{" + "id=" + id + ", commiter=" + commiter + '}';
    }
}
