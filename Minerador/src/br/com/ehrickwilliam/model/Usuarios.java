/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ehrickwilliam.model;

import java.io.Serializable;
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
    private String nome;
    private String email;
    private Double contribuicao;
    private String artefatoContribuicao;

    public Integer getId() {
        return id;
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

    public Double getContribuicao() {
        return contribuicao;
    }

    public void setContribuicao(Double contribuicao) {
        this.contribuicao = contribuicao;
    }

    public String getArtefatoContribuicao() {
        return artefatoContribuicao;
    }

    public void setArtefatoContribuicao(String artefatoContribuicao) {
        this.artefatoContribuicao = artefatoContribuicao;
    }

    public Usuarios() {
    }

    public Usuarios(String nome, String email, Double contribuicao, String artefatoContribuicao) {
        this.nome = nome;
        this.email = email;
        this.contribuicao = contribuicao;
        this.artefatoContribuicao = artefatoContribuicao;
    }
}
