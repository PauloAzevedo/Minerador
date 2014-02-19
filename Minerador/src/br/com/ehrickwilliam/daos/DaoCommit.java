/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ehrickwilliam.daos;

import br.com.ehrickwilliam.bibliotecas.Util;
import br.com.ehrickwilliam.model.Commit;
import br.com.ehrickwilliam.model.Issue;
import java.text.SimpleDateFormat;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Erick
 */
public class DaoCommit extends DaoGenerics<Commit> {

    public DaoCommit() {
        super.alvo = Commit.class;
    }

    public List<Commit> obterPorData(String inicio, String fim) {
        List<Commit> lista = null;

            String primeiroRegistro = "03/08/2010";
            String segundoRegistro = "31/12/2012";
            SimpleDateFormat formatadorLocal = new SimpleDateFormat("yyyy-MM-dd");
            String in = "";
            String fi = "";
            if (!inicio.equals("  /  /    ") && !fim.equals("  /  /    ")) {
                in = formatadorLocal.format(Util.stringToCalendar(inicio).getTime());
                fi = formatadorLocal.format(Util.stringToCalendar(fim).getTime());
            } else if(inicio.equals("  /  /    ") && !fim.equals("  /  /    ")){
                in = formatadorLocal.format(Util.stringToCalendar(primeiroRegistro).getTime());
                fi = formatadorLocal.format(Util.stringToCalendar(fim).getTime());
            }else if (!inicio.equals("  /  /    ") && fim.equals("  /  /    ")) {
                in = formatadorLocal.format(Util.stringToCalendar(inicio).getTime());
                fi = formatadorLocal.format(Util.stringToCalendar(segundoRegistro).getTime());
            } else{
                in = formatadorLocal.format(Util.stringToCalendar(primeiroRegistro).getTime());
                fi = formatadorLocal.format(Util.stringToCalendar(segundoRegistro).getTime());
            }

            Query query = session.createQuery("From "
                    + alvo.getSimpleName()
                    + " where date BETWEEN '" + in + "' AND '" + fi + "' ORDER BY id ASC");
            lista = query.list();

        return lista;
    }
}
