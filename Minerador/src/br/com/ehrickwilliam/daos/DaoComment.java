/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ehrickwilliam.daos;

import br.com.ehrickwilliam.model.Comment;

/**
 *
 * @author Erick
 */
public class DaoComment extends DaoGenerics<Comment> {

    public DaoComment() {
        super.alvo = Comment.class;
    }

}
