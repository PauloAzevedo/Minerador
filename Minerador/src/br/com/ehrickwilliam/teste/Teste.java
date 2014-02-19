/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ehrickwilliam.teste;

import br.com.ehrickwilliam.conexao.HibernateConfiguration;

/**
 *
 * @author Erick
 */
public class Teste {

    public static void main(String[] args) {
        HibernateConfiguration.setBase("minerador");
        HibernateConfiguration.setHost("localhost");
        HibernateConfiguration.setUser("root");
        HibernateConfiguration.setPass("root");
        HibernateConfiguration.criarSchema();
    }
}
