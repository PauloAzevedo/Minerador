/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ehrickwilliam.teste;

import java.io.File;
import java.io.IOException;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

public class ShowLog {

    public static void main(String[] args) throws IOException, GitAPIException {
        FileRepositoryBuilder builder = new FileRepositoryBuilder();
        Repository repository = builder.setGitDir(new File("C:\\Users\\Erick\\Documents\\GitHub\\core\\.git"))
                .readEnvironment()
                .findGitDir()
                .build();

        Git git = new Git(repository);
        ObjectId head = repository.resolve(Constants.HEAD);
        
        Iterable<RevCommit> commits = git.log().addPath("cppcanvas/source/mtfrenderer/emfplus.cxx").call();
       
        int count = 0;
        for (RevCommit commit : commits) {
            System.out.println("Nome: " + commit.getAuthorIdent().getEmailAddress());
            System.out.println("Nome: " + commit.getShortMessage());
            count++;
        }
        System.out.println(count);

        repository.close();
    }
}
