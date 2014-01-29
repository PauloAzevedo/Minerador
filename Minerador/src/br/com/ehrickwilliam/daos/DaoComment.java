/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ehrickwilliam.daos;

import br.com.ehrickwilliam.model.Comment;
import br.com.ehrickwilliam.model.Issue;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Erick
 */
public class DaoComment extends DaoGenerics<Comment> {

    public DaoComment() {
        super.alvo = Comment.class;
    }

    public List<Comment> obterPorIssue(Issue issue) {
        List<Comment> lista = null;
        if (issue != null) {

            Query query = session.createQuery("From "
                    + alvo.getSimpleName()
                    + " where issue.issue = '"
                    + issue.getIssue() + "' ORDER BY id ASC");
            lista = query.list();

        }
        return lista;
    }

}
