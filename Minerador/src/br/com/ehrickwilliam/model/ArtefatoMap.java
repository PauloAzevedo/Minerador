/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ehrickwilliam.model;

import br.com.ehrickwilliam.daos.DaoComponente;
import java.util.List;

/**
 *
 * @author Erick
 */
public class ArtefatoMap {

    public static String verificarComponenteDoArtefato(String diretorio) {
        
        List<Componente> obterPorComponete = new DaoComponente().obterPorComponete("Calc");
        for (Diretorio dir : obterPorComponete.get(0).getDiretorio()) {
            if(dir.getUrl().contains(diretorio)){
                return obterPorComponete.get(0).getNome();
            }
        }
        return null;
    }
}
