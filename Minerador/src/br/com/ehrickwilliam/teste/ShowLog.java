/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ehrickwilliam.teste;

import br.com.ehrickwilliam.conexao.HibernateConfiguration;
import br.com.ehrickwilliam.daos.DaoCommit;
import br.com.ehrickwilliam.model.ArtefatoMap;
import br.com.ehrickwilliam.model.Commit;
import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;
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

public class ShowLog {

    private static List<Commit> commits;

    public static void main(String[] args) throws IOException, GitAPIException {
                HibernateConfiguration.setBase("minerador");
        HibernateConfiguration.setHost("localhost");
        HibernateConfiguration.setUser("root");
        HibernateConfiguration.setPass("root");
        FileRepositoryBuilder builder = new FileRepositoryBuilder();
        Repository repository = builder.setGitDir(new File("D:\\Nova pasta\\GitHub\\core\\.git"))
                .readEnvironment()
                .findGitDir()
                .build();
        commits = new DaoCommit().listar("", "id");
        for (Commit string : commits) {
            System.out.println("ARQUIVOS DO COMMIT ID: " + string.getCommit());
            ObjectId revid = repository.resolve(string.getCommit());
            RevWalk revWalk = new RevWalk(repository);
            RevCommit commit = revWalk.parseCommit(revid);

//            RevTree tree = commit.getTree();
//            TreeWalk treeWalk = new TreeWalk(repository);
//            treeWalk.addTree(tree);
//            treeWalk.setRecursive(true);
//            
//            treeWalk.setFilter(PathFilter.create("CppunitTest_basic_coverage.mk"));
//            while (treeWalk.next()) {
//                System.out.println(treeWalk.getPathString());
//            }
            RevWalk rw = new RevWalk(repository);

            RevCommit parent = rw.parseCommit(commit.getParent(0).getId());
            DiffFormatter df = new DiffFormatter(DisabledOutputStream.INSTANCE);
            df.setRepository(repository);
            df.setDiffComparator(RawTextComparator.DEFAULT);
            df.setDetectRenames(true);
            List<DiffEntry> diffs = df.scan(parent.getTree(), commit.getTree());

            for (DiffEntry diff : diffs) {
                //System.out.println(MessageFormat.format("({0} {1} {2})", diff.getChangeType().name(), diff.getNewMode().getBits(), diff.getNewPath()));
                String[] split = diff.getNewPath().split("/");
                System.out.println(ArtefatoMap.verificarComponenteDoArtefato(split[0]));    
            }
        }

    }
}
