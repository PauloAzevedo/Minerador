/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ehrickwilliam.bibliotecas;

import br.com.ehrickwilliam.conexao.Conexao;
import br.com.ehrickwilliam.conexao.HibernateConfiguration;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

/**
 *
 * @author ehrick
 */
public class Leitor {

    private List<String> emails;

    public Leitor() {
      
    }

    public ResultSet retornoConsultas(String sql) throws SQLException {

        Connection conexao;
        conexao = Conexao.getConnection();
        conexao.createStatement().execute("use " + HibernateConfiguration.getBase());
        return conexao.createStatement().executeQuery(sql);

    }

    public void listarUsuarios() throws SQLException, IOException, GitAPIException {
       
        emails = new ArrayList();
        ResultSet retornoConsultaPessoas = retornoConsultas("select email FROM people ORDER BY email ASC;");

        while (retornoConsultaPessoas.next()) {
            String email = retornoConsultaPessoas.getString("email");
            if (!this.emails.contains(email)) {
                this.emails.add(email);
            }
        }
        
        FileRepositoryBuilder builder = new FileRepositoryBuilder();
        Repository repository = builder.setGitDir(new File("C:\\Users\\ehrick\\Documents\\GitHub\\core\\.git"))
                .readEnvironment()
                .findGitDir()
                .build();

        Git git = new Git(repository);
        ObjectId head = repository.resolve(Constants.HEAD);
        
        Iterable<RevCommit> commits = git.log().all().call();
       
       
        for (RevCommit commit : commits) {
            
             String email = commit.getAuthorIdent().getEmailAddress();
            if (!this.emails.contains(email)) {
                this.emails.add(email);
            }
        }
      

        repository.close();
    }

    public List<String> getEmails() {
        return emails;
    }
}
