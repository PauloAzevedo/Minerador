/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ehrickwilliam.teste;

import br.com.ehrickwilliam.conexao.HibernateConfiguration;
import br.com.ehrickwilliam.daos.DaoComponente;
import br.com.ehrickwilliam.daos.DaoDiretorio;
import br.com.ehrickwilliam.model.Componente;
import br.com.ehrickwilliam.model.Diretorio;
import java.util.List;

/**
 *
 * @author ehrick
 */
public class TesteComponente {
    
    public static void main(String[] args) {
        HibernateConfiguration.setBase("minerador");
        HibernateConfiguration.setHost("localhost");
        HibernateConfiguration.setUser("root");
        HibernateConfiguration.setPass("root");
//        
//        Componente c1 = new Componente();
//        c1.setNome("Database");
//        Componente c2 = new Componente();
//        c2.setNome("Basic");
//        Componente c3 = new Componente();
//        c3.setNome("Access2Base");
//        Componente c4 = new Componente();
//        c4.setNome("Build System");
//        Componente c5 = new Componente();
//        c5.setNome("Calc");
//        Componente c6 = new Componente();
//        c6.setNome("Debian");
//        Componente c7 = new Componente();
//        c7.setNome("Dictionaries");
//        Componente c8 = new Componente();
//        c8.setNome("Documentation");
//        Componente c9 = new Componente();
//        c9.setNome("Experimental");
//        Componente c10 = new Componente();
//        c10.setNome("Extensions Website");
//        Componente c11 = new Componente();
//        c11.setNome("General UI problems");
//        Componente c12 = new Componente();
//        c12.setNome("Writer RTF");
//        Componente c13 = new Componente();
//        c13.setNome("Gerrit");
//        Componente c14 = new Componente();
//        c14.setNome("GUI");
//        Componente c15 = new Componente();
//        c15.setNome("Headless");
//        Componente c16 = new Componente();
//        c16.setNome("i18nlangtag");
//        Componente c17 = new Componente();
//        c17.setNome("Impress");
//        Componente c18 = new Componente();
//        c18.setNome("KDE");
//        Componente c19 = new Componente();
//        c19.setNome("Bugzilla Submission");
//        Componente c20 = new Componente();
//        c20.setNome("Libcdr");
//        Componente c21 = new Componente();
//        c21.setNome("Libvisio");
//        Componente c22 = new Componente();
//        c22.setNome("Localization");
//        Componente c23 = new Componente();
//        c23.setNome("Mac");
//        Componente c24 = new Componente();
//        c24.setNome("MozTrap");
//        Componente c25 = new Componente();
//        c25.setNome("ODF filter");
//        Componente c26 = new Componente();
//        c26.setNome("PostgreSQL");
//        Componente c27 = new Componente();
//        c27.setNome("Ubuntu");
//        Componente c28 = new Componente();
//        c28.setNome("UNO");
//        Componente c29 = new Componente();
//        c29.setNome("vcl");
//        Componente c30 = new Componente();
//        c30.setNome("Wiki Help Page");
//        Componente c31 = new Componente();
//        c31.setNome("Windows");
//        Componente c32 = new Componente();
//        c32.setNome("Windows Installer");
//        Componente c33 = new Componente();
//        c33.setNome("UNO");
//        Componente c34 = new Componente();
//        c34.setNome("vcl");
//        Componente c35 = new Componente();
//        c35.setNome("X11-specific");
//
//
//        
//        new DaoComponente().persistir(c1);
//        new DaoComponente().persistir(c2);
//        new DaoComponente().persistir(c3);
//        new DaoComponente().persistir(c4);
//        new DaoComponente().persistir(c5);
//        new DaoComponente().persistir(c6);
//        new DaoComponente().persistir(c7);
//        new DaoComponente().persistir(c8);
//        new DaoComponente().persistir(c9);
//        new DaoComponente().persistir(c10);
//        new DaoComponente().persistir(c11);
//        new DaoComponente().persistir(c12);
//        new DaoComponente().persistir(c13);
//        new DaoComponente().persistir(c14);
//        new DaoComponente().persistir(c15);
//        new DaoComponente().persistir(c16);
//        new DaoComponente().persistir(c17);
//        new DaoComponente().persistir(c18);
//        new DaoComponente().persistir(c19);
//        new DaoComponente().persistir(c20);
//        new DaoComponente().persistir(c21);
//        new DaoComponente().persistir(c22);
//        new DaoComponente().persistir(c23);
//        new DaoComponente().persistir(c24);
//        new DaoComponente().persistir(c25);
//        new DaoComponente().persistir(c26);
//        new DaoComponente().persistir(c27);
//        new DaoComponente().persistir(c28);
//        new DaoComponente().persistir(c29);
//        new DaoComponente().persistir(c30);
//        new DaoComponente().persistir(c31);
//        new DaoComponente().persistir(c32);
//        new DaoComponente().persistir(c33);
//        new DaoComponente().persistir(c34);
//        new DaoComponente().persistir(c35);
//
        List<Diretorio> retornoUrl = new DaoDiretorio().retornoUrl("comphelper/","configmgr/","cppu/","cppuhelper/","cpputools/");
        List<Componente> obterPorComponete = new DaoComponente().obterPorComponete("Uno");
        obterPorComponete.get(0).setDiretorio(retornoUrl);

        new DaoComponente().persistir(obterPorComponete.get(0));

    }
    
    
}
