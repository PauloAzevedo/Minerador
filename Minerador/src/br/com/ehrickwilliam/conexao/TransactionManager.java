/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ehrickwilliam.conexao;

import org.hibernate.FlushMode;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ehrickwilliam
 */
public class TransactionManager {

    private static Session session = null;
    
    static Transaction transaction = null;

    public static void beginTransaction() {
        if (transaction != null) {
            //throw new RuntimeException("Já existe uma transação iniciada.");
            getCurrentSession();
        } else {
            session = HibernateConfiguration.openConnect();
            transaction = session.beginTransaction();
        }
    }

    public static void commit() {
        if (transaction == null) {
            //throw new RuntimeException("Erro tentando executar commit() sem antes ter executado beginTrans()..");
            beginTransaction();
            transaction.commit();
        } else {
            transaction.commit();
            closeCurrentSession();
        }

    }

    public static void rollback() {
        if (transaction == null) {
            throw new RuntimeException("Erro tentando executar rollback() sem antes ter executado beginTrans()..");
        }
        transaction.rollback();
        closeCurrentSession();
    }

    public synchronized static Session getCurrentSession() {
        /*Automatizando a criação da transação.*/
        if (session == null) {
            Session session2 = HibernateConfiguration.openConnect();
            // System.out.println("========================="+session2.getFlushMode());
            session2.setFlushMode(FlushMode.ALWAYS);
            session = session2;
        }
        return session;
    }

    public synchronized static void closeCurrentSession() {
        if (session != null) {
            session.flush();
            session.close();
            transaction = null;
            session = null;
        }
    }
}
