/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ehrickwilliam.daos;

import br.com.ehrickwilliam.model.Usuarios;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Erick
 */
public class DaoUsuarios extends DaoGenerics<Usuarios> {

    public DaoUsuarios() {
        super.alvo = Usuarios.class;
    }

    public List<Usuarios> obterNome(String text) {
        List<Usuarios> lista = null;
        if (text != null || !"".equals(text)) {

            Query query = session.createQuery("From "
                    + alvo.getSimpleName()
                    + " where email LIKE '"
                    + text + "%' ORDER BY contribuicao DESC");
            lista = query.list();

        }
        return lista;
    }

    public List<Usuarios> obterTodos() {
        List<Usuarios> lista = null;

        Query query = session.createQuery("From "
                + alvo.getSimpleName()
                + " ORDER BY contribuicao DESC");
        lista = query.list();

        return lista;
    }
}
