/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ehrickwilliam.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Erick
 */
@Entity
public class Conta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String ferramenta;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFerramenta() {
        return ferramenta;
    }

    public void setFerramenta(String ferramenta) {
        this.ferramenta = ferramenta;
    }

    public Conta() {
    }

    public Conta(Integer id, String email, String ferramenta) {
        this.id = id;
        this.email = email;
        this.ferramenta = ferramenta;
    }

    public Conta(String email, String ferramenta) {
        this.email = email;
        this.ferramenta = ferramenta;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.email);
        hash = 97 * hash + Objects.hashCode(this.ferramenta);
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
        final Conta other = (Conta) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.ferramenta, other.ferramenta)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Conta{" + "id=" + id + ", email=" + email + ", ferramenta=" + ferramenta + '}';
    }

    
}
