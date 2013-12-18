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

/**
 *
 * @author ehrick
 */
public class Leitor {

    private List<String> emails;

    public Leitor() {
      
    }

    public ResultSet retornoConsultaPessoas(String sql) throws SQLException {

        Connection conexao;
        conexao = Conexao.getConnection();
        conexao.createStatement().execute("use " + HibernateConfiguration.getBase());
        return conexao.createStatement().executeQuery(sql);

    }

    public void listarUsuarios() throws SQLException {
        emails = new ArrayList();
        ResultSet retornoConsultaPessoas = retornoConsultaPessoas("select email FROM people ORDER BY email ASC;");

        while (retornoConsultaPessoas.next()) {
            String email = retornoConsultaPessoas.getString("email");
            if (!this.emails.contains(email)) {
                this.emails.add(email);
            }
        }
    }

    public List<String> getEmails() {
        return emails;
    }
}
