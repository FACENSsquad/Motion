/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TELA;

import BEAN.Produtos_bean;
import DAO.Produtos_dao;
import javax.swing.JOptionPane;

public class Jcadastrar_produto extends javax.swing.JFrame {

    private Object Unidades;

    public Jcadastrar_produto() {
        initComponents();
        
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        produto = new javax.swing.JLabel();
        Caixa_produto = new javax.swing.JTextField();
        NCM = new javax.swing.JLabel();
        Caixa_ncm = new javax.swing.JTextField();
        unidade = new javax.swing.JLabel();
        Campo_unidade = new javax.swing.JComboBox<>();
        bt_cadastrar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("cadasto de produtos"); // NOI18N
        setPreferredSize(new java.awt.Dimension(700, 600));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(208, 214, 216));

        titulo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        titulo.setForeground(new java.awt.Color(0, 0, 0));
        titulo.setText("CADASTRO DE PRODUTO");

        produto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        produto.setForeground(new java.awt.Color(0, 0, 0));
        produto.setText("Produto:");

        Caixa_produto.setBackground(new java.awt.Color(255, 255, 255));
        Caixa_produto.setBorder(null);
        Caixa_produto.setPreferredSize(new java.awt.Dimension(0, 25));
        Caixa_produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Caixa_produtoActionPerformed(evt);
            }
        });

        NCM.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        NCM.setForeground(new java.awt.Color(0, 0, 0));
        NCM.setText("NCM:");

        Caixa_ncm.setBackground(new java.awt.Color(255, 255, 255));
        Caixa_ncm.setBorder(null);
        Caixa_ncm.setPreferredSize(new java.awt.Dimension(0, 25));

        unidade.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        unidade.setForeground(new java.awt.Color(0, 0, 0));
        unidade.setText("Un:");

        Campo_unidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CX", "UN", "EM", "PT" }));
        Campo_unidade.setSelectedItem(Unidades);
        Campo_unidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Campo_unidadeActionPerformed(evt);
            }
        });

        bt_cadastrar.setBackground(new java.awt.Color(196, 196, 196));
        bt_cadastrar.setForeground(new java.awt.Color(196, 196, 196));
        bt_cadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/botao_salvar.png"))); // NOI18N
        bt_cadastrar.setBorder(null);
        bt_cadastrar.setBorderPainted(false);
        bt_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cadastrarActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(208, 214, 216));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/botao_cancelar.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_cadastrar)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Caixa_ncm, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Caixa_produto, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(107, 107, 107)
                                .addComponent(Campo_unidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(produto)
                                .addGap(366, 366, 366)
                                .addComponent(unidade))
                            .addComponent(NCM))
                        .addGap(0, 80, Short.MAX_VALUE)))
                .addGap(68, 68, 68))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(229, 229, 229)
                .addComponent(titulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo)
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(unidade)
                    .addComponent(produto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Campo_unidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Caixa_produto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(NCM)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Caixa_ncm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 274, Short.MAX_VALUE)
                        .addComponent(bt_cadastrar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(89, 89, 89))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 710, 610);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cadastrarActionPerformed
        
        try {
        String nome_produto, unidade, ncm;
        nome_produto = Caixa_produto.getText();
        ncm = Caixa_ncm.getText();
        unidade = (String) Campo_unidade.getSelectedItem();
        
        Produtos_bean p_bean = new Produtos_bean();
        p_bean.setProduto(nome_produto);
        p_bean.setUnidade(unidade);
        p_bean.setNcm(ncm);
        
        
        
        
        Produtos_dao p_dao = new Produtos_dao();
        p_dao.inserir(p_bean);
        
        //Limpando caixas de texto
        Caixa_produto.setText("");
        Caixa_ncm.setText("");
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro ao cadastrar produto");
        } 
        this.dispose();
        
        
        
    }//GEN-LAST:event_bt_cadastrarActionPerformed

    private void Campo_unidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Campo_unidadeActionPerformed
       // String tipo_produto = Campo_tipo.getSelectedItem().toString();
    }//GEN-LAST:event_Campo_unidadeActionPerformed

    private void Caixa_produtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Caixa_produtoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Caixa_produtoActionPerformed

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
            java.util.logging.Logger.getLogger(Jcadastrar_produto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jcadastrar_produto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jcadastrar_produto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jcadastrar_produto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Jcadastrar_produto().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Caixa_ncm;
    private javax.swing.JTextField Caixa_produto;
    private javax.swing.JComboBox<String> Campo_unidade;
    private javax.swing.JLabel NCM;
    private javax.swing.JButton bt_cadastrar;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel produto;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel unidade;
    // End of variables declaration//GEN-END:variables
}
