
package TELA;

import BEAN.Produtos_bean;
import CONEXAO.Conexao;
import DAO.Produtos_dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import javax.swing.JOptionPane;

public class Jinserir_pedido extends javax.swing.JFrame {

    private Object Unidades;
    private Conexao conexao;
    private Connection conn;
    
    public void conexao_cadastrar(){
     this.conexao = new Conexao();
     this.conn = this.conexao.Bd_Conexao();
    }

    public Jinserir_pedido() {
        initComponents();
        //conexao_cadastrar();
       
        
       
    }

    public void update (){
    
        String sql = "update produto set produto = ?, unidade = ?, ncm = ? "
               + "where codigo = ?;";
        try {
            PreparedStatement pst2 = this.conn.prepareStatement(sql);
            pst2.setString(1, Caixa_produto.getText());
            //pst2.setString(2, (String) Campo_unidade.getSelectedItem());
            //pst2.setString(3, Caixa_ncm.getText());
            pst2.setInt(4, Integer.parseInt(Caixa_codigo.getText()));
            pst2.execute();
            
            JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso");
            
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null,"Erro em classe Produtos_dao UPDATE");
        }  
    }
    
    
    public void consultar (){
    
        String sql = "select * from produto where codigo = ?;";
        ResultSet rs;
        
        try { 
            PreparedStatement pst3 = this.conn.prepareStatement(sql);
            pst3.setString(1, Caixa_codigo.getText());
            rs = pst3.executeQuery();
            
            if (rs.next()) {
                
              Caixa_produto.setText(rs.getString(2));
              //Campo_unidade.setSelectedItem(3);
              //Caixa_ncm.setText(rs.getString(4));
              
                
                
            } else {
                JOptionPane.showMessageDialog(null,"Produto não encontrado");
                
               Caixa_produto.setText(null);
              //Campo_unidade.setSelectedItem(null);
              //Caixa_ncm.setText(null);
            }
            
            
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro em metodo CONSULTAR");
        }
        

    }
    
    public void delete(){
        
        int confirmar;
        String message = "Deseja realmente remover este produto?";
        
        confirmar = JOptionPane.showConfirmDialog(null, message);
       
        
        if(confirmar == JOptionPane.YES_OPTION){
            
        String sql = "delete from produto where codigo = ?";
        try {
             PreparedStatement pst = this.conn.prepareStatement(sql);
             pst.setString(1, Caixa_codigo.getText());
             pst.executeUpdate();
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro em metodo DELETE");
            System.out.println(e);
                if (e instanceof SQLIntegrityConstraintViolationException){
                JOptionPane.showMessageDialog(null,"Possivelmente o item que você está tentando deletar está contido dentro de um LOTE. Tente apagar o lote desse produto e tente novamente.");
                }
            
        }
    } else if(confirmar == JOptionPane.NO_OPTION) {
     dispose();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        produto1 = new javax.swing.JLabel();
        Caixa_produto1 = new javax.swing.JTextField();
        decrição = new javax.swing.JLabel();
        descricao = new javax.swing.JTextField();
        produto = new javax.swing.JLabel();
        Caixa_produto = new javax.swing.JTextField();
        bt_cadastrar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        Botton_consultar = new javax.swing.JToggleButton();
        Codigo = new javax.swing.JLabel();
        Caixa_codigo = new javax.swing.JTextField();
        titulo1 = new javax.swing.JLabel();
        Botton_Atualizar = new javax.swing.JToggleButton();
        Botton_deletar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(697, 515));
        setName("cadasto de produtos"); // NOI18N
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(208, 214, 216));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 550));
        jPanel1.setLayout(null);

        titulo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        titulo.setForeground(new java.awt.Color(0, 0, 0));
        titulo.setText("Atualizar ou Deletar ");
        jPanel1.add(titulo);
        titulo.setBounds(270, 290, 180, 22);

        produto1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        produto1.setForeground(new java.awt.Color(0, 0, 0));
        produto1.setText("Quantidade:");
        jPanel1.add(produto1);
        produto1.setBounds(470, 80, 80, 17);

        Caixa_produto1.setBackground(new java.awt.Color(255, 255, 255));
        Caixa_produto1.setBorder(null);
        Caixa_produto1.setPreferredSize(new java.awt.Dimension(0, 25));
        Caixa_produto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Caixa_produto1ActionPerformed(evt);
            }
        });
        jPanel1.add(Caixa_produto1);
        Caixa_produto1.setBounds(470, 100, 90, 25);

        decrição.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        decrição.setForeground(new java.awt.Color(0, 0, 0));
        decrição.setText("Descrição:");
        jPanel1.add(decrição);
        decrição.setBounds(100, 140, 70, 17);

        descricao.setBackground(new java.awt.Color(255, 255, 255));
        descricao.setForeground(new java.awt.Color(0, 0, 0));
        descricao.setBorder(null);
        jPanel1.add(descricao);
        descricao.setBounds(100, 160, 310, 50);

        produto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        produto.setForeground(new java.awt.Color(0, 0, 0));
        produto.setText("Produto:");
        jPanel1.add(produto);
        produto.setBounds(100, 78, 54, 17);

        Caixa_produto.setBackground(new java.awt.Color(255, 255, 255));
        Caixa_produto.setBorder(null);
        Caixa_produto.setPreferredSize(new java.awt.Dimension(0, 25));
        Caixa_produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Caixa_produtoActionPerformed(evt);
            }
        });
        jPanel1.add(Caixa_produto);
        Caixa_produto.setBounds(100, 101, 313, 25);

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
        jPanel1.add(bt_cadastrar);
        bt_cadastrar.setBounds(490, 230, 85, 40);

        jButton1.setBackground(new java.awt.Color(208, 214, 216));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/botao_cancelar.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jPanel1.add(jButton1);
        jButton1.setBounds(390, 230, 80, 40);

        Botton_consultar.setBackground(new java.awt.Color(255, 255, 255));
        Botton_consultar.setForeground(new java.awt.Color(51, 51, 51));
        Botton_consultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/lupa.png"))); // NOI18N
        Botton_consultar.setBorder(null);
        Botton_consultar.setBorderPainted(false);
        Botton_consultar.setContentAreaFilled(false);
        Botton_consultar.setFocusCycleRoot(true);
        Botton_consultar.setFocusTraversalPolicyProvider(true);
        Botton_consultar.setRequestFocusEnabled(false);
        Botton_consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Botton_consultarActionPerformed(evt);
            }
        });
        jPanel1.add(Botton_consultar);
        Botton_consultar.setBounds(320, 375, 30, 20);

        Codigo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Codigo.setForeground(new java.awt.Color(0, 0, 0));
        Codigo.setText("Codigo:");
        jPanel1.add(Codigo);
        Codigo.setBounds(100, 350, 60, 17);

        Caixa_codigo.setBackground(new java.awt.Color(255, 255, 255));
        Caixa_codigo.setBorder(null);
        Caixa_codigo.setPreferredSize(new java.awt.Dimension(4, 25));
        Caixa_codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Caixa_codigoActionPerformed(evt);
            }
        });
        jPanel1.add(Caixa_codigo);
        Caixa_codigo.setBounds(100, 370, 249, 25);

        titulo1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        titulo1.setForeground(new java.awt.Color(0, 0, 0));
        titulo1.setText("INSERIR PEDIDO");
        jPanel1.add(titulo1);
        titulo1.setBounds(280, 20, 150, 22);

        Botton_Atualizar.setBackground(new java.awt.Color(208, 214, 216));
        Botton_Atualizar.setForeground(new java.awt.Color(51, 51, 51));
        Botton_Atualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/botao_atualizar.png"))); // NOI18N
        Botton_Atualizar.setBorder(null);
        Botton_Atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Botton_AtualizarActionPerformed(evt);
            }
        });
        jPanel1.add(Botton_Atualizar);
        Botton_Atualizar.setBounds(500, 420, 80, 40);

        Botton_deletar.setBackground(new java.awt.Color(209, 214, 216));
        Botton_deletar.setForeground(new java.awt.Color(0, 0, 0));
        Botton_deletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/botao_deletar.png"))); // NOI18N
        Botton_deletar.setBorder(null);
        Botton_deletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Botton_deletarActionPerformed(evt);
            }
        });
        jPanel1.add(Botton_deletar);
        Botton_deletar.setBounds(400, 420, 80, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 700, 550);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void bt_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cadastrarActionPerformed
        
        try {
        String nome_produto, unidade, ncm;
        nome_produto = Caixa_produto.getText();
        //ncm = Caixa_ncm.getText();
        //unidade = (String) Campo_unidade.getSelectedItem();
        
        Produtos_bean p_bean = new Produtos_bean();
        p_bean.setProduto(nome_produto);
        //p_bean.setUnidade(unidade);
        //p_bean.setNcm(ncm);
        
        
        
        
        Produtos_dao p_dao = new Produtos_dao();
        p_dao.inserir(p_bean);
        
        //Limpando caixas de texto
        Caixa_produto.setText("");
        //Caixa_ncm.setText("");
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro ao cadastrar produto");
        } 
        this.dispose();
        
        
        
    }//GEN-LAST:event_bt_cadastrarActionPerformed

    private void Caixa_produtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Caixa_produtoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Caixa_produtoActionPerformed

    @SuppressWarnings("empty-statement")
    private void Botton_consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Botton_consultarActionPerformed
        
     consultar();
    }//GEN-LAST:event_Botton_consultarActionPerformed

    private void Caixa_codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Caixa_codigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Caixa_codigoActionPerformed

    private void Botton_AtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Botton_AtualizarActionPerformed
        update();
        
        dispose();
    }//GEN-LAST:event_Botton_AtualizarActionPerformed

    private void Botton_deletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Botton_deletarActionPerformed
         delete();
         
         dispose();
    }//GEN-LAST:event_Botton_deletarActionPerformed

    private void Caixa_produto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Caixa_produto1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Caixa_produto1ActionPerformed

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
            java.util.logging.Logger.getLogger(Jinserir_pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jinserir_pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jinserir_pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jinserir_pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Jinserir_pedido().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton Botton_Atualizar;
    private javax.swing.JToggleButton Botton_consultar;
    private javax.swing.JButton Botton_deletar;
    private javax.swing.JTextField Caixa_codigo;
    private javax.swing.JTextField Caixa_produto;
    private javax.swing.JTextField Caixa_produto1;
    private javax.swing.JLabel Codigo;
    private javax.swing.JButton bt_cadastrar;
    private javax.swing.JLabel decrição;
    private javax.swing.JTextField descricao;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel produto;
    private javax.swing.JLabel produto1;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel titulo1;
    // End of variables declaration//GEN-END:variables
}
