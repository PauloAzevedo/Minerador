/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ehrickwilliam.daos;

import br.com.ehrickwilliam.model.Issue;

/**
 *
 * @author Erick
 */
public class DaoIssues extends DaoGenerics<Issue> {

    public DaoIssues() {
        super.alvo = Issue.class;
    }
}
