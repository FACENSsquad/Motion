
package TELA;

import BEAN.Pedido_bean;
import CONEXAO.Conexao;
import DAO.Pedido_dao;
import static java.lang.Integer.parseInt;
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
            pst2.setString(1, codigo_produto.getText());
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
                
              codigo_produto.setText(rs.getString(2));
              //Campo_unidade.setSelectedItem(3);
              //Caixa_ncm.setText(rs.getString(4));
              
                
                
            } else {
                JOptionPane.showMessageDialog(null,"Produto não encontrado");
                
               codigo_produto.setText(null);
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
        c_lote = new javax.swing.JTextField();
        decrição = new javax.swing.JLabel();
        c_descrição = new javax.swing.JTextField();
        produto = new javax.swing.JLabel();
        codigo_produto = new javax.swing.JTextField();
        bt_cadastrar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        Botton_consultar = new javax.swing.JToggleButton();
        Codigo = new javax.swing.JLabel();
        Caixa_codigo = new javax.swing.JTextField();
        titulo1 = new javax.swing.JLabel();
        Botton_Atualizar = new javax.swing.JToggleButton();
        Botton_deletar = new javax.swing.JButton();
        c_quantidade = new javax.swing.JTextField();
        produto3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(697, 515));
        setName("cadasto de produtos"); // NOI18N
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(208, 214, 216));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 550));
        jPanel1.setLayout(null);

        titulo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        titulo.setText("Atualizar ou Deletar ");
        jPanel1.add(titulo);
        titulo.setBounds(280, 350, 180, 22);

        produto1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        produto1.setText("Lote:");
        jPanel1.add(produto1);
        produto1.setBounds(290, 80, 80, 17);

        c_lote.setBorder(null);
        c_lote.setPreferredSize(new java.awt.Dimension(0, 25));
        c_lote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_loteActionPerformed(evt);
            }
        });
        jPanel1.add(c_lote);
        c_lote.setBounds(290, 100, 90, 25);

        decrição.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        decrição.setText("Descrição:");
        jPanel1.add(decrição);
        decrição.setBounds(100, 150, 70, 17);

        c_descrição.setBorder(null);
        jPanel1.add(c_descrição);
        c_descrição.setBounds(100, 170, 450, 100);

        produto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        produto.setText("Código do produto:");
        jPanel1.add(produto);
        produto.setBounds(100, 78, 260, 17);

        codigo_produto.setBorder(null);
        codigo_produto.setPreferredSize(new java.awt.Dimension(0, 25));
        codigo_produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigo_produtoActionPerformed(evt);
            }
        });
        jPanel1.add(codigo_produto);
        codigo_produto.setBounds(100, 101, 130, 25);

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
        bt_cadastrar.setBounds(500, 290, 85, 40);

        jButton1.setBackground(new java.awt.Color(208, 214, 216));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/botao_cancelar.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(400, 290, 80, 40);

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
        Codigo.setText("Codigo:");
        jPanel1.add(Codigo);
        Codigo.setBounds(110, 410, 60, 17);

        Caixa_codigo.setBorder(null);
        Caixa_codigo.setPreferredSize(new java.awt.Dimension(4, 25));
        Caixa_codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Caixa_codigoActionPerformed(evt);
            }
        });
        jPanel1.add(Caixa_codigo);
        Caixa_codigo.setBounds(110, 430, 249, 25);

        titulo1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
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
        Botton_Atualizar.setBounds(510, 480, 80, 40);

        Botton_deletar.setBackground(new java.awt.Color(209, 214, 216));
        Botton_deletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/botao_deletar.png"))); // NOI18N
        Botton_deletar.setBorder(null);
        Botton_deletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Botton_deletarActionPerformed(evt);
            }
        });
        jPanel1.add(Botton_deletar);
        Botton_deletar.setBounds(410, 480, 80, 40);

        c_quantidade.setBorder(null);
        c_quantidade.setPreferredSize(new java.awt.Dimension(0, 25));
        c_quantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_quantidadeActionPerformed(evt);
            }
        });
        jPanel1.add(c_quantidade);
        c_quantidade.setBounds(460, 100, 90, 25);

        produto3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        produto3.setText("Quantidade:");
        jPanel1.add(produto3);
        produto3.setBounds(460, 80, 100, 17);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 700, 550);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void bt_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cadastrarActionPerformed
        
        try {
            String lote, Produto, quantidade, descricao;
            
            lote = c_lote.getText();
            Produto = codigo_produto.getText();
            quantidade = c_quantidade.getText();
            descricao = c_descrição.getText();

             
             Pedido_bean p_bean = new Pedido_bean();
             p_bean.setLote(parseInt(lote));
             p_bean.setProduto(parseInt(Produto));
             p_bean.setQuantidade(parseInt(quantidade));
             p_bean.setDescricao(descricao);        
             
             Pedido_dao p_dao =  new Pedido_dao();
             p_dao.inserir(p_bean);
             
             codigo_produto.setText("");
             c_lote.setText("");
             c_quantidade.setText("");
             c_descrição.setText("");
            
        } catch (Exception e) {
       JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente");
        }
        dispose();
        
        
    }//GEN-LAST:event_bt_cadastrarActionPerformed

    private void codigo_produtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigo_produtoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigo_produtoActionPerformed

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

    private void c_loteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_loteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_loteActionPerformed

    private void c_quantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_quantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_quantidadeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JLabel Codigo;
    private javax.swing.JButton bt_cadastrar;
    private javax.swing.JTextField c_descrição;
    private javax.swing.JTextField c_lote;
    private javax.swing.JTextField c_quantidade;
    private javax.swing.JTextField codigo_produto;
    private javax.swing.JLabel decrição;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel produto;
    private javax.swing.JLabel produto1;
    private javax.swing.JLabel produto3;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel titulo1;
    // End of variables declaration//GEN-END:variables
}
