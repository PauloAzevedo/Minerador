/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ehrickwilliam.daos;

import br.com.ehrickwilliam.model.Usuario;
import br.com.ehrickwilliam.model.Usuarios;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Erick
 */
public class DaoUsuario extends DaoGenerics<Usuario> {

    public DaoUsuario() {
        super.alvo = Usuario.class;
    }


    public List<Usuario> obterPorEmail(String text) {
        List<Usuario> lista = null;
        if (text != null || !"".equals(text)) {

            Query query = session.createQuery("From "
                    + alvo.getSimpleName()
                    + " where conta.email LIKE '"
                    + text + "%'");
            lista = query.list();

        }
        return lista;
    }
}
