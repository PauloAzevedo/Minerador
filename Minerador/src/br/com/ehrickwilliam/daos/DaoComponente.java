/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ehrickwilliam.daos;

import br.com.ehrickwilliam.model.Commit;
import br.com.ehrickwilliam.model.Componente;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author ehrick
 */
public class DaoComponente extends DaoGenerics<Componente> {

    public DaoComponente() {
        super.alvo = Componente.class;
    }

    public List<Commit> obterPorComponete(String componente) {
        
        Query query = session.createQuery("From "
                + alvo.getSimpleName()
                + " where nome = '" + componente + "'");
       return query.list();

    }

}