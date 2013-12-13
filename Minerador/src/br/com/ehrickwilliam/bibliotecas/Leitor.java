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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ehrick
 */
public class Leitor {

    private List emails;
    
    public ResultSet retornoConsultaPessoas(String sql) throws SQLException {

        Connection conexao;

        conexao = Conexao.getConnection();
        conexao.createStatement().execute("use " + HibernateConfiguration.getBase());

        HibernateConfiguration.criarSchema();
        ResultSet executeQuery = conexao.createStatement().executeQuery(sql);
        return executeQuery;

    }
    
    
    public List listarUsuarios() throws SQLException {
        emails = new ArrayList();
        ResultSet retornoConsultaPessoas = retornoConsultaPessoas("select email FROM people;");
        
        while(retornoConsultaPessoas.next()){
           String email = retornoConsultaPessoas.getString("email");
           if(!this.emails.contains(email)){
               this.emails.add(email);
           }
        }
        return this.emails;
    }
    
    
    public List<Usuarios> retornoConsulta() throws SQLException{
        String consulta = "SELECT DISTINCT comments.id AS comments, issues.id AS issues, "
                + "issues_ext_bugzilla.component AS component, people.email AS email FROM "
                + "issues_ext_bugzilla,issues, people, comments WHERE (people.id = issues.submitted_by "
                + "OR people.id = issues.assigned_to OR people.id = comments.submitted_by) AND issues.id "
                + "= comments.issue_id AND issues_ext_bugzilla.issue_id = issues.id ";
        
        ResultSet retornoConsultaPessoas = retornoConsultaPessoas(consulta);
         
    }
    public static void main(String[] args) {
        HibernateConfiguration.setBase("bicho");
        HibernateConfiguration.setHost("localhost");
        HibernateConfiguration.setPass("root");
        HibernateConfiguration.setUser("root");
        try {
            List listarUsuarios = new Leitor().listarUsuarios();
            for (Object object : listarUsuarios) {
                System.out.println(object);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Leitor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
