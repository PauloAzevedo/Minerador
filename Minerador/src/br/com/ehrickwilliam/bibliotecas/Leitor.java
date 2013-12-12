/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ehrickwilliam.bibliotecas;

import br.com.ehrickwilliam.conexao.Conexao;
import br.com.ehrickwilliam.conexao.HibernateConfiguration;
import br.com.ehrickwilliam.model.Usuarios;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ehrick
 */
public class Leitor {

    public ResultSet retornoConsultaPessoas() throws SQLException {

        Connection conexao;

        conexao = Conexao.getConnection();
        conexao.createStatement().execute("use " + HibernateConfiguration.getBase());

        HibernateConfiguration.criarSchema();
        ResultSet executeQuery = conexao.createStatement().executeQuery("select email FROM people;");
        return executeQuery;

    }
    
    
    public ArrayList<Usuarios> listarUsuarios() throws SQLException {
        
        ResultSet retornoConsultaPessoas = retornoConsultaPessoas();
        
        while(retornoConsultaPessoas.next()){
           
        }
    }

}
