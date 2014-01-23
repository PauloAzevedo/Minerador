/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ehrickwilliam.teste;

import br.com.ehrickwilliam.bibliotecas.Leitor;
import br.com.ehrickwilliam.conexao.HibernateConfiguration;

/**
 *
 * @author ehrick
 */
public class testeHibernate {

    public static void main(String[] args) {
        Leitor leitor = new Leitor();
        HibernateConfiguration.setBase("minerador");
        HibernateConfiguration.setPass("root");
        HibernateConfiguration.setHost("127.0.0.1");
        HibernateConfiguration.setUser("root");
        HibernateConfiguration.criarSchema();

    }
}
