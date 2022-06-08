/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TELA;

import BEAN.Login_bean;
import CONEXAO.Conexao;
import DAO.Login_dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author joaom
 */
public class Jlogin extends javax.swing.JFrame {

    /**
     * Creates new form Jlogin
     */
    public Jlogin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Caixa_login = new javax.swing.JTextPane();
        jLabel4 = new javax.swing.JLabel();
        Caixa_senha = new javax.swing.JPasswordField();
        Botton_entrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(235, 235, 235));
        setMinimumSize(new java.awt.Dimension(450, 700));
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel2.setText("MotiON");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(150, 70, 130, 43);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Usuario:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 230, 60, 17);

        Caixa_login.setBackground(new java.awt.Color(255, 255, 255));
        Caixa_login.setBorder(null);
        Caixa_login.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        Caixa_login.setCaretColor(new java.awt.Color(255, 255, 255));
        Caixa_login.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Caixa_login.setMinimumSize(new java.awt.Dimension(0, 25));
        Caixa_login.setPreferredSize(new java.awt.Dimension(0, 25));
        Caixa_login.setSelectionColor(new java.awt.Color(255, 255, 255));
        getContentPane().add(Caixa_login);
        Caixa_login.setBounds(30, 250, 370, 25);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Senha:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 300, 60, 17);

        Caixa_senha.setBackground(new java.awt.Color(255, 255, 255));
        Caixa_senha.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        Caixa_senha.setBorder(null);
        Caixa_senha.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Caixa_senha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Caixa_senhaActionPerformed(evt);
            }
        });
        getContentPane().add(Caixa_senha);
        Caixa_senha.setBounds(30, 320, 370, 25);

        Botton_entrar.setBackground(new java.awt.Color(235, 235, 235));
        Botton_entrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/botao_login.png"))); // NOI18N
        Botton_entrar.setBorder(null);
        Botton_entrar.setContentAreaFilled(false);
        Botton_entrar.setOpaque(false);
        Botton_entrar.setRequestFocusEnabled(false);
        Botton_entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Botton_entrarActionPerformed(evt);
            }
        });
        getContentPane().add(Botton_entrar);
        Botton_entrar.setBounds(310, 590, 90, 40);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Botton_entrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Botton_entrarActionPerformed
        try {
            String usuario_login, usuario_senha;
            usuario_login = Caixa_login.getText();
            usuario_senha = Caixa_senha.getText();
            
            Login_bean loginBean = new Login_bean();
            loginBean.setUsuario(usuario_login);
            loginBean.setSenha(usuario_senha);
            
            int max = 0;
            while (max <= 2){ //se adicionar mais um nível de acesso, prestar atenção neste trecho
                loginBean.setNivel(max); //primeiro o sistema vai tentar logar como usuário normal
                Login_dao loginDao = new Login_dao();
                ResultSet rsLoginDao = loginDao.autenticaUsuario(loginBean);

                if(rsLoginDao.next()){
                    dispose();
                    if (max == 0){
                        System.out.println("ADMIN!!!!!");
                        Jhome jhome = new Jhome(true, usuario_login);
                        jhome.setVisible(true);
                    }else{
                        System.out.println("USUÁRIO COMUM!!!!!!");
                        Jhome jhome = new Jhome(false, usuario_login);
                        jhome.setVisible(true);
                        }
                    return;
                } else {
                    if (max > 1){
                    JOptionPane.showMessageDialog(null,"Usuario ou senha incorretos");
                    }
                    max++;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro em tela de login "+e);
        }
    }//GEN-LAST:event_Botton_entrarActionPerformed

    private void Caixa_senhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Caixa_senhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Caixa_senhaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Jlogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jlogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jlogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jlogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Jlogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Botton_entrar;
    private javax.swing.JTextPane Caixa_login;
    private javax.swing.JPasswordField Caixa_senha;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
