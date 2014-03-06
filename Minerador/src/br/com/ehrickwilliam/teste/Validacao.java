/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ehrickwilliam.teste;

import br.com.ehrickwilliam.conexao.HibernateConfiguration;
import br.com.ehrickwilliam.daos.DaoComment;
import br.com.ehrickwilliam.daos.DaoIssues;
import br.com.ehrickwilliam.model.Comment;
import br.com.ehrickwilliam.model.Issue;
import br.com.ehrickwilliam.model.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Erick
 */
public class Validacao {

    public static void main(String[] args) {
        HibernateConfiguration.setBase("minerador");
        HibernateConfiguration.setHost("localhost");
        HibernateConfiguration.setUser("root");
        HibernateConfiguration.setPass("root");

        String[] novatos = new String[]{
            "commerce@traduction.biz",
            "kami911@gmail.com",
            "netrolller.3d@gmail.com",
            "jesus@softcatala.org",
            "dezsiszabi@hotmail.com",
            "sebastian@sspaeth.de",
            "pjacquod@alumni.ethz.ch",
            "robert@openbsd.org"
        };

        List<Comment> listarComment = new ArrayList<>();

        for (int i = 0; i < novatos.length; i++) {
            List<Issue> obterPorEmail = new DaoIssues().obterPorEmail(novatos[i]);

            for (Issue issue : obterPorEmail) {
                System.out.println("Issue ID " + issue.getIssue() + " Submitted By: " + novatos[i] + " Assigned To: " + issue.getAssignedTo().getConta().getEmail() + " Assigne value: "+new DaoIssues().count(issue.getAssignedTo().getConta().getEmail()));
                System.out.println("--Respostas--");

                {

                    List<Comment> obterPorIssue = new DaoComment().obterPorIssue(issue);
                    for (Comment comment : obterPorIssue) {
                        listarComment.add(comment);
                    }

                    List usuariosRespostas = new ArrayList();
                    List<String> email = new ArrayList<>();
                    for (Comment comm : listarComment) {
                        int count = 0;
                        for (Comment comm2 : listarComment) {
                            if (comm.getCommitedBy().equals(comm2.getCommitedBy())) {
                                count++;
                            }
                        }
                        Object[] user = new Object[]{comm.getCommitedBy(), count};

                        if (!email.contains(comm.getCommitedBy().getConta().getEmail())) {
                            email.add(comm.getCommitedBy().getConta().getEmail());
                            usuariosRespostas.add(user);
                        }
                    }

                    for (Object object : usuariosRespostas) {
                        Object[] c = (Object[]) object;
                        Usuario co = (Usuario) c[0];
                        int count = (int) c[1];
                        System.out.println(co.getConta().getEmail() + " interagiu " + count + "" + (count > 1 ? " vezes" : " vez"));
                    }
                }
                System.out.println("");
            }
        }

    }
}
