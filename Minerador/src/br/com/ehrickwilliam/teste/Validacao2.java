/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ehrickwilliam.teste;

import br.com.ehrickwilliam.bibliotecas.Leitor;
import br.com.ehrickwilliam.conexao.HibernateConfiguration;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Erick
 */
public class Validacao2 {

    public static void main(String[] args) {

        String[] novatos = new String[]{
            "rmcampos@libreoffice.org"
        };

        HibernateConfiguration.setHost("localhost");
        HibernateConfiguration.setUser("root");
        HibernateConfiguration.setPass("root");
        HibernateConfiguration.setBase("presley");
        for (int i = 0; i < novatos.length; i++) {

            try {

                String consultaCount = "SELECT COUNT(*) as soma FROM presley.problema WHERE desenvolvedor_email = '" + novatos[i] + "';";
                ResultSet resultCount = new Leitor().retornoConsultas(consultaCount);
                resultCount.next();

                String consulta = "SELECT * FROM presley.problema p WHERE desenvolvedor_email = '" + novatos[i] + "';";
                ResultSet componentes = new Leitor().retornoConsultas(consulta);
                
                while (componentes.next()) {
                    List<UsuariosComments2> usuariosRespostas = new ArrayList();
                    List<String> email = new ArrayList<>();
                    System.out.println("Problema ID " + componentes.getString("id") + " Submitted By: " + componentes.getString("desenvolvedor_email") + " Submitted Value: " + resultCount.getInt("soma"));
                    System.out.println("--Respostas--");

                    String consultaResposta = "SELECT * FROM presley.solucao s where problema_id = '" + componentes.getString("id") + "' AND desenvolvedor_email  != '" + componentes.getString("desenvolvedor_email") + "';";
                    ResultSet resultResposta = new Leitor().retornoConsultas(consultaResposta);
                    

                    while (resultResposta.next()) {
                        ResultSet segundaBusca = new Leitor().retornoConsultas(consultaResposta);
                        int count = 0;
                        while (segundaBusca.next()) {
                            if (resultResposta.getString("desenvolvedor_email").equals(segundaBusca.getString("desenvolvedor_email"))) {
                                count++;
                            }
                        }

                        UsuariosComments2 user = new UsuariosComments2(resultResposta.getString("desenvolvedor_email"), count);

                        if (!email.contains(resultResposta.getString("desenvolvedor_email"))) {
                            email.add(resultResposta.getString("desenvolvedor_email"));
                            usuariosRespostas.add(user);
                        }
                    }
                    
                    Collections.sort(usuariosRespostas, UsuariosComments2.POR_TOTAL);
                    Collections.reverse(usuariosRespostas);
                    for (UsuariosComments2 object : usuariosRespostas) {
                        System.out.println(object.usuario + " interagiu " + object.total + "" + (object.total > 1 ? " vezes" : " vez"));
                    }
                    System.out.println("");
                }

            } catch (SQLException ex) {
                Logger.getLogger(Validacao2.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }

}

class UsuariosComments2 {

    String usuario;
    Integer total;

    public static final Comparator<UsuariosComments2> POR_TOTAL = new Comparator<UsuariosComments2>() {

        @Override
        public int compare(UsuariosComments2 t, UsuariosComments2 t1) {
            return t.total.compareTo(t1.total);
        }
    };

    public UsuariosComments2(String usuario, int total) {
        this.usuario = usuario;
        this.total = total;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

}
