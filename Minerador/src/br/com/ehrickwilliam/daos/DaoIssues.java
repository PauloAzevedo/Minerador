/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ehrickwilliam.daos;

import br.com.ehrickwilliam.model.Issue;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Erick
 */
public class DaoIssues extends DaoGenerics<Issue> {

    public DaoIssues() {
        super.alvo = Issue.class;
    }

    public List<Issue> obterPorComponente(String text) {
        List<Issue> lista = null;
        if (text != null || !"".equals(text)) {

            Query query = session.createQuery("From "
                    + alvo.getSimpleName()
                    + " where ferramenta LIKE '"
                    + text + "%' ORDER BY ferramenta ASC");
            lista = query.list();

        }
        return lista;
    }

    public List<Issue> obterDataInicial(Calendar inicio, Calendar fim) {
         SimpleDateFormat formatadorLocal = new SimpleDateFormat("yyyy-MM-dd");
        String in = formatadorLocal.format(inicio.getTime());
        String fi = formatadorLocal.format(fim.getTime());
        List<Issue> lista = null;
            Query query = session.createQuery("From "
                    + alvo.getSimpleName()
                    + " where submittedOn BETWEEN '"+in+"' AND '"+fi+"' ORDER BY ferramenta ASC");
            lista = query.list();
        return lista;
    }


}
