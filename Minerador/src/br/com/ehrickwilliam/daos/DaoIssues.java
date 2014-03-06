/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ehrickwilliam.daos;

import br.com.ehrickwilliam.bibliotecas.Util;
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

    public List<Issue> obterPorComponente(String text, String inicio, String fim) {
        List<Issue> lista = null;
        if (text != null || !"".equals(text)) {
            String primeiroRegistro = "03/08/2010";
            String segundoRegistro = "31/12/2012";
            SimpleDateFormat formatadorLocal = new SimpleDateFormat("yyyy-MM-dd");
            String in = "";
            String fi = "";
            if (!inicio.equals("  /  /    ") && !fim.equals("  /  /    ")) {
                in = formatadorLocal.format(Util.stringToCalendar(inicio).getTime());
                fi = formatadorLocal.format(Util.stringToCalendar(fim).getTime());
            } else if (inicio.equals("  /  /    ") && !fim.equals("  /  /    ")) {
                in = formatadorLocal.format(Util.stringToCalendar(primeiroRegistro).getTime());
                fi = formatadorLocal.format(Util.stringToCalendar(fim).getTime());
            } else if (!inicio.equals("  /  /    ") && fim.equals("  /  /    ")) {
                in = formatadorLocal.format(Util.stringToCalendar(inicio).getTime());
                fi = formatadorLocal.format(Util.stringToCalendar(segundoRegistro).getTime());
            } else {
                in = formatadorLocal.format(Util.stringToCalendar(primeiroRegistro).getTime());
                fi = formatadorLocal.format(Util.stringToCalendar(segundoRegistro).getTime());
            }

            Query query = session.createQuery("From "
                    + alvo.getSimpleName()
                    + " where ferramenta LIKE '"
                    + text + "%' AND submittedOn BETWEEN '" + in + "' AND '" + fi + "' ORDER BY ferramenta ASC");
            lista = query.list();

        }
        return lista;
    }

    public List<Issue> obterData(Calendar inicio, Calendar fim) {
        String primeiroRegistro = "03/08/2010";
        String segundoRegistro = "03/08/2010";
        SimpleDateFormat formatadorLocal = new SimpleDateFormat("yyyy-MM-dd");
        String in = formatadorLocal.format(inicio.getTime());
        String fi = formatadorLocal.format(fim.getTime());

        primeiroRegistro = formatadorLocal.format(Util.stringToCalendar(primeiroRegistro).getTime());
        segundoRegistro = formatadorLocal.format(Util.stringToCalendar(segundoRegistro).getTime());

        List<Issue> lista = null;
        Query query = session.createQuery("From "
                + alvo.getSimpleName()
                + " where submittedOn BETWEEN '" + in + "' AND '" + fi + "' ORDER BY ferramenta ASC");
        lista = query.list();
        return lista;
    }

    public List<Issue> obterPorEmail(String email) {

        List<Issue> lista = null;
        Query query = session.createQuery("From "
                + alvo.getSimpleName()
                + " where submittedBy.conta.email = '" + email + "'");
        lista = query.list();
        return lista;
    }
    
        public Long count(String email) {
        Query query = session.createQuery("select count(*) from "
                + alvo.getSimpleName()
                + " where assignedTo.conta.email = '"+email+"'");
        return (Long) query.uniqueResult();
    }

}
