/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ehrickwilliam.daos;

import br.com.ehrickwilliam.model.Commit;
import br.com.ehrickwilliam.model.Diretorio;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author ehrick
 */
public class DaoDiretorio extends DaoGenerics<Diretorio> {

    public DaoDiretorio() {
        super.alvo = Diretorio.class;
    }

    public boolean obterUrl(String componente) {

        Query query = session.createQuery("From "
                + alvo.getSimpleName()
                + " where url = '" + componente + "'");
        int total = query.list().size();
        if(total>0){
            return true;
        }else{
            return false;
        }

    }

}
