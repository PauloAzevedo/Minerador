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
import br.com.ehrickwilliam.model.Usuarios;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
            "lbalbalba@gmail.com"
        };

        List<Comment> listarComment = new ArrayList<>();

        for (int i = 0; i < novatos.length; i++) {
            List<Issue> obterPorEmail = new DaoIssues().obterPorEmail(novatos[i]);

            for (Issue issue : obterPorEmail) {
                System.out.println("Issue ID " + issue.getIssue() + " Componente: "+issue.getFerramenta()+" Submitted By: " + novatos[i] + " Assigned To: " + issue.getAssignedTo().getConta().getEmail() + " Assigne value: " + new DaoIssues().count(issue.getAssignedTo().getConta().getEmail()));
                System.out.println("--Respostas--");

                {

                    List<Comment> obterPorIssue = new DaoComment().obterPorIssue(issue);
                    for (Comment comment : obterPorIssue) {
                        listarComment.add(comment);
                    }

                    List<UsuariosComments> usuariosRespostas = new ArrayList();
                    List<String> email = new ArrayList<>();
                    for (Comment comm : listarComment) {
                        int count = 0;
                        for (Comment comm2 : listarComment) {
                            if (comm.getCommitedBy().equals(comm2.getCommitedBy()) && !comm.getCommitedBy().getConta().getEmail().equals(novatos[i])) {
                                count++;
                            }
                        }
                        UsuariosComments user = new UsuariosComments(comm.getCommitedBy(), count);

                        if (!email.contains(comm.getCommitedBy().getConta().getEmail()) && !comm.getCommitedBy().getConta().getEmail().equals(novatos[i])) {
                            email.add(comm.getCommitedBy().getConta().getEmail());
                            usuariosRespostas.add(user);
                        }
                    }

                    Collections.sort(usuariosRespostas, UsuariosComments.POR_TOTAL);
                    Collections.reverse(usuariosRespostas);

                    for (UsuariosComments object : usuariosRespostas) {
                        System.out.println(object.usuario.getConta().getEmail() + " interagiu " + object.total + "" + (object.total > 1 ? " vezes" : " vez"));
                    }
                }
                System.out.println("");
            }
        }

    }
}

class UsuariosComments {

    Usuario usuario;
    Integer total;

    public static final Comparator<UsuariosComments> POR_TOTAL = new Comparator<UsuariosComments>() {

        @Override
        public int compare(UsuariosComments t, UsuariosComments t1) {
            return t.total.compareTo(t1.total);
        }
    };

    public UsuariosComments(Usuario usuario, int total) {
        this.usuario = usuario;
        this.total = total;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

}
