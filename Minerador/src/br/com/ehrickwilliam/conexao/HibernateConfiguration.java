/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ehrickwilliam.conexao;


import br.com.ehrickwilliam.model.Artefato;
import br.com.ehrickwilliam.model.Comment;
import br.com.ehrickwilliam.model.Commit;
import br.com.ehrickwilliam.model.Componente;
import br.com.ehrickwilliam.model.Conta;
import br.com.ehrickwilliam.model.Diretorio;
import br.com.ehrickwilliam.model.Issue;
import br.com.ehrickwilliam.model.Usuario;
import br.com.ehrickwilliam.model.Usuarios;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 *
 * @author ehrickwilliam
 */
public class HibernateConfiguration {
    // configuracões somente uma vez 
    // build  valida somente uma vez
    // Session uma sessão para cada transação ou um conjunto de transações

    private static AnnotationConfiguration cfg;
    
    private static SessionFactory sessionFactory;
    
    private static String user;
    private static String pass;
    private static String base;
    private static String host;

    public synchronized static Session openConnect() {
        if (cfg == null) {
            cfg = new AnnotationConfiguration();
            cfg.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
            cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
            cfg.setProperty("hibernate.connection.username", user);
            cfg.setProperty("hibernate.connection.password", pass);
            cfg.setProperty("hibernate.connection.url", "jdbc:mysql://" + host + "/" + base);
            cfg.setProperty("hibernate.show_sql", "true");
            cfg.setProperty("hibernate.connection.autocommit", "true");

            cfg.addAnnotatedClass(Usuario.class);
            cfg.addAnnotatedClass(Commit.class);
            cfg.addAnnotatedClass(Conta.class);
            cfg.addAnnotatedClass(Issue.class);
            cfg.addAnnotatedClass(Comment.class);
            cfg.addAnnotatedClass(Usuarios.class);
            cfg.addAnnotatedClass(Artefato.class);
            cfg.addAnnotatedClass(Diretorio.class);
            cfg.addAnnotatedClass(Componente.class);
            
            
            sessionFactory = cfg.buildSessionFactory();
        }
        
        return sessionFactory.openSession();
    }

    public static AnnotationConfiguration getCfg() {
        return cfg;
    }

    public static void setCfg(AnnotationConfiguration cfg) {
        HibernateConfiguration.cfg = cfg;
    }

    public static String getBase() {
        return base;
    }

    public static void setBase(String base) {
        HibernateConfiguration.base = base;
    }

    public static String getPass() {
        return pass;
    }

    public static void setPass(String pass) {
        HibernateConfiguration.pass = pass;
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        HibernateConfiguration.user = user;
    }

    public static String getHost() {
        return host;
    }

    public static void setHost(String host) {
        HibernateConfiguration.host = host;
    }

    public static void criarSchema() {
        openConnect().close();
        org.hibernate.tool.hbm2ddl.SchemaExport schemaEx = new SchemaExport(cfg);
        schemaEx.create(true, true);
    }

    public static List<Object> runHQLQuery(String hql) {
        Session session = TransactionManager.getCurrentSession();
        return session.createQuery(hql).list();
    }

    public static ArrayList<Class> getEntityClasses() {
        ArrayList<Class> classes = new ArrayList<Class>();
        if (cfg == null) {
            openConnect();
        }
        Iterator i = cfg.getClassMappings();
        while (i.hasNext()) {
            classes.add(((PersistentClass) i.next()).getMappedClass());
        }
        return classes;
    }
}
