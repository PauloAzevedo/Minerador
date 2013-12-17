/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ehrickwilliam.gui;

import br.com.ehrickwilliam.bibliotecas.Leitor;
import br.com.ehrickwilliam.bibliotecas.Util;
import br.com.ehrickwilliam.conexao.Data;
import br.com.ehrickwilliam.conexao.HibernateConfiguration;
import br.com.ehrickwilliam.daos.DaoUsuarios;
import br.com.ehrickwilliam.model.Usuarios;
import java.awt.Cursor;
import static java.lang.Thread.sleep;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author Erick
 */
public class JDialogLoading extends javax.swing.JDialog {

    /**
     * Creates new form JDialogCadastroClienteFisico
     *
     * @param parent
     * @param modal
     */
    private final Leitor leitor;
    private List<Usuarios> usuariosContribuicoes;
    private int STOP_BUTTON;
    public JDialogLoading(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.STOP_BUTTON = 0;
        initComponents();
        leitor = new Leitor();
        try {
            leitor.listarUsuarios();
        } catch (SQLException ex) {
            Logger.getLogger(JDialogLoading.class.getName()).log(Level.SEVERE, null, ex);
        }
        jProgressBar.setMaximum(leitor.getEmails().size());
        jProgressBar.setStringPainted(true);
        jProgressBar.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        jButtonExecutar.setVisible(false);

        executar(jButtonExecutar);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelstatus = new javax.swing.JLabel();
        jProgressBar = new javax.swing.JProgressBar();
        jButtonExecutar = new javax.swing.JButton();
        jLabelstatus1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuParar = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(443, 185));
        setMinimumSize(new java.awt.Dimension(443, 185));
        setModal(true);
        setPreferredSize(new java.awt.Dimension(443, 185));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelstatus.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelstatus.setText("Processo iniciado!");
        getContentPane().add(jLabelstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));
        getContentPane().add(jProgressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 380, 20));

        jButtonExecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExecutarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonExecutar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, -1, -1));

        jLabelstatus1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelstatus1.setText("Por favor, aguarde...");
        getContentPane().add(jLabelstatus1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jMenuBar1.setMinimumSize(new java.awt.Dimension(56, 31));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(396, 31));

        jMenuParar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ehrickwilliam/icon/116.png"))); // NOI18N
        jMenuParar.setText("Parar");
        jMenuParar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuPararMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuParar);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonExecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExecutarActionPerformed
        try {
            Object get = Data.hash.get("componente");
            retornoConsulta(get.toString());
        } catch (SQLException ex) {
            Logger.getLogger(JDialogLoading.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonExecutarActionPerformed

    private void jMenuPararMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuPararMouseClicked
        if (Util.mostraMensagemEmTela("Abordar a operação resultará na perca dos dados obtidos até o momento!")) {
           this.STOP_BUTTON = 1;
        }
    }//GEN-LAST:event_jMenuPararMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonExecutar;
    private javax.swing.JLabel jLabelstatus;
    private javax.swing.JLabel jLabelstatus1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenu jMenuParar;
    private javax.swing.JProgressBar jProgressBar;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

    public List<Usuarios> retornoConsulta(String componente) throws SQLException {
        List<Usuarios> usuariosRetornados = new ArrayList();
        Object getUsuario = Data.hash.get("usuario");
        if (getUsuario == null) {
            for (String email : leitor.getEmails()) {
                String consultaCount = "SELECT DISTINCT count(comments.id) as count,people.name as nome FROM "
                        + "issues_ext_bugzilla,issues, people, comments WHERE (people.id = issues.submitted_by "
                        + "OR people.id = issues.assigned_to OR people.id = comments.submitted_by) AND issues.id "
                        + "= comments.issue_id AND issues_ext_bugzilla.issue_id = issues.id AND issues_ext_bugzilla.component = '" + componente + "' AND people.email = '" + email + "'";

                ResultSet retornoConsultaPessoasCount = leitor.retornoConsultaPessoas(consultaCount);
                retornoConsultaPessoasCount.next();

                int count = Integer.parseInt(retornoConsultaPessoasCount.getString("count"));

                Usuarios u = new Usuarios(retornoConsultaPessoasCount.getString("nome"), email, (count + 0.0), componente);
                usuariosRetornados.add(u);
                jProgressBar.setValue(jProgressBar.getValue() + 1);
                jLabelstatus.setText("Processando usuário: " + email + "");
                jLabelstatus1.setText("Total de contribuições: " + count);
                this.setTitle(email);
                new DaoUsuarios().persistir(u);
                
                if(STOP_BUTTON == 1){
                    HibernateConfiguration.criarSchema();
                    this.dispose();
                    break;
                }
            }
        } else {

        }
        return usuariosRetornados;
    }

    public static void executar(final JButton botao) {
        new Thread() {
            @Override
            public void run() {
                int flag = 0;
                while (flag == 0) {

                    try {
                        sleep(3000);
                        botao.doClick();
                        flag = +1;

                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }
        }.start();

    }
}
