/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ehrickwilliam.main;

import br.com.ehrickwilliam.gui.JFramePrincipal;

/**
 *
 * @author ehrick
 */
public class Main {
 
        /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFramePrincipal principal = new JFramePrincipal();
                principal.setLocationRelativeTo(null);
                principal.setVisible(true);
            }
        });
    }
}
