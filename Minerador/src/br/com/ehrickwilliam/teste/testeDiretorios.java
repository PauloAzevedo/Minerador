/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ehrickwilliam.teste;

import br.com.ehrickwilliam.bibliotecas.Util;
import br.com.ehrickwilliam.conexao.HibernateConfiguration;
import br.com.ehrickwilliam.daos.DaoCommit;
import br.com.ehrickwilliam.daos.DaoDiretorio;
import br.com.ehrickwilliam.gui.JDialogImportantoArtefatos;
import br.com.ehrickwilliam.model.Artefato;
import br.com.ehrickwilliam.model.ArtefatoMap;
import br.com.ehrickwilliam.model.Commit;
import br.com.ehrickwilliam.model.Diretorio;
import java.awt.Cursor;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.diff.DiffEntry;
import org.eclipse.jgit.diff.DiffFormatter;
import org.eclipse.jgit.diff.RawTextComparator;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.eclipse.jgit.util.io.DisabledOutputStream;

/**
 *
 * @author ehrick
 */
public class testeDiretorios {

    public static void main(String[] args) {
        
                HibernateConfiguration.setBase("minerador");
        HibernateConfiguration.setHost("localhost");
        HibernateConfiguration.setUser("root");
        HibernateConfiguration.setPass("root");
        
        try {
            FileRepositoryBuilder builder = new FileRepositoryBuilder();
            Repository repository = builder.setGitDir(new File("C:\\Users\\ehrick\\Documents\\GitHub\\core\\.git"))
                    .readEnvironment()
                    .findGitDir()
                    .build();

            Git git = new Git(repository);

            Iterable<RevCommit> commits;

            commits = git.log().all().call();

            for (RevCommit commit : commits) {
                System.out.println(commit.getName());

                List<Artefato> total = new ArrayList();

                ObjectId revid = repository.resolve(commit.getName());
                RevWalk revWalk = new RevWalk(repository);
                RevCommit committ = revWalk.parseCommit(revid);
                RevWalk rw = new RevWalk(repository);
                if (committ.getParentCount() > 0) {
                    RevCommit parent = rw.parseCommit(committ.getParent(0).getId());
                    DiffFormatter df = new DiffFormatter(DisabledOutputStream.INSTANCE);
                    df.setRepository(repository);
                    df.setDiffComparator(RawTextComparator.DEFAULT);
                    df.setDetectRenames(true);
                    List<DiffEntry> diffs = df.scan(parent.getTree(), committ.getTree());

                    for (DiffEntry diff : diffs) {
                        String[] split = diff.getNewPath().split("/");
                        if (split[0] != null && !"".equals(split[0]) && split[0].indexOf(".") == -1) {

                            Diretorio diretorio = new Diretorio();
                            diretorio.setUrl(diff.getNewPath());
                            DaoDiretorio daoD = new DaoDiretorio();
                            
                            if(!daoD.obterUrl(diff.getNewPath())){
                                daoD.persistir(diretorio);
                            }
                        }
                    }
                }

            }
            repository.close();
        } catch (IOException ex) {
            Logger.getLogger(testeDiretorios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (GitAPIException ex) {
            Logger.getLogger(testeDiretorios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
