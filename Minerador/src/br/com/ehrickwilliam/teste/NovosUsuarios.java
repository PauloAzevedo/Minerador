/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ehrickwilliam.teste;

import br.com.ehrickwilliam.bibliotecas.Leitor;
import br.com.ehrickwilliam.bibliotecas.Util;
import br.com.ehrickwilliam.conexao.HibernateConfiguration;
import br.com.ehrickwilliam.daos.DaoComment;
import br.com.ehrickwilliam.daos.DaoCommit;
import br.com.ehrickwilliam.daos.DaoIssues;
import br.com.ehrickwilliam.daos.DaoUsuario;
import br.com.ehrickwilliam.model.Comment;
import br.com.ehrickwilliam.model.Commit;
import br.com.ehrickwilliam.model.Issue;
import br.com.ehrickwilliam.model.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Erick
 */
public class NovosUsuarios {

    public static void main(String[] args) {

        HibernateConfiguration.setBase("minerador");
        HibernateConfiguration.setHost("localhost");
        HibernateConfiguration.setUser("root");
        HibernateConfiguration.setPass("root");

//        List<Issue> listarIssue = new DaoIssues().listar("", "id");
//
//        List<Usuario> novos = new ArrayList<>();
//        List<Usuario> velhos = new ArrayList<>();
//        List<Comment> obterPorIssue = new DaoComment().listar("", "id");
//
//        for (Issue i : listarIssue) {
//            if (i.getSubmittedOn().before(Util.stringToCalendar("01/07/2012"))) {
//                if (!velhos.contains(i.getAssignedTo())) {
//                    velhos.add(i.getAssignedTo());
//                }
//            }
//        }
//
//        for (Issue i : listarIssue) {
//            if (i.getSubmittedOn().after(Util.stringToCalendar("01/07/2012")) && i.getSubmittedOn().before(Util.stringToCalendar("31/12/2012"))) {
//                if (!novos.contains(i.getAssignedTo())) {
//                    novos.add(i.getAssignedTo());
//                }
//            }
//        }
//
//        List<Usuario> novosN = new ArrayList<>();
//        for (Usuario usuario : velhos) {
//            if (!novos.contains(usuario)) {
//                novosN.add(usuario);
//            }
//        }

//        for (Usuario usuario : novosN) {
//            int count = 0;
//            for (Issue i : listarIssue) {
//                if (i.getAssignedTo().equals(usuario)) {
//                    count++;
//                }
//
//                for (Comment comment : obterPorIssue) {
//                    if (comment.getIssue().equals(i)) {
//                        if (comment.getCommitedBy().getConta().equals(usuario)) {
//                            count++;
//                        }
//                    }
//                }
//            }
//
//            System.out.println(usuario.getConta().getEmail() + " - " + count);
//        }
        System.out.println("---------------------------EMAIL---------------------------");
//
        List emailNovo = new ArrayList();
        HibernateConfiguration.setBase("presley");
        try {
            String consulta = "SELECT DISTINCT desenvolvedor_email FROM problema WHERE dataRelato between '2012-07-01' AND '2012-12-31';";
            ResultSet componentes = new Leitor().retornoConsultas(consulta);
            while (componentes.next()) {
                if (!emailNovo.contains(componentes.getString("desenvolvedor_email"))) {
                    emailNovo.add(componentes.getString("desenvolvedor_email"));
                }
            }

            consulta = "SELECT DISTINCT desenvolvedor_email FROM solucao WHERE dataProposta between '2012-07-01' AND '2012-12-31';";
            componentes = new Leitor().retornoConsultas(consulta);
            while (componentes.next()) {
                if (!emailNovo.contains(componentes.getString("desenvolvedor_email"))) {
                    emailNovo.add(componentes.getString("desenvolvedor_email"));
                }
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        List emailVelho = new ArrayList();
        try {
            String consulta = "SELECT DISTINCT desenvolvedor_email FROM problema WHERE dataRelato between '2009-01-01' AND '2012-06-31';";
            ResultSet componentes = new Leitor().retornoConsultas(consulta);
            while (componentes.next()) {
                if (!emailVelho.contains(componentes.getString("desenvolvedor_email"))) {
                    emailVelho.add(componentes.getString("desenvolvedor_email"));
                }
            }

            consulta = "SELECT DISTINCT desenvolvedor_email FROM solucao WHERE dataProposta between '2009-01-01' AND '2012-06-31';";
            componentes = new Leitor().retornoConsultas(consulta);
            while (componentes.next()) {
                if (!emailVelho.contains(componentes.getString("desenvolvedor_email"))) {
                    emailVelho.add(componentes.getString("desenvolvedor_email"));
                }
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        List novosEmail = new ArrayList<>();
        for (Object e : emailVelho) {
            if (!emailNovo.contains(e)) {
                novosEmail.add(e);
            }
        }

        for (Object i : novosEmail) {
            int count = 0;
            try {
                String consulta = "SELECT desenvolvedor_email FROM problema WHERE dataRelato between '2009-01-01' AND '2012-06-31';";
                ResultSet componentes = new Leitor().retornoConsultas(consulta);
                while (componentes.next()) {
                    if (i.equals(componentes.getString("desenvolvedor_email"))) {
                        count++;
                    }
                }

                consulta = "SELECT desenvolvedor_email FROM solucao WHERE dataProposta between '2009-01-01' AND '2012-06-31';";
                componentes = new Leitor().retornoConsultas(consulta);
                while (componentes.next()) {
                    if (i.equals(componentes.getString("desenvolvedor_email"))) {
                        count++;
                    }
                }

            } catch (SQLException ex) {
                System.out.println(ex);
            }
            System.out.println(i + " - " + count);
        }

//        List<Usuario> ambosEmailIssue = new ArrayList();
//
//        for (Usuario usuario : novosN) {
//            for (Object no : novosEmail) {
//                if (usuario.getConta().getEmail().equals(no) && !ambosEmailIssue.contains(usuario)) {
//                    ambosEmailIssue.add(usuario);
//                }
//            }
//        }
//
//        for (Usuario object : ambosEmailIssue) {
//            System.out.println(object.getConta().getEmail());
//        }
    }

}
