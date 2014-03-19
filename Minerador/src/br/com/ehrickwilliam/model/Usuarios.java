/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ehrickwilliam.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Comparator;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author ehrick
 */

@Entity
public class Usuarios implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    public static final Comparator<Usuarios> POR_CONTRIBUICAO = new Comparator<Usuarios>() {

        @Override
        public int compare(Usuarios t, Usuarios t1) {
          return t.contribuicao.compareTo(t1.contribuicao);
        }
    };
    private String nome;
    private String email;
    private BigDecimal contribuicao;
    private String artefatoContribuicao;

    public Integer getId() {
        return id;
    }

    public Usuarios() {
    }

    public Usuarios(String nome, String email, BigDecimal contribuicao, String artefatoContribuicao) {
        this.nome = nome;
        this.email = email;
        this.contribuicao = contribuicao;
        this.artefatoContribuicao = artefatoContribuicao;
    }

    
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getContribuicao() {
        return contribuicao;
    }

    public void setContribuicao(BigDecimal contribuicao) {
        this.contribuicao = contribuicao;
    }

    public String getArtefatoContribuicao() {
        return artefatoContribuicao;
    }

    public void setArtefatoContribuicao(String artefatoContribuicao) {
        this.artefatoContribuicao = artefatoContribuicao;
    }


    @Override
    public String toString() {
        return "Usuarios{" + "id=" + id + ", nome=" + nome + ", email=" + email + ", contribuicao=" + contribuicao + ", artefatoContribuicao=" + artefatoContribuicao + '}';
    }

}