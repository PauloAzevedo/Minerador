/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ehrickwilliam.daos;

import br.com.ehrickwilliam.model.Artefato;

/**
 *
 * @author Erick
 */
public class DaoArtefato extends DaoGenerics<Artefato>{
    
        public DaoArtefato() {
        super.alvo = Artefato.class;
    }
}
