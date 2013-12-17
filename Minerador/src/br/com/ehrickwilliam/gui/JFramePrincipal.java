/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ehrickwilliam.gui;

import br.com.ehrickwilliam.bibliotecas.Leitor;
import br.com.ehrickwilliam.bibliotecas.Util;
import br.com.ehrickwilliam.conexao.Data;
import br.com.ehrickwilliam.conexao.HibernateConfiguration;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author ehrick
 */
public class JFramePrincipal extends javax.swing.JFrame {

    /**
     * Creates new form JFramePrincipal
     */
    public JFramePrincipal() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception ex) {
            System.out.println(ex);
        }
        initComponents();
       
        jTextFieldNome.setEnabled(false);
        HibernateConfiguration.setBase("bicho");
        HibernateConfiguration.setHost("localhost");
        HibernateConfiguration.setUser("root");
        HibernateConfiguration.setPass("root");
        popularComboBox();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jFormattedTextFieldCpf = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jFormattedTextFieldCpf1 = new javax.swing.JFormattedTextField();
        jCheckBoxUser = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jComboBoxComponente = new javax.swing.JComboBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuSalvar = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Minerador de Dados");
        setMaximumSize(new java.awt.Dimension(655, 265));
        setMinimumSize(new java.awt.Dimension(655, 265));
        setPreferredSize(new java.awt.Dimension(655, 265));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel1.setText("E-mail do usuário:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, 10));

        jTextFieldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 260, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel4.setText("Data Inicíal (não informar utilizara a data da 1º interação) :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        try {
            jFormattedTextFieldCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(jFormattedTextFieldCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 260, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel5.setText("Data Final (não informar utilizara a data da ultima interação):");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, -1, -1));

        try {
            jFormattedTextFieldCpf1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldCpf1.setText("31/12/2012");
        getContentPane().add(jFormattedTextFieldCpf1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 300, -1));

        jCheckBoxUser.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jCheckBoxUser.setSelected(true);
        jCheckBoxUser.setText("Executar para todos os usuários");
        jCheckBoxUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxUserActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBoxUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel2.setText("Informe o nome do componente:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, 10));

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jRadioButton1.setText("GitHub");
        jRadioButton1.setEnabled(false);
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 40, -1, -1));

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jRadioButton2.setSelected(true);
        jRadioButton2.setText("Mysql");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 40, -1, -1));

        jComboBoxComponente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBoxComponente, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 260, -1));

        jMenuBar1.setMinimumSize(new java.awt.Dimension(56, 31));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(396, 31));

        jMenuSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ehrickwilliam/icon/006.png"))); // NOI18N
        jMenuSalvar.setText("Iniciar");
        jMenuSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuSalvarMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuSalvar);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuSalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuSalvarMouseClicked
        if (jComboBoxComponente.getSelectedIndex() != -1 && jCheckBoxUser.isSelected()) {
            Data.hash.put("componente", jComboBoxComponente.getSelectedItem());
            Util.abrirDialogCentralizado(new JDialogLoading(this, true));
        } else if(jComboBoxComponente.getSelectedIndex() != -1 && !jCheckBoxUser.isSelected() && !jTextFieldNome.getText().isEmpty()) {
            Data.hash.put("componente", jComboBoxComponente.getSelectedItem());
            Data.hash.put("usuario", jTextFieldNome.getText());
            Util.abrirDialogCentralizado(new JDialogLoading(this, true));
        }else{
            JOptionPane.showMessageDialog(this, "O campo Componente ou Usuário \nprecisa ser preenchido!");
        }
    }//GEN-LAST:event_jMenuSalvarMouseClicked

    private void jCheckBoxUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxUserActionPerformed
        // TODO add your handling code here:
        if (jCheckBoxUser.isSelected()) {
            jTextFieldNome.setEnabled(false);
        } else {
            jTextFieldNome.setEnabled(true);
        }
    }//GEN-LAST:event_jCheckBoxUserActionPerformed

    private void jTextFieldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        jLabel2.setText("Informe o caminho do artefato:");
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        jLabel2.setText("Informe o nome do componente:");
    }//GEN-LAST:event_jRadioButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox jCheckBoxUser;
    private javax.swing.JComboBox jComboBoxComponente;
    private javax.swing.JFormattedTextField jFormattedTextFieldCpf;
    private javax.swing.JFormattedTextField jFormattedTextFieldCpf1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuSalvar;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField jTextFieldNome;
    // End of variables declaration//GEN-END:variables

    private void popularComboBox() {

        String consulta = "SELECT DISTINCT component FROM issues_ext_bugzilla ORDER BY component ASC";
        try {
            ResultSet componentes = new Leitor().retornoConsultaPessoas(consulta);
            jComboBoxComponente.removeAllItems();
            while(componentes.next()){
                jComboBoxComponente.addItem(componentes.getString("component"));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }
}
